package com.globalimbx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.globalimbx.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "getOrderList")
	public ResponseEntity<String> getOrderList(@RequestParam String lastSyncTime){
		long serverSyncTime = -1;
		if(lastSyncTime != null){
			serverSyncTime = Long.valueOf(lastSyncTime);
		}
		return orderService.getOrderList(serverSyncTime);
	}
	
	@RequestMapping(value = "updateOrderDetails")
	public ResponseEntity<String> updateOrderDetails(@RequestBody String orderList){
		return orderService.updateOrderList(orderList);
	}
	
	
	@RequestMapping(value = "pages/admin/addProductGroup")
	public ResponseEntity<String> addProductGroup(@RequestBody String data){
		return orderService.addPoductGroup(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getProductGroupList")
	@ResponseBody
	public ResponseEntity<String> getProductGroupList(){
		return orderService.getProductGroupList();
	}
	
	
	
	@RequestMapping(value = "pages/admin/addProductCategory")
	public ResponseEntity<String> addProductCategory(@RequestBody String data){
		return orderService.addPoductCategory(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getProductCategoryList")
	public ResponseEntity<String> getProductCategoryList(){
		return orderService.getProductCategoryList();
	}
	
	
	@RequestMapping(value = "pages/admin/addProductColor")
	public ResponseEntity<String> addProductColor(@RequestBody String data){
		return orderService.addProductColor(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getProductColorList")
	public ResponseEntity<String> getProductColorList(){
		return orderService.getProductColorList();
	}
	
	
	@RequestMapping(value = "pages/admin/getProductGroupsDropDown")
	public ResponseEntity<String> getProductGroups(){
		return orderService.getProductGroups();
	}
	
	@RequestMapping(value = "pages/admin/getProductCategoryDropDown")
	public ResponseEntity<String> getProductCategory(){
		return orderService.getProductCategory();
	}
	
	@RequestMapping(value = "pages/admin/getProductColorsDropDown")
	public ResponseEntity<String> getProductColorsDropDown(){
		return orderService.getProductColors();
	}
	
	
	
	@RequestMapping(value = "pages/admin/createProduct")
	public ResponseEntity<String> createProduct(@RequestBody String data){
		return orderService.createProduct(data);
	}
	

	@RequestMapping(value = "pages/admin/getProductList")
	public ResponseEntity<String> getProductList(){
		return orderService.getProductList();
	}
	
	
	@RequestMapping(value = "pages/admin/getOrderCreationDetails")
	public ResponseEntity<String> getOrderCreationDetails(){
		return orderService.getOrderCreationDetails();
	}
	
	
	@RequestMapping(value = "pages/admin/createOrders")
	public ResponseEntity<String> createOrders(@RequestBody String requestData){
		return orderService.createOrders(requestData);
	}
	
	@RequestMapping(value = "pages/admin/getWebOrderList")
	public ResponseEntity<String> getWebOrderList(){
		return orderService.getWebOrderList();
	}
	
	
	@RequestMapping(value = "pages/admin/getOrderDetails")
	public ResponseEntity<String> getOrderDetails(@RequestBody String orderGuid){
		return orderService.getOrderDetails(orderGuid);
	}
	

}
