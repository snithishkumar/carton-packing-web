<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>P&I - Products</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../dist/css/sb-admin-2.css" rel="stylesheet">
    
   <link href="../../plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    

    <!-- Morris Charts CSS -->
    <link href="../../bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 <script type="text/javascript" src="../../js/jquery-2.1.3.min.js"></script>
  <script>
  
  
  var productGuidVar;
  $(document).on("click", "#productTable tr td", function(e) {
  	if(this.id){
  		var productData = $.parseJSON(this.id);
  		console.log(productData);
  		$("#group").val(productData.productGroupGuid);
  	 	$("#productCategory").val(productData.productCategoryGuid);
  	 	 $("#color").val(productData.colorGuid);
  	 	$("#productName").val(productData.productName);
  	 	 $("#unitPrice").val(productData.unitPrice);
  	 	$("#productNotes").val(productData.productNotes);
  	 	productGuidVar = productData.productGuid;
  	 	console.log(productGuidVar);
  		$("#saveProduct").val("Edit Product");
  		//addGroup
  	}
      
  });
  
  $(document).ready(function(){
		//saveProduct
		
		$("#saveProduct").click(function(){
			createOrder();
   	 });
		getProductGroupList();
		getCategoryList();
		getColorList();
		 getProductList();
	
});
  
  function createOrder(){
	  var group = $("#group").val();
 	 var productCategory = $("#productCategory").val();
 	 var color = $("#color").val();
 	 var productName = $("#productName").val();
 	 var unitPrice = $("#unitPrice").val();
 	 var productNotes = $("#productNotes").val();
 	 var arr;
 	 if(productGuidVar){
 		arr = {productGroupGuid:group,productCategoryGuid:productCategory,colorGuid:color,productName:productName,unitPrice:unitPrice,productNotes:productNotes,productGuid:productGuidVar};
 	 }else{
 		arr = {productGroupGuid:group,productCategoryGuid:productCategory,colorGuid:color,productName:productName,unitPrice:unitPrice,productNotes:productNotes}; 
 	 }
 	console.log(arr);
 	 $.ajax({
     	 
 		 type: 'POST',
 		    data: JSON.stringify(arr),
 		    url: "createProduct.html",
 		    contentType: 'application/json; charset=utf-8',
 		    dataType: 'json',
 		    async: false,
 		    success: function (results) {
 		    	 location.reload();
 		    },error: function (results) {
 		    	 location.reload();
 		    }
 	 });
  }
  
  function getProductGroupList()
  {
  	$.ajax({
  	type: "GET",
     url: "getProductGroupsDropDown.html",
     contentType: "application/json; charset=utf-8",
     dataType: "json",    
      success: function (results) {
      	console.log(results)
          var success = results.statusCode;
      	if(success === 200){        	
      		var finaldata = "";
      		finaldata = finaldata+ 	'<option value="" disabled selected>' + "Select Product Group";
   		var data = results.data;
    	//	data = jQuery.parseJSON(data);
    		for(var i = 0; i < data.length; i++){
    			var value = data[i];    
    			
    		finaldata = finaldata + '</option>'	+ '<option value="' + value.productGroupGuid + '">' + value.productGroups + '</option>';
    							       		}
  		$("#group").html(finaldata);
    	 }            
     },
     error: function (data) {       
  	   console.log('ajax call error');  	
         
     }
  });
  }
  
  function getCategoryList()
  {
  	$.ajax({
  	type: "GET",
     url: "getProductCategoryDropDown.html",
     contentType: "application/json; charset=utf-8",
     dataType: "json",    
      success: function (results) {
      	console.log(results)
         var success = results.statusCode;
      	if(success === 200){        	
      		var finaldata = "";
      		finaldata = finaldata+ 	'<option value="" disabled selected>' + "Select Product Category";
   		var data = results.data;
    	//	data = jQuery.parseJSON(data);
    		for(var i = 0; i < data.length; i++){
    			var value = data[i];    
    			
    		finaldata = finaldata + '</option>'	+ '<option value="' + value.productCategoryGuid + '">' + value.productCategorys + '</option>';
    							       		}
  		$("#productCategory").html(finaldata);
    	 }            
     },
     error: function (data) {       
  	   console.log('ajax call error');  	
         
     }
  });
  }
  
  function getColorList()
  {
  	$.ajax({
  	type: "GET",
     url: "getProductColorsDropDown.html",
     contentType: "application/json; charset=utf-8",
     dataType: "json",    
      success: function (results) {
      	console.log(results)
         var success = results.statusCode;
      	if(success === 200){        	
      		var finaldata = "";
      		finaldata = finaldata+'<option value="" disabled selected>' + "Select Color" + '</option>';
   		var data = results.data;
    		//data = jQuery.parseJSON(data);
    		for(var i = 0; i < data.length; i++){
    			var value = data[i];    
    			
    		finaldata = finaldata+  		'<option value="' + value.productColorGuid + '">' + value.productColors + '</option>';
    							       		}
  		$("#color").html(finaldata);


    	 }            
     },
     error: function (data) {       
  	   console.log('ajax call error');  	
         
     }
  });
  }
  
  function getProductList(){
	  $.ajax({
			 type: "GET",
		       url: "getProductList.html",
		       contentType: "application/json; charset=utf-8",
		       dataType: "json",
		       success: function (results) {
		    	   console.log(results);
		    	   var success = results.statusCode;
		    	   if(success === 200){
		    		   
		    		   var finaldata = "<thead><tr><th>Product ID</th><th>Product Group</th><th>Product Category</th><th>Product Color</th><th>Product</th><th>Edit/Delete</th></tr></thead></tbody>";
		    		   var data = results.data;
		         		//data = jQuery.parseJSON(data);
		         		for(var i = 0; i < data.length; i++){
		         			var value = data[i];
		         			finaldata = finaldata+ 	"<tr><td>"+value.productGroupName+"</td><td>"+value.productGroupName+"</td><td>"+value.productCategory+"</td><td>"+value.color+"</td><td>"+value.productName+"</td><td id ='"+JSON.stringify(value)+"'>Edit</td></tr>";
		         		}
		         		finaldata = finaldata + "</table>";
		         		
		         		$("#productTable").html(finaldata);
		        		$("#productTable").DataTable();
		    	   }
		       },
		       error: function (data) {       
		     	  // alert("fail");
		     	   console.log('ajax call error');  	
		            
		        }
		 });
  }
  </script>
  
</head>

<body>

     <div id="wrapper">

          <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
               
                <a class="navbar-brand" href="../../dashboard.jsp">P&I Manager</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
			<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Management
                    </a>
                    <ul class="dropdown-menu dropdown-user">
					<li>              
               <a href="manageproductGroup.jsp">Product Group</a>			   
                        </li> 
						<li class="divider"></li>
                       	 <li>              
               <a href="manageproductcategory.jsp">Product Category</a>			   
                        </li> 
						
						<li class="divider"></li>
                        
                       	 <li>              
               <a href="manageClients.jsp">Consignee</a>			   
                        </li> 
						   <li class="divider"></li>
                       	 <li>              
               <a href="managecompany.jsp">Company</a>			   
                        </li> 
						<li class="divider"></li>
                         <li>              
               <a href="managecolor.jsp">Color</a>			   
                        </li> 
						   <li class="divider"></li>
                       	 <li>              
               <a href="users.jsp">User</a>			   
                        </li> 
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
			 <li>              
               <a href="manageproducts.jsp">Products</a>			   
                        </li>   
                        <li>
               <a href="manageorders.jsp">Orders</a>
                        					
						
						<li>
						 <a href="../../index.jsp">Sign Out</a>
                        </li>
               
            </ul>
            <!-- /.navbar-top-links -->
  
        </nav>
            <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Manage Products</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
 <div class="content-wrapper"> 
  
    <!-- Content Header (Page header) -->
    <section class="content-header"> 
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      <li class="active">Products</li>
    </ol>
    </section> 
    <!-- Main content -->
    <section class="content"> 
    <!-- Default box -->
    <div class="box"> 
      <div class="box-header with-border"> 
        <h3 class="box-title">Add Product</h3>
       
      </div>
      <div class="box-body"> 
  <br>
  
  <div class="col-xs-4"> 
	<label>Product Group</label>
  <select id = "group" name = "group" class="form-control">
  <option value="" disabled selected>Select Product Group</option>   
                                      
  </select>	 
  </div>   
  
  <div  class="col-xs-4">
  <label>Product Category</label>
  <select id = "productCategory" name = "productCategory" class="form-control">
  <option value="" disabled selected>Select Product Category</option>   
                                       
  </select>	 
  </div>   
      
    <div class="col-xs-4"> 
	<label>Color</label>
  <select id = "color" name = "color" class="form-control">
  <option value="" disabled selected>Select Product Color</option>   
                                    
  </select>	 
  </div>   
         <br>
		 <br>
		 <br>
          <br>
		   
      <div class="col-xs-12"> 
	  	<label>Product Style</label> 
            <input type="text" required   id="productName" name = "productName" class="form-control" placeholder="Product Style" />
          </div>
		  <br>
		 <br>
		 <br>
		  <div class="col-xs-12"> 
		  	  	<label>Unit Price</label> 

            <input type="text"  id = "unitPrice"  name = "unitPrice" class="form-control"  placeholder="Unit Price" />
          </div>
		  <br>
		  <br>
		  <br>
		 <div class="col-xs-12" rows = "3"> 
		 <label>Product Notes</label> 

            <textarea  id = "productNotes"  name = "productNotes" class="form-control"  placeholder="Product Notes"></textarea>
          </div>
		  <br>
		  <br>
		  <br>
		  <br>
		  <br>
          <div class="row"> 
            <div class="form-actions no-margin-bottom" style="text-align:center;"> 
            <input type="submit" value="Add Product" id="saveProduct" class="btn btn-primary btn-lg " />
            </div>
            <!-- /.col -->
          </div>
      </div>
      <!-- /.box-body -->
      <!-- /.box-footer-->
    </div>
    <!-- /.box -->
    <div class="box"> 
      <div class="box-header with-border"> 
        <h3 class="box-title">Products List</h3>
        
      </div>
      <div class="box-body"> 
        <div class="row"> 
          <div class="col-xs-12"> 
            <div class="box"> 
              <!-- /.box-header -->
              <div class="box-body"> 
                <table id="productTable" class="table table-bordered table-striped">
                  <thead>
                    <tr> 
                      <th>Product ID</th>
					  <th>Product Group</th>
                      <th>Product Category</th>
                      <th>Product</th>
                      <th>Edit/Delete</th>
                    </tr>
                  </thead>
                  <!-- <tbody>
                    <tr> 
                      <td>Trident</td>
                      <td>sample@samle.com</td>
                      <td>123456</td>
                      <td>admin</td>
                      <td><button class="btn btn-block btn-primary btn-flat">View/Edit</button>
                        <button class="btn btn-block btn-danger btn-flat">Delete</button></td>
                    </tr>
                    <tr> 
                      <td>Trident</td>
                      <td>sample@samle.com</td>
                      <td>123456</td>
                      <td>admin</td>
                      <td><button class="btn btn-block btn-primary btn-flat">View/Edit</button>
                        <button class="btn btn-block btn-danger btn-flat">Delete</button></td>
                    </tr>
                  </tbody>
                  <tfoot>
                    <tr> 
                      <th>Name</th>
                      <th>Email</th>
                      <th>Password</th>
                      <th>User Role</th>
                      <th>Edit/Delete</th>
                    </tr>
                  </tfoot> -->
                </table>
              </div>
              <!-- /.box-body -->
            </div>
            <!-- /.box -->
          </div>
        </div>
      </div>
      <!-- /.box-body -->
      <div class="box-footer">  </div>
      <!-- /.box-footer-->
    </div>
    </section> 
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->   
 

    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="../../plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="../../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		
	    <!-- DATA TABES SCRIPT -->
    <script src="../../plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="../../plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>

    <!-- SlimScroll -->
    <script src="../../plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src="../../plugins/fastclick/fastclick.min.js" type="text/javascript"></script>

	
    <!-- ERPADMIN App -->
    <script src="../../dist/js/app.min.js" type="text/javascript"></script>
    <!-- page script -->
    <script type="text/javascript">
      $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      });
    </script>

  </body>
</html>
