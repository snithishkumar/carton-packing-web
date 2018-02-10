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

<title>PLI - Invoicing</title>

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
<link type="text/css" href="../../dist/css/styles-core.css"
	rel="stylesheet" />
<link type="text/css" href="../../dist/css/styles-core-responsive.css"
	rel="stylesheet" />
	
	<script src="../../plugins/jQuery/jQuery-2.1.4.min.js"
		type="text/javascript"></script>
	<!-- Bootstrap 3.3.2 JS -->
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
	



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->



<script type="text/javascript">//<![CDATA[
$(window).load(function(){
var $template = $(".template");
$( "#datepicker" ).datepicker();
var hash = 1;
$(".btn-add-panel").on("click", function () {
	
	var $newPanel = $template.clone();
    $newPanel.find(".collapse").removeClass("in");
    $newPanel.find(".accordion-toggle").attr("href", "#" + (++hash))
        .text("Carton #" + hash);
    $newPanel.find(".panel-collapse").attr("id", hash);
    $("#accordion").append($newPanel.fadeIn());
});


$(document).on('click', '.glyphicon-remove-circle', function () {
    $(this).parents('.panel').get(0).remove();
});
});//]]> 


$(document).on("click", "#orderTable tr td", function(e) {
	
	if(this.id){
		var orderData = $.parseJSON(this.id);
		console.log(orderData);
		$.ajax({
		   	 
			 type: 'POST',
			    data: orderData.orderGuid,
			    url: "getOrderDetails.html",
			    contentType: 'application/json; charset=utf-8',
			    success: function (results) {
			    	getOrderDetails(jQuery.parseJSON(results));
			    },error: function (results) {
			    	getOrderDetails(jQuery.parseJSON(results));
			    }
		 });
	}
    
});

function getOrderDetails(results){debugger;
	//getOrderDetails
	if(results.statusCode === 200){
		var orderDetailsData = results.data;
		var orderedItems = orderDetailsData.orderedItems;
		console.log(orderedItems);
		 $("#orderNumber").val(orderDetailsData.orderId);
		 $("#datepicker").val(orderDetailsData.orderedDate);
		 $("#exporter").val(orderDetailsData.clientName);
		 $("#consignee").val(orderDetailsData.clientName);
		for(var i = 0; i < orderedItems.length; i++){
			var tr = $('#tab_logic tr:last');
			var id = tr.attr('id').replace('addr','');
			var productGroupIdTem = "#productGroup"+id;
			var orderItemsVal = orderedItems[i];
			$("#productGroup"+id).val(orderItemsVal.productGroupGuid);
			 $("#productCategory"+id).val(orderItemsVal.productCategory);
			 $("#productStyle"+id).val(orderItemsVal.productStyleGuid);
			 $("#colorStyle"+id).val(orderItemsVal.colorStyleGuid);
			 $("#oneSize"+id).val(orderItemsVal.oneSize);
			 $("#xs"+id).val(orderItemsVal.xs);
			 $("#m"+id).val(orderItemsVal.m);
			 $("#l"+id).val(orderItemsVal.l);
			 $("#xl"+id).val(orderItemsVal.xl);
			 $("#xxl"+id).val(orderItemsVal.xxl);
			 $("#xxxl"+id).val(orderItemsVal.xxxl);
			 if(i < ((orderedItems.length) -1)){
				 addRows();
			 }
		}
	}
	
	
}

function orderCreations(){
	var T = document.getElementById('tab_logic');
	 jsonObj = [];
	$(T).find('> tbody > tr').each(function () {
		var id = $(this).attr('id').replace('addr','');
		item = {};
		item ["productGroupGuid"] = $("#productGroup"+id).val();
		item ["productGroup"] = $("#productGroup"+id).find("option:selected").text();
		item ["productCategoryGuid"] = $("#productCategory"+id).val();
		item ["productCategory"] = $("#productCategory"+id).find("option:selected").text();
		item ["productStyleGuid"] = $("#productStyle"+id).val();
		item ["productStyle"] = $("#productStyle"+id).find("option:selected").text();
		item ["colorStyleGuid"] = $("#colorStyle"+id).val();
		item ["colorStyle"] = $("#colorStyle"+id).find("option:selected").text();
		item ["oneSize"] = $("#oneSize"+id).val();
		item ["xs"] = $("#xs"+id).val();
		item ["m"] = $("#m"+id).val();
		item ["l"] = $("#l"+id).val();
		item ["xl"] = $("#xl"+id).val();
		item ["xxl"] = $("#xxl"+id).val();
		item ["xxxl"] = $("#xxxl"+id).val();
		
		if(item ["productGroup"]){
			jsonObj.push(item);
		}
	});
	
	requestJson = {};
	 
	requestJson["orderNumber"] =$("#orderNumber").val();
	requestJson["datepicker"] = $("#datepicker").val();
	requestJson["exporter"] = $("#exporter").val();
	requestJson["consignee"] = $("#consignee").val();
	requestJson["orderDetails"] = jsonObj;
	var jsonString = JSON.stringify(requestJson);
	console.log(jsonString);
	
	$.ajax({
   	 
		 type: 'POST',
		    data: jsonString,
		    url: "createOrders.html",
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

function getOrderListFromServer(){
	$.ajax({
		type : "GET",
		url : "getWebOrderList.html",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		async: false,
		success : function(results) {
			var success = results.statusCode;
			console.log("getWebOrderList",results);
			if (success === 200) {
				 var finaldata = "<thead><tr><th>ID</th><th>Order ID</th><th>Order Date</th><th>Order Status</th><th>Payment Status</th><th>Consignee</th><th>Edit/Delete</th></tr></thead></tbody>";
	    		   var data = results.data;
	         		//data = jQuery.parseJSON(data);
	         		for(var i = 0; i < data.length; i++){
	         			var pos = i + 1;
	         			var value = data[i];
	         			finaldata = finaldata+ 	"<tr><td>"+pos+"</td><td>"+value.orderId+"</td><td>"+value.orderedDate+"</td><td>"+value.orderStatus+"</td><td>"+value.paymentStatus+"</td><td>"+value.clientName+"</td><td id ='"+JSON.stringify(value)+"'>Edit</td></tr>";
	         		}
	         		finaldata = finaldata + "</table>";
	         		
	         		$("#orderTable").html(finaldata);
	        		$("#orderTable").DataTable();
			}
		},
		error : function(data) {
			console.log('ajax call error');

		}
	});
}

var groupOptions =  null;
var categoryOptions =  null;
var  colorStyleOptions = null;
var productStyleOptions =  null;

function getOrderCreationDetails(productGroupId,categoryGroupId,colorGroupId,productStyleId){
	$.ajax({
		type : "GET",
		url : "getOrderCreationDetails.html",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		async: false,
		success : function(results) {
			var success = results.statusCode;
			console.log(results);
			if (success === 200) {
				 groupOptions =  getProductGroupList(results,productGroupId);
				  categoryOptions =  getCategoryList(results,categoryGroupId);
				  colorStyleOptions =  getColorList(results,colorGroupId);
				  productStyleOptions =  getProductStyle(results,productStyleId);
				  setExporter(results);
				  setConsignee(results);
				  $("#orderNumber").val(results.data.orderId);
			}
		},
		error : function(data) {
			console.log('ajax call error');

		}
	});
}

  
$(document).ready(function(){
	
	$("#addOrder").click(function(){
		orderCreations();
	 });
	
	var i = 1;
	var tr = $('#tab_logic tr:last');
    i = tr.attr('id').replace('addr','');
    
    
    var productGroupId = '#productGroup'+i;
    var categoryGroupId = '#productCategory'+i;
    var productStyleId = '#productStyle'+i;
    var colorGroupId = '#colorStyle'+i;
    getOrderListFromServer();
  
	$("#add_row")
								.click(
										function() {
											addRows();
											
										});
						$("#delete_row")
								.click(
										function() {
											var tr = $('#tab_logic tr:last');
										    i = tr.attr('id').replace('addr','');
											if (i > 1) {
												$("table tr input:checked")
														.parents('tr').remove();
												var tr = $('#tab_logic tr:last');
												i = tr.attr('id').replace(
														'addr', '');
												//  i--;
												document
														.getElementById('countvalue').value = i;
											}
										});
						
						getOrderCreationDetails(productGroupId,
								categoryGroupId, colorGroupId, productStyleId);

					});
					
					
					function addRows(){
						var tr = $('#tab_logic tr:last');
						var i = parseInt(tr.attr('id').replace(
								'addr', ''));
						$('#addr' + i)
								.html(
										"<td>"
												+ (i + 1)
												+ "</td><td><input type ='CHECKBOX'></td><td><Select style='width: 220px' id= 'productGroup" +  (i + 1) + "' name='productGroup" +  (i + 1) + "'  placeholder='Product Group' class='form-control'><option>Product Group1</option></select></td><td><Select style='width: 220px'  id='productCategory" +  (i + 1) + "' name='productCategory" +  (i + 1) + "'  placeholder='Product Category' class='form-control'><option>Product Category1</option></select></td><td><Select style='width: 220px' id='productStyle" +  (i + 1) + "' name='productStyle" +  (i + 1) + "'  placeholder='Product Style' class='form-control'><option>Style1</option></select></td><td><Select style='width: 220px' type='text' id='colorStyle" + (i + 1) + "' name='colorStyle" + (i + 1) + "' id='colorStyle" + (i + 1) + "' placeholder='Color Style' class='form-control'> <option>Style1</option></select></td><td><input  name='oneSize" +  (i + 1) + "' type='text' placeholder='One Size'  class='form-control input-md'></td><td><input  name='xs" +  (i + 1) + "' type='text' placeholder='xs'  class='form-control input-md'></td><td><input  name='s" +  (i + 1) + "' type='text' placeholder='s'  class='form-control input-md'></td><td><input name='m" +  (i + 1) + "' type='text' placeholder='M' class='form-control input-md'  /></td><td><input name='l" +  (i + 1) + "' type='text' placeholder='L' class='form-control input-md'  /></td><td><input name='xl" +  (i + 1) + "' type='text' placeholder='XL' class='form-control input-md'  /></td><td><input name='xxl" +  (i + 1) + "' type='text' placeholder='XXL' class='form-control input-md'  /></td><td><input name='xxxl" +  (i + 1) + "' type='text' placeholder='XXXL' class='form-control input-md'  /></td>");
						$('#tab_logic').append(
								'<tr id="addr' + (i + 1)
										+ '"></tr>');
						document
								.getElementById('countvalue').value = i;
						var productGroupId = '#productGroup'
								+ (i + 1);
						var categoryGroupId = '#productCategory'
								+ (i + 1);
						 var productStyleId = '#productStyle'+(i + 1);
						var colorGroupId = '#colorStyle' + (i + 1);
					
						
						$(productGroupId).html(groupOptions);
						$(categoryGroupId).html(categoryOptions);
						$(productStyleId).html(productStyleOptions);
						$(colorGroupId).html(colorStyleOptions);
						return (i + 1);
					}

	function getProductGroupList(results, productGroupId) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Product Group";
		var data = results.data.productGroupJsons;

		//	data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata + '</option>'	+ '<option value="' + value.productGroupGuid + '">' + value.productGroups + '</option>';
		}
		console.log(finaldata);
		//$("#group").html(finaldata);
		$(productGroupId).html(finaldata);

		return finaldata;
	}

	function getCategoryList(results, categoryGroupId) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Product Category";
		var data = results.data.productCategoryJsons;
		//	data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata + '</option>'
					+ '<option value="' + value.productCategoryGuid + '">'
					+ value.productCategorys + '</option>';
		}
		console.log(finaldata)
		$(categoryGroupId).html(finaldata);
		//$("#productCategory").html(finaldata);
		return finaldata;
	}

	function getColorList(results, colorGroupId) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Color" + '</option>';
		var data = results.data.productColorJsons;
		//data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata
					+ '<option value="' + value.productColorGuid + '">'
					+ value.productColors + '</option>';
		}
		$(colorGroupId).html(finaldata);
		return finaldata;
	}

	function getProductStyle(results, productStyleId) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Product" + '</option>';
		var data = results.data.productDetailsJson;
		//data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata
					+ '<option value="' + value.productGuid + '">'
					+ value.productName + '</option>';
		}
		$(productStyleId).html(finaldata);
		return finaldata;
	}

	function setExporter(results) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Exporter" + '</option>';
		var data = results.data.companyDetailsJsons;
		//data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata
					+ '<option value="' + value.companyDetailsGuid + '">'
					+ value.companyName + '</option>';
		}
		$("#exporter").html(finaldata);
	}

	function setConsignee(results) {
		var finaldata = "";
		finaldata = finaldata + '<option value="" disabled selected>'
				+ "Select Exporter" + '</option>';
		var data = results.data.consigneeDetailsJsons;
		//data = jQuery.parseJSON(data);
		for (var i = 0; i < data.length; i++) {
			var value = data[i];

			finaldata = finaldata
					+ '<option value="' + value.companyDetailsGuid + '">'
					+ value.companyName + '</option>';
		}
		$("#consignee").html(finaldata);
	}
</script>



<style type="text/css">
body {
	padding: 10px;
}

.template {
	display: none;
}
</style>
</head>

<body>

	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">

				<a class="navbar-brand" href="../../dashboard">P&I Manager</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Management </a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="manageproductGroup">Product Group</a></li>
						<li class="divider"></li>
						<li><a href="manageproductcategory">Product Category</a></li>

						<li class="divider"></li>

						<li><a href="manageClients">Consignee</a></li>
						<li class="divider"></li>
						<li><a href="managecompany">Company</a></li>
						<li class="divider"></li>
						<li><a href="managecolor">Color</a></li>
						<li class="divider"></li>
						<li><a href="users">User</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<li><a href="manageproducts">Products</a></li>
				<li><a href="manageorders">Orders</a>
				<li><a href="../../index">Sign Out</a></li>

			</ul>
			<!-- /.navbar-top-links -->

		</nav>
		<!-- Navigation -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">Manage Orders</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="content-wrapper">

				<!-- Content Header (Page header) -->
				<section class="content-header">
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
						<li class="active">Orders</li>
					</ol>
				</section>
				<!-- Main content -->
				<section class="content">
					<!-- Default box -->
					<div class="box">
						<div class="box-header with-border">
							<h3 class="box-title">Manage Orders</h3>

						</div>
						<div class="box-body">

							<div class="panel-heading">
								<span class="glyphicon glyphicon-remove-circle pull-right "></span>

								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"> Orders </a>
								</h4>

							</div>

							<div class="row">
								<div class="col-md-12">
									<form action="" method="post" class="form-horizontal">


										<input name="count" id="countvalue" type="hidden" value="1" />
										<div class="block-content-outer">
											<div class="block-content-inner">
												<div class="table-responsive">

													<table class="table table-bordered table-hover"
														id="tab_logic">
														<thead>
															<tr>
																<th class="text-center">#</th>
																<th class="text-center">Action</th>
																<th class="text-center">Product Group</th>
																<th class="text-center">Product Category</th>
																<th class="text-center">Product Style</th>
																<th class="text-center">Color</th>
																<th class="text-center">One Size</th>
																<th class="text-center">XS</th>
																<th class="text-center">S</th>
																<th class="text-center">M</th>
																<th class="text-center">L</th>
																<th class="text-center">XL</th>
																<th class="text-center">XXL</th>
																<th class="text-center">XXXL</th>
															</tr>
														</thead>
														<tbody>
															<tr id='addr0'>
																<td>1</td>
																<td><input type="CHECKBOX"></td>
																<td><Select style="width: 220px" type="text"
																	name='productGroup1' id='productGroup1'
																	placeholder='Product Group' class="form-control">
																		<option>Product Group1</option>
																</select></td>
																<td><Select style="width: 220px" type="text"
																	name='productCategory1' id='productCategory1'
																	placeholder='Product Category' class="form-control">
																		<option>Product Category1</option>
																</select></td>
																<td><Select style="width: 220px" type="text"
																	name='productStyle1' id="productStyle1"
																	placeholder='Product Style' class="form-control">
																		<option>Style1</option>
																</select></td>
																<td><Select style="width: 220px" type="text"
																	name='colorStyle1' id="colorStyle1"
																	placeholder='Color Style' class="form-control">
																		<option>Style1</option>
																</select></td>
																<td><input style="width: 60px" type="text"
																	name='oneSize1' id="oneSize1" placeholder='One Size'
																	class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='xs1' id="xs1" placeholder='XS'
																	class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='s1' id="s1" placeholder='S' class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='m1' id="m1" placeholder='M' class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='l1' id="l1" placeholder='L' class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='xl1' id="xl1" placeholder='XL'
																	class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='xxl1' id="xxl1" placeholder='XXL'
																	class="form-control" /></td>
																<td><input style="width: 60px" type="text"
																	name='xxxl1' id="xxxl1" placeholder='XXXL'
																	class="form-control" /></td>
															</tr>
															 <tr id='addr1'></tr>
														</tbody>
													</table>
												</div>
												<a id="add_row" class="btn btn-success pull-left"
													style="margin-right: 20px;">Add Products</a> <a
													id='delete_row' class="pull-left btn btn-danger">Delete
													Products</a>

											</div>
										</div>

										<br> <br> <br>
										<div class="col-md-6">
											<input type="text" required id="orderNumber"
												name="orderNumber" class="form-control"
												placeholder="Order Number" />
										</div>

										<div class="col-md-6">
											<div class="input-group date" data-provide="datepicker">
												<input type="text" id="datepicker"
													class="form-control">
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
											</div>
										</div>

										<br> <br> <br>

										<div class="col-xs-4">
											<select id="exporter" name="exporter" class="form-control">
												<option value="" disabled selected>Select Exporter</option>
											</select>
										</div>

										<div class="col-xs-4">
											<select id="consignee" name="consignee" class="form-control">
												<option value="" disabled selected>Select Consignee</option>
											</select>
										</div>

									
								</div>
								<br> <br> <br> <br> <br> <br>

							</div>

							<br>


							<div class="row">
								<div class="form-actions no-margin-bottom"
									style="text-align: center;">
									<input type="button" id="addOrder" value="Add to order"
										class="btn btn-primary btn-lg " />
								</div>
								<!-- /.col -->
							</div>
							</form>

							<br> <br>
							<div class="box">
								<div class="box-header with-border">
									<h3 class="box-header with">
										<h3 class="box-title">Order List</h3>
								</div>
								<div class="box-body">
									<div class="row">
										<div class="col-xs-12">
											<div class="box">
												<!-- /.box-header -->
												<div class="box-body">
													<table id="orderTable"
														class="table table-bordered table-striped">
														<thead>
															<tr>
																<th>Order ID</th>
																<th>Order Date</th>
																<th>Consignee</th>
																<th>Consignee</th>

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
								<div class="box-footer"></div>
								<!-- /.box-footer-->
							</div>
						</div>
						<!-- /.box-body -->
						<!-- /.box-footer-->
					</div>
					<!-- /.box -->
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


	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 2.1.4 -->
	


</body>
</html>
