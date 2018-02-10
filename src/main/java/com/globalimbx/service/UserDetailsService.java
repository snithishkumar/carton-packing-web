package com.globalimbx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.globalimbx.dao.UserDAO;
import com.globalimbx.entity.ClientDetailsEntity;
import com.globalimbx.entity.CompanyDetailsEntity;
import com.globalimbx.entity.UserDetailsEntity;
import com.globalimbx.json.ResponseData;
import com.globalimbx.json.UserDetailsJson;
import com.google.gson.Gson;

@Service
public class UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Gson gson;
	
	private static final Logger logger = Logger.getLogger(UserDetailsService.class);
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> login(String userName,String password){
		try{
			UserDetailsEntity userDetailsEntity = userDAO.getUserDetails(userName);
			if(userDetailsEntity == null){
				return new ResponseEntity<String>("InValid UserName", HttpStatus.UNAUTHORIZED);
			}
			if(userDetailsEntity.getPassword().equals(password)){
				return new ResponseEntity<String>("Success.", HttpStatus.OK);
			}
			return new ResponseEntity<String>("InValid UserName", HttpStatus.UNAUTHORIZED);
		}catch(Exception e){
			logger.error("Error in login", e);
		}
		return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ModelAndView webLogin(String userName,String password){
		ModelAndView modelAndView = new ModelAndView();
		try{
			UserDetailsEntity userDetailsEntity = userDAO.getUserDetails(userName);
			if(userDetailsEntity == null){
				modelAndView.setViewName("index");
				modelAndView.addObject("error", "Invalid Username/Password");
				return modelAndView;
			}
			if(userDetailsEntity.getPassword().equals(password)){
				modelAndView.setViewName("redirect:/adminPage.jsp");
			}
			modelAndView.setViewName("index");
			modelAndView.addObject("error", "Invalid Username/Password");
			return modelAndView;
		}catch(Exception e){
			logger.error("Error in login", e);
		}
		modelAndView.setViewName("login");
		modelAndView.addObject("error", "Internal Server Error.");
		return modelAndView;
	}
	
	
	@Transactional(readOnly= false,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> createCompany(String requestData){
		try{
			CompanyDetailsEntity companyDetailsEntity = gson.fromJson(requestData, CompanyDetailsEntity.class);
			if(companyDetailsEntity.getCompanyDetailsGuid() != null){
				CompanyDetailsEntity dbCompanyDetailsEntity = userDAO.getCompanyDetailsEntity(companyDetailsEntity.getCompanyDetailsGuid());
				dbCompanyDetailsEntity.copyVal(companyDetailsEntity);
				userDAO.updateCompanyDetails(dbCompanyDetailsEntity);
			}else{
				companyDetailsEntity.setCompanyDetailsGuid(UUID.randomUUID().toString());
				userDAO.saveCompanyDetails(companyDetailsEntity);
			}
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getCompanyList(){
		ResponseData responseData = new ResponseData();
		try{
			List<CompanyDetailsEntity> companyDetailsEntities = userDAO.getCompanyList();
			responseData.setData(companyDetailsEntities);
			responseData.setStatusCode(200);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@Transactional(readOnly= false,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> createClient(String requestData){
		try{
			ClientDetailsEntity clientDetailsEntity = gson.fromJson(requestData, ClientDetailsEntity.class);
			if(clientDetailsEntity.getClientGuid() != null){
				ClientDetailsEntity dbClientDetailsEntity = userDAO.getClientDetailsEntity(clientDetailsEntity.getClientGuid());
				dbClientDetailsEntity.copyVal(clientDetailsEntity);
				userDAO.updateClients(dbClientDetailsEntity);
			}else{
				clientDetailsEntity.setClientGuid(UUID.randomUUID().toString());
				userDAO.saveClients(clientDetailsEntity);
			}
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getClientList(){
		ResponseData responseData = new ResponseData();
		try{
			List<ClientDetailsEntity> clientDetailsEntities = userDAO.getClientList();
			responseData.setData(clientDetailsEntities);
			responseData.setStatusCode(200);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@Transactional(readOnly= false,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> createUser(String requestData){
		try{
			UserDetailsJson userDetailsJson = gson.fromJson(requestData, UserDetailsJson.class);
			if(userDetailsJson.getUserGuid() != null){
				UserDetailsEntity dbUserDetailsEntity = userDAO.getUsers(userDetailsJson.getUserGuid());
				dbUserDetailsEntity.copyValue(userDetailsJson);
				userDAO.updateUsers(dbUserDetailsEntity);
			}else{
				UserDetailsEntity userDetailsEntity = new UserDetailsEntity(userDetailsJson);
				userDAO.saveUsers(userDetailsEntity);
			}
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Transactional(readOnly= true,propagation=Propagation.REQUIRED)
	public ResponseEntity<String> getUsersList(){
		ResponseData responseData = new ResponseData();
		try{
			List<UserDetailsEntity> userDetailsEntities = userDAO.getUsersList();
			List<UserDetailsJson> userDetailsJsonList = new ArrayList<>();
			for(UserDetailsEntity userDetailsEntity : userDetailsEntities){
				UserDetailsJson userDetailsJson = new UserDetailsJson(userDetailsEntity);
				userDetailsJson.setPassword(userDetailsEntity.getPassword());
				userDetailsJsonList.add(userDetailsJson);
			}
			responseData.setData(userDetailsJsonList);
			responseData.setStatusCode(200);
		}catch(Exception e){
			e.printStackTrace();
			responseData.setStatusCode(500);
			responseData.setData("Internal Server Error.");
		}
		String response = gson.toJson(responseData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
