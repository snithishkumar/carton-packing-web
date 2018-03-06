package com.globalimbx.service;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.globalimbx.dao.OrderDAO;
import com.globalimbx.dao.UserDAO;
import com.globalimbx.entity.ClientDetailsEntity;
import com.globalimbx.entity.CompanyDetailsEntity;
import com.globalimbx.entity.DeliveryDetailsEntity;
import com.globalimbx.entity.OrderEntity;
import com.globalimbx.entity.ProductCategoryEntity;
import com.globalimbx.entity.ProductColorEntity;
import com.globalimbx.entity.ProductDetailsEntity;
import com.globalimbx.entity.ProductGroupEntity;
import com.globalimbx.entity.UserDetailsEntity;
import com.globalimbx.json.CartonDetailsJson;
import com.globalimbx.json.ClientDetailsJson;
import com.globalimbx.json.CompanyDetailsJson;
import com.globalimbx.json.OrderCreationDetailsJson;
import com.globalimbx.json.OrderCreationDetailsRequestJson;
import com.globalimbx.json.OrderCreationRequestJson;
import com.globalimbx.json.OrderDetailsJson;
import com.globalimbx.json.ProductCategoryJson;
import com.globalimbx.json.ProductColorJson;
import com.globalimbx.json.ProductDetails;
import com.globalimbx.json.ProductGroupJson;
import com.globalimbx.json.ResponseData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private Gson gson;
	@Autowired
	private JsonParser jsonParser;
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getOrderList(long serverSyncTime){
		List<OrderDetailsJson> orderDetailsJsonsList = new ArrayList<OrderDetailsJson>();
		try{
			List<OrderEntity> orderEntities = orderDao.getOrderList(serverSyncTime);
			for(OrderEntity orderEntity : orderEntities){
				OrderDetailsJson orderDetailsJson = new OrderDetailsJson(orderEntity);
				String orderItemsJson = orderEntity.getOrderedItems();
				Type listType = new TypeToken<ArrayList<OrderCreationDetailsJson>>() {
				}.getType();
				List<OrderCreationDetailsJson> orderedItems = gson.fromJson(orderItemsJson, listType);
				orderDetailsJson.setOrderedItems(orderedItems);
				String productDetailsJson = orderEntity.getProductDetails();
				if(productDetailsJson != null){
					listType = new TypeToken<ArrayList<CartonDetailsJson>>() {
					}.getType();
					List<CartonDetailsJson> productDetailsItems = gson.fromJson(productDetailsJson, listType);
					orderDetailsJson.setProductDetails(productDetailsItems);
				}
				DeliveryDetailsEntity deliveryDetailsEntity = orderDao.getDeliveryDetailsEntity(orderEntity);
				if(deliveryDetailsEntity != null){
					deliveryDetailsEntity.setOrderEntity(null);
				}
				
				orderDetailsJson.setDeliveryDetailsEntity(deliveryDetailsEntity);
				ClientDetailsJson clientDetailsJson = new ClientDetailsJson();
				loadClientDetails(orderEntity, clientDetailsJson);
				orderDetailsJson.setClientDetailsJson(clientDetailsJson);
				
				orderDetailsJsonsList.add(orderDetailsJson);
			}
			
			ResponseData responseData = new ResponseData();
			responseData.setStatusCode(200);
			responseData.setData(orderDetailsJsonsList);
			String data = gson.toJson(responseData);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public void loadClientDetails(OrderEntity orderEntity,ClientDetailsJson clientDetailsJson){
		ClientDetailsEntity clientDetailsEntity = orderEntity.getConsignee();
		clientDetailsJson.setClientDetailsUUID(clientDetailsEntity.getClientGuid());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(clientDetailsEntity.getCompany());
		stringBuilder.append(",/n");
		stringBuilder.append(clientDetailsEntity.getAddress1());
		stringBuilder.append(",/n");
		stringBuilder.append(clientDetailsEntity.getAddress2());
		stringBuilder.append(",/n");
		stringBuilder.append(clientDetailsEntity.getCountry());
		clientDetailsJson.setConsigneeDetails(stringBuilder.toString());
		clientDetailsJson.setTinNumber(clientDetailsEntity.getTinNumber());
		clientDetailsJson.setConsigneeCountry(clientDetailsEntity.getCountry());
		CompanyDetailsEntity companyDetailsEntity = orderEntity.getExporter();
		clientDetailsJson.setExporterCountry(companyDetailsEntity.getCountry());
		
		stringBuilder = new StringBuilder();
		stringBuilder.append(companyDetailsEntity.getCompanyName());
		stringBuilder.append(",/n");
		stringBuilder.append(companyDetailsEntity.getAddress1());
		stringBuilder.append(",/n");
		stringBuilder.append(companyDetailsEntity.getAddress2());
		stringBuilder.append(",/n");
		stringBuilder.append(companyDetailsEntity.getCountry());
		clientDetailsJson.setExporterDetails(stringBuilder.toString());
		clientDetailsJson.setExporterRef(companyDetailsEntity.getContactAuthority());
	}
	
	@Transactional(readOnly= false,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> updateOrderList(String orderDetails){
		try{
			JsonArray response = new JsonArray();
			Type listType = new TypeToken<ArrayList<OrderDetailsJson>>() {
			}.getType();
			List<OrderDetailsJson> orderDetailsJsonsList =  gson.fromJson(orderDetails, listType);
			for(OrderDetailsJson orderDetailsJson : orderDetailsJsonsList){
				OrderEntity orderEntity = orderDao.getOrderEntity(orderDetailsJson.getOrderGuid());
				if(orderEntity != null){
					orderEntity.copyBeanValue(orderDetailsJson);
					List<CartonDetailsJson> productList =	orderDetailsJson.getProductDetails();
					String productDetailsJson = gson.toJson(productList);
					orderEntity.setProductDetails(productDetailsJson);
					orderDao.updateOrderEntity(orderEntity);
					response.add(orderEntity.getOrderGuid());
					
					DeliveryDetailsEntity deliveryDetailsEntity = orderDetailsJson.getDeliveryDetailsEntity();
					if(deliveryDetailsEntity != null){
						DeliveryDetailsEntity dbDeliveryDetailsEntity =	orderDao.getDeliveryDetailsEntity(deliveryDetailsEntity.getDeliveryUUID());
						if(dbDeliveryDetailsEntity == null){
							deliveryDetailsEntity.setOrderEntity(orderEntity);
							orderDao.createDeliveryDetailsEntity(deliveryDetailsEntity);
						}
					}
					
					// Update
				}else{
					//Save
				}
			}
			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public ResponseEntity<String> addPoductGroup(String rawData){
		try{
			JsonObject jsonObject = (JsonObject) jsonParser.parse(rawData);
			JsonElement productGroupElement = jsonObject.get("groupGuid");
			if(productGroupElement != null){
				String productGroupGuid = productGroupElement.getAsString();
				ProductGroupEntity productGroupEntity = orderDao.getProductGroup(productGroupGuid);
				productGroupEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productGroupEntity.setProductGroup(jsonObject.get("groupName").getAsString());
				productGroupEntity.setNotes(jsonObject.get("groupNotes").getAsString());
				orderDao.updateProductGroup(productGroupEntity);
			}else{
				ProductGroupEntity productGroupEntity = new ProductGroupEntity();
				productGroupEntity.setProductGroupGuid(UUID.randomUUID().toString());
				productGroupEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productGroupEntity.setProductGroup(jsonObject.get("groupName").getAsString());
				productGroupEntity.setNotes(jsonObject.get("groupNotes").getAsString());
				orderDao.saveProductGroup(productGroupEntity);
			}
			
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductGroupList(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductGroupEntity> productGroupList = orderDao.getProductGroup();
			List<ProductGroupJson> productGroupJsons  =new ArrayList<ProductGroupJson>();
			for(ProductGroupEntity productGroupEntity : productGroupList){
				ProductGroupJson productGroupJson = new ProductGroupJson(productGroupEntity);
				productGroupJsons.add(productGroupJson);
			}
			responseData.setStatusCode(200);
			responseData.setData(productGroupJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public ResponseEntity<String> addPoductCategory(String rawData){
		try{
			JsonObject jsonObject = (JsonObject) jsonParser.parse(rawData);
			JsonElement productCategoryElement = jsonObject.get("productCategoryGuid");
			if(productCategoryElement != null){
				String productCategoryGuid = productCategoryElement.getAsString();
				ProductCategoryEntity productCategoryEntity = orderDao.getProductCategory(productCategoryGuid);
				productCategoryEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productCategoryEntity.setProductCategory(jsonObject.get("productCategory").getAsString());
				productCategoryEntity.setNotes(jsonObject.get("productCategoryNotes").getAsString());
				orderDao.updateProductCategory(productCategoryEntity);
			}else{
				ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
				productCategoryEntity.setProductCategoryGuid(UUID.randomUUID().toString());
				productCategoryEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productCategoryEntity.setProductCategory(jsonObject.get("productCategory").getAsString());
				productCategoryEntity.setNotes(jsonObject.get("productCategoryNotes").getAsString());
				orderDao.saveProductCategory(productCategoryEntity);
			}
			
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductCategoryList(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductCategoryEntity> productCategoryList = orderDao.getProductCategory();
			List<ProductCategoryJson> productCategoryJsons  =new ArrayList<ProductCategoryJson>();
			for(ProductCategoryEntity productCategoryEntity : productCategoryList){
				ProductCategoryJson productCategoryJson = new ProductCategoryJson(productCategoryEntity);
				productCategoryJsons.add(productCategoryJson);
			}
			responseData.setStatusCode(200);
			responseData.setData(productCategoryJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public ResponseEntity<String> addProductColor(String rawData){
		try{
			JsonObject jsonObject = (JsonObject) jsonParser.parse(rawData);
			JsonElement productColorElement = jsonObject.get("productColorGuid");
			if(productColorElement != null){
				String productColorGuid = productColorElement.getAsString();
				ProductColorEntity productColorEntity = orderDao.getProductColor(productColorGuid);
				productColorEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productColorEntity.setProductColor(jsonObject.get("productColor").getAsString());
				productColorEntity.setNotes(jsonObject.get("productColorNotes").getAsString());
				orderDao.updateProductColor(productColorEntity);
			}else{
				ProductColorEntity productColorEntity = new ProductColorEntity();
				productColorEntity.setProductColorGuid(UUID.randomUUID().toString());
				productColorEntity.setLastModifiedDateTime(System.currentTimeMillis());
				productColorEntity.setProductColor(jsonObject.get("productColor").getAsString());
				productColorEntity.setNotes(jsonObject.get("productColorNotes").getAsString());
				orderDao.saveProductColor(productColorEntity);
			}
			
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductColorList(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductColorEntity> productColorList = orderDao.getProductColor();
			List<ProductColorJson> productColorJsons  =new ArrayList<ProductColorJson>();
			for(ProductColorEntity productColorEntity : productColorList){
				ProductColorJson productColorJson = new ProductColorJson(productColorEntity);
				productColorJsons.add(productColorJson);
			}
			responseData.setStatusCode(200);
			responseData.setData(productColorJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@Transactional(readOnly = false,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> createProduct(String rawData) {
		ResponseData responseData = new ResponseData();
		try {
			ProductDetails productDetails = gson.fromJson(rawData, ProductDetails.class);

			ProductGroupEntity productGroupEntity = orderDao.getProductGroup(productDetails.getProductGroupGuid());

			ProductCategoryEntity categoryEntity = orderDao.getProductCategory(productDetails.getProductCategoryGuid());

			ProductColorEntity productColorEntity = orderDao.getProductColor(productDetails.getColorGuid());

			if (productDetails.getProductGuid() == null) {
				ProductDetailsEntity productDetailsEntity = new ProductDetailsEntity();
				productDetailsEntity.setProductCategoryEntity(categoryEntity);
				productDetailsEntity.setProductGuid(UUID.randomUUID().toString());
				productDetailsEntity.setProductColorEntity(productColorEntity);
				productDetailsEntity.setProductGroupEntity(productGroupEntity);
				productDetailsEntity.setProductName(productDetails.getProductName());
				productDetailsEntity.setProductNotes(productDetails.getProductNotes());
				productDetailsEntity.setUnitPrice(productDetails.getUnitPrice());
				orderDao.saveProductDetails(productDetailsEntity);
			}else{
				ProductDetailsEntity productDetailsEntity = orderDao.getProductDetails(productDetails.getProductGuid());
				productDetailsEntity.setProductCategoryEntity(categoryEntity);
				productDetailsEntity.setProductColorEntity(productColorEntity);
				productDetailsEntity.setProductGroupEntity(productGroupEntity);
				productDetailsEntity.setProductName(productDetails.getProductName());
				productDetailsEntity.setProductNotes(productDetails.getProductNotes());
				productDetailsEntity.setUnitPrice(productDetails.getUnitPrice());
				orderDao.updateProductDetails(productDetailsEntity);
			}
			responseData.setStatusCode(200);
			responseData.setData("Success.");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductGroups(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductGroupJson>  productGroupJsons = orderDao.getProductGroupList();
			responseData.setStatusCode(200);
			responseData.setData(productGroupJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductCategory(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductCategoryJson>  productCategoryJsons = orderDao.getProductCategoryList();
			responseData.setStatusCode(200);
			responseData.setData(productCategoryJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductColors(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductColorJson>  productColorJsons = orderDao.getProductColorList();
			responseData.setStatusCode(200);
			responseData.setData(productColorJsons);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getProductList(){
		ResponseData responseData = new ResponseData();
		try{
			List<ProductDetailsEntity>  productDetailsEntities = orderDao.getProductDetailsEntity();
			List<ProductDetails> productDetailsList = new ArrayList<ProductDetails>();
			for(ProductDetailsEntity productDetailsEntity : productDetailsEntities){
				ProductDetails productDetails = new ProductDetails(productDetailsEntity);
				productDetailsList.add(productDetails);
			}
			responseData.setStatusCode(200);
			responseData.setData(productDetailsList);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = false,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> createOrders(String requestData){
		ResponseData responseData = new ResponseData();
		try{
			OrderCreationDetailsRequestJson orderCreationRequestJson = gson.fromJson(requestData, OrderCreationDetailsRequestJson.class);
			OrderEntity orderEntity = new OrderEntity(orderCreationRequestJson);
			List<OrderCreationDetailsJson> orderDetails = orderCreationRequestJson.getOrderDetails();
			for(OrderCreationDetailsJson creationDetailsJson : orderDetails){
				ProductDetailsEntity productDetailsEntity = orderDao.getProductDetails(creationDetailsJson.getProductStyleGuid());
				creationDetailsJson.setProductStyle(productDetailsEntity.getProductName());
				creationDetailsJson.setUnitPrice(creationDetailsJson.getUnitPrice());
				creationDetailsJson.setOrderItemGuid(UUID.randomUUID().toString());
			}
			CompanyDetailsEntity companyDetailsEntity = userDao.getCompanyDetailsEntity(orderCreationRequestJson.getExporter());
			orderEntity.setExporter(companyDetailsEntity);
			
			ClientDetailsEntity clientDetailsEntity = userDao.getClientDetailsEntity(orderCreationRequestJson.getConsignee());
			orderEntity.setConsignee(clientDetailsEntity);
			
			String orderItems = gson.toJson(orderDetails);
			orderEntity.setOrderedItems(orderItems);
			UserDetailsEntity userDetailsEntity = userDao.getUsers(orderCreationRequestJson.getExporter());
			orderEntity.setOrderCreatedBy(userDetailsEntity);
			
			
			orderDao.updateOrderEntity(orderEntity);
			responseData.setStatusCode(200);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true,propagation= Propagation.REQUIRED)
	public ResponseEntity<String> getOrderCreationDetails(){
		ResponseData responseData = new ResponseData();
		OrderCreationRequestJson orderCreationRequestJson = new OrderCreationRequestJson();
		try{
			List<ProductGroupJson>  productGroupJsons = orderDao.getProductGroupList();
			orderCreationRequestJson.setProductGroupJsons(productGroupJsons);
			List<ProductCategoryJson>  productCategoryJsons = orderDao.getProductCategoryList();
			orderCreationRequestJson.setProductCategoryJsons(productCategoryJsons);
			List<ProductColorJson>  productColorJsons = orderDao.getProductColorList();
			orderCreationRequestJson.setProductColorJsons(productColorJsons);
			List<ProductDetails> productDetailsJsons = orderDao.getProductDetailsList();
			orderCreationRequestJson.setProductDetailsJson(productDetailsJsons);
			List<CompanyDetailsJson> clientDetailsJsons = userDao.getClientListForDropDown();
			orderCreationRequestJson.setConsigneeDetailsJsons(clientDetailsJsons);
			List<CompanyDetailsJson> companyDetailsJsons = userDao.getCompanyListFroDropDown();
			orderCreationRequestJson.setCompanyDetailsJsons(companyDetailsJsons);
			
			responseData.setStatusCode(200);
			responseData.setData(orderCreationRequestJson);
			orderCreationRequestJson.setOrderId(getOrderId());
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	private String getOrderId(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddmmyyHHmm");
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		Date date = new Date(calendar.getTimeInMillis());
		Random random = new Random();
		int ran = random.nextInt(99);
		return simpleDateFormat.format(date)+"_"+ran;
	
	}
	
	
	@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getWebOrderList(){
		ResponseData responseData = new ResponseData();
		List<OrderDetailsJson> orderDetailsJsonsList = new ArrayList<OrderDetailsJson>();
		try{
			List<OrderEntity> orderEntities = orderDao.getOrderEntityDetails();
			for(OrderEntity orderEntity : orderEntities){
				OrderDetailsJson orderDetailsJson = new OrderDetailsJson(orderEntity);
				orderDetailsJsonsList.add(orderDetailsJson);
			}
			responseData.setStatusCode(200);
			responseData.setData(orderDetailsJsonsList);
			String data = gson.toJson(responseData);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getOrderDetails(String orderGuid){
		ResponseData responseData = new ResponseData();
		try{
			OrderEntity orderEntity = orderDao.getOrderEntityDetails(orderGuid);
			OrderDetailsJson orderDetailsJson = new OrderDetailsJson(orderEntity);
			String orderItems = orderEntity.getOrderedItems();
			Type listType = new TypeToken<ArrayList<OrderCreationDetailsJson>>() {
			}.getType();
			List<OrderCreationDetailsJson> productDetailsList = gson.fromJson(orderItems, listType);
			orderDetailsJson.setOrderedItems(productDetailsList);
			responseData.setStatusCode(200);
			responseData.setData(orderDetailsJson);
			String data = gson.toJson(responseData);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
