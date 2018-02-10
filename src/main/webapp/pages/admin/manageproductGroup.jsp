<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PDI - productGroup</title>

<!-- Bootstrap Core CSS -->
<link href="../../bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../../bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="../../dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="../../bower_components/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="../../bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript" src="../../js/jquery-2.1.3.min.js"></script>

<script>
     var groupGuidVar;
$(document).on("click", "#colorTable tr td", function(e) {
	
	if(this.id){
		var groupData = $.parseJSON(this.id);
		console.log(groupData);
		$("#groupName").val(groupData.productGroups);
		$("#groupNotes").val(groupData.productGroupNotes);
		groupGuidVar = groupData.productGroupGuid
		$("#addGroup").val("Edit Group");
		//addGroup
	}
    
});

     $(document).ready(function(){
    	 getProductGroups();
    	 $("#addGroup").click(function(){
    		 createProductGroups();
    	 });
 });
     
     function createProductGroups(){
    	 var groupNameData = $("#groupName").val();
    	 var groupNotesData = $("#groupNotes").val();
    	 var arr;
    	 if(groupGuidVar){
    		 arr = {groupName:groupNameData,groupNotes:groupNotesData,groupGuid:groupGuidVar};
    	 }else{
    		 arr = {groupName:groupNameData,groupNotes:groupNotesData};
    	 }
    	 console.log(JSON.stringify(arr));
    	 $.ajax({
    		
        	 
    		 type: 'POST',
    		    data: JSON.stringify(arr),
    		    url: "addProductGroup.html",
    		    contentType: 'application/json; charset=utf-8',
    		    dataType: 'json',
    		    async: false,
    		    success: function (results) {
    		    	console.log('Success result',results);
    		    	 location.reload();
    		    },error: function (res) {
    		     	console.log('Failure result',res);
    		     	 location.reload();
    		    }
    	 });
    	 
     }
     
 function getProductGroups(){
	 $.ajax({
		   type: "GET",
	       url: "getProductGroupList.html",
	       contentType: "application/json; charset=utf-8",
	       dataType: "json",
	       success: function (results) {
	    	   console.log(results);
	    	   var success = results.statusCode;
	    	   if(success == 200){
	    		   var finaldata = "<thead><tr><th>ID</th><th>Product Group</th><th>Edit/Delete</th></tr></thead></tbody>";
	    		   var data = results.data;
	         		//data = jQuery.parseJSON(data);
	         		for(var i = 0; i < data.length; i++){
	         			var value = data[i];
	         			var pos = i + 1;
	         			finaldata = finaldata+ 	"<tr><td>"+pos+"</td><td>"+value.productGroups+"</td><td  id='"+JSON.stringify(value)+"'>Edit</td></tr>";
	         		}
	         		finaldata = finaldata + "</table>";
	         		
	         		$("#colorTable").html(finaldata);
	        		$("#colorTable").DataTable();
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

		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">

				<a class="navbar-brand" href="../../dashboard.jsp">P&I Manager</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Management </a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="manageproductGroup.jsp">Product Group</a></li>
						<li class="divider"></li>
						<li><a href="manageproductcategory.jsp">Product Category</a>
						</li>

						<li class="divider"></li>

						<li><a href="manageClients.jsp">Consignee</a></li>
						<li class="divider"></li>
						<li><a href="managecompany.jsp">Company</a></li>
						<li class="divider"></li>
						<li><a href="managecolor.jsp">Color</a></li>
						<li class="divider"></li>
						<li><a href="users.jsp">User</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<li><a href="manageproducts.jsp">Products</a></li>
				<li><a href="manageorders.jsp">Orders</a> <li>
						 <a href="../../index.jsp">Sign Out</a>
                        </li>
               
            </ul>
            <!-- /.navbar-top-links -->
  
        </nav>
            <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Manage Product Group</h1>
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
      <li class="active">Product Group</li>
    </ol>
    </section> 
    <!-- Main content -->
    <section class="content"> 
    <!-- Default box -->
    <div class="box"> 
      <div class="box-header with-border"> 
        <h3 class="box-title">Add Product Group</h3>
       
      </div>
      <div class="box-body"> 
  <br>
 
		  <div class="col-xs-12"> 
		  <label>Add Product Group</label>
            <input type="text" id="groupName" name="groupName"
										class="form-control" placeholder="Group Name" />
          </div>
		  <br>
		  <br>
		  <br>
		  <br>
		 
		 <div class="col-xs-12" rows="3"> 
		 <label>Product Group Notes</label>
            <input type="text" id="groupNotes" name="groupNotes"
										class="form-control" placeholder="Group Notes" />
          </div>
		  <br>
		  <br>
		  <br>
		  <br>
          <div class="row"> 
             <div class="form-actions no-margin-bottom"
										style="text-align:center;"> 
            <input type="button" id="addGroup" value="Add Group"
											class="btn btn-primary btn-lg " />
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
        <h3 class="box-title">Group List</h3>
        
      </div>
      <div class="box-body"> 
        <div class="row"> 
          <div class="col-xs-12"> 
            <div class="box"> 
              <!-- /.box-header -->
              <div class="box-body"> 
                <table id="colorTable"
												class="table table-bordered table-striped">
                  <thead>
                    <tr> 
                      <th>ID</th>
                      <th>Product Group</th>
                      <th>Edit/Delete</th>
                    </tr>
                  </thead>
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

    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->   
 

    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="../../plugins/jQuery/jQuery-2.1.4.min.js"
				type="text/javascript">
</script> <!-- Bootstrap 3.3.2 JS -->
    <script src="../../bootstrap/js/bootstrap.min.js"
						type="text/javascript"></script>
		
	    <!-- DATA TABES SCRIPT -->
    <script src="../../plugins/datatables/jquery.dataTables.min.js"
						type="text/javascript"></script>
    <script src="../../plugins/datatables/dataTables.bootstrap.min.js"
						type="text/javascript"></script>

    <!-- SlimScroll -->
    <script src="../../plugins/slimScroll/jquery.slimscroll.min.js"
						type="text/javascript"></script>
    <!-- FastClick -->
    <script src="../../plugins/fastclick/fastclick.min.js"
						type="text/javascript"></script>

	
    <!-- ERPADMIN App -->
    <script src="../../dist/js/app.min.js" type="text/javascript"></script>
    <!-- page script -->
    

  
				</body>
</html>
