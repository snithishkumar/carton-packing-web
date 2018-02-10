<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>P&I - Dashboard</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="bower_components/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>



</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">

			<a class="navbar-brand" href="dashboard.jsp">P&I Manager</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Management </a>
				<ul class="dropdown-menu dropdown-user">
				<li>              
               <a href="pages/admin/manageproductGroup.jsp">Product Group</a>			   
                        </li> 
						<li class="divider"></li>
					<li><a href="pages/admin/manageproductcategory.jsp">Product
							Category</a></li>
					<li class="divider"></li>

					<li><a href="pages/admin/manageClients.jsp">Consignee</a></li>
					<li class="divider"></li>
					<li><a href="pages/admin/managecompany.jsp">Company</a></li>
					<li class="divider"></li>

					<li><a href="pages/admin/managecolor.jsp">Color</a></li>
					<li class="divider"></li>
					<li><a href="pages/admin/users.jsp">User</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<li><a href="pages/admin/manageproducts.jsp">Products</a></li>
			<li><a href="pages/admin/manageorders.jsp">Orders</a></li>



			<li><a href="index.jsp">Sign Out</a></li>

		</ul>
		<!-- /.navbar-top-links --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
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
					<li class="active">P&I Manager</li>
				</ol>
				</section>
				<!-- Main content -->
				<section class="content"> <!-- /.box -->
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">Invoices</h3>
						<div class="box-tools pull-right"></div>
					</div>
					<div class="box-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="box">
									<!-- /.box-header -->
									<div class="box-body">
										<table id="invoiceTable"
											class="table table-bordered table-striped">
											<thead>
												<tr>
													<th>Invoice Id</th>
													<th>Invoice To</th>
													<th>Invoice Date</th>
													<th>update</th>
													<th>Invoice</th>
													<th>Packing List</th>
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


				</div>
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer"></div>
		<!-- /.box-footer-->
	</div>
	</section>
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<footer class="main-footer"> <!-- To the right -->
	<div class="pull-right hidden-xs">PLI Solution</div>
	<!-- Default to the left --> <strong>Copyright � 2016 <a
		href="#">Deudraa LTD</a>.
	</strong>All rights reserved. </footer>
	<!-- Control Sidebar -->

	<!-- Tab panes -->


	<!-- jQuery -->
	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="bower_components/raphael/raphael-min.js"></script>
	<script src="bower_components/morrisjs/morris.min.js"></script>
	<script src="js/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>


</body>

</html>
