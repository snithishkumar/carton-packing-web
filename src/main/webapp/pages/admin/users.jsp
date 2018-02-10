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

    <title>PLI - Pack Product</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../dist/css/sb-admin-2.css" rel="stylesheet">

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
     
var userGuidVar;
$(document).on("click", "#userTable tr td", function(e) {
	if(this.id){
		var colorData = $.parseJSON(this.id);
		console.log(colorData);
		$("#fullName").val(colorData.name);
		$("#email").val(colorData.email);
		$("#password").val(colorData.password);
		$("#role").val(colorData.role);
		$("#mobileNumber").val(colorData.mobileNumber);
		userGuidVar = colorData.userGuid;
		$("#addUser").val("Edit User");
		//addGroup
	}
    
});

     $(document).ready(function(){
    	 getUsersList();
 		$("#addUser").click(function(){
 			createUser();
   	 });
 	
 });
     
     function createUser(){
    	 var fullName = $("#fullName").val();
    	 var email = $("#email").val();
    	 var password = $("#password").val();
    	 var role = $("#role").val();
    	 var mobileNumber =  $("#mobileNumber").val();
    	 
    	 var arr;
    	 if(userGuidVar){
    		 arr = {name:fullName,email:email,password:password,role:role,mobileNumber:mobileNumber,userGuid:userGuidVar};
    	 }else{
    		 arr = {name:fullName,email:email,password:password,role:role,mobileNumber:mobileNumber};
    	 }
    	
    	 $.ajax({
        	 
    		 type: 'POST',
    		    data: JSON.stringify(arr),
    		    url: "addUser.html",
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
     
 function getUsersList(){
	 
	 $.ajax({
		 type: "GET",
	       url: "getUsersList.html",
	       contentType: "application/json; charset=utf-8",
	       dataType: "json",
	       success: function (results) {
	    	   console.log(results);
	    	   var success = results.statusCode;
	    	   if(success === 200){
	    		   var finaldata = "<thead><tr><th>ID</th><th>Name</th><th>Email</th><<th>Mobile Number</th>t<th>User Role</th><th>Edit/Delete</th></tr></thead></tbody>";
	    		   var data = results.data;
	         		//data = jQuery.parseJSON(data);
	         		for(var i = 0; i < data.length; i++){
	         			var pos = i + 1;
	         			var value = data[i];
	         			finaldata = finaldata+ 	"<tr><td>"+pos+"</td><td>"+value.name+"</td><td>"+value.email+"</td><td>"+value.mobileNumber+"</td><td>"+value.role+"</td><td id ='"+JSON.stringify(value)+"'>Edit</td></tr>";
	         		}
	         		finaldata = finaldata + "</table>";
	         		
	         		$("#userTable").html(finaldata);
	        		$("#userTable").DataTable();
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

        <!-- Navigation -->
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
                    <h1 class="page-header">Manage Users</h1>
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
      <li class="active">Users</li>
    </ol>
    </section> 
    <!-- Main content -->
    <section class="content"> 
    <!-- Default box -->
    <div class="box"> 
      <div class="box-header with-border"> 
        <h3 class="box-title">Add User</h3>
       
      </div>
      <div class="box-body"> 
        <form action="registration" method="post">
          <div class="form-group has-feedback"> 
		  <label>Full Name </label>
            <input type="text" required maxlength="50" onKeyUp="chText()" onKeyDown="chText()" id="fullName"  name = "fullName" class="form-control" placeholder="Full name" />
            <span class="glyphicon glyphicon-user form-control-feedback"></span> 
          </div>
          <div class="form-group has-feedback"> 
		  	<label>Email(Username) </label>
            <input type="email"  required maxlength="50" id = "email"  name = "email" class="form-control" onblur="checkEmail()" placeholder="Email" />
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span> 
          </div>
          <div class="form-group has-feedback"> 
		  <label>Password </label>

            <input type="password" required  maxlength="50" id="password" name = "password" class="form-control" placeholder="Password" />
            <span class="glyphicon glyphicon-lock form-control-feedback"></span> 
          </div>
          <div class="form-group has-feedback"> 
		  <label>Mobile Number</label>
            <input type="text" required maxlength="50" onKeyUp="chText()" onKeyDown="chText()" id="mobileNumber"  name = "mobileNumber" class="form-control" placeholder="Mobile Number" />
            <span class="glyphicon glyphicon-user form-control-feedback"></span> 
          </div>
          <div class="form-group has-feedback">
		  <label>Role </label>
		  
            <input type="text" required maxlength="50" onKeyUp="chText()" onKeyDown="chText()" id="role" required name = "role" class="form-control" placeholder="Role" />
                            
            <span class="glyphicon glyphicon-user form-control-feedback"></span> 
          </div>
          <div class="row"> 
           <div class="form-actions no-margin-bottom" style="text-align:center;"> 
            <input type="button" id="addUser" value="Add User" class="btn btn-primary btn-lg " />
            </div>
            <!-- /.col -->
          </div>
        </form>
      </div>
      <!-- /.box-body -->
      <div class="box-footer">  </div>
      <!-- /.box-footer-->
    </div>
    <!-- /.box -->
    <div class="box"> 
      <div class="box-header with-border"> 
        <h3 class="box-title">User List</h3>
        <div class="box-tools pull-right"> 
          <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
          <button class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div>
      </div>
      <div class="box-body"> 
        <div class="row"> 
          <div class="col-xs-12"> 
            <div class="box"> 
              <!-- /.box-header -->
              <div class="box-body"> 
                <table id="userTable" class="table table-bordered table-striped">
                  <thead>
                    <tr> 
                      <th>Name</th>
                      <th>Email</th>
                      <th>Password</th>
                      <th>User Role</th>
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
   

  </body>
</html>
