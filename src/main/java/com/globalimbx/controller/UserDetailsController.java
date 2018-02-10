package com.globalimbx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.globalimbx.service.UserDetailsService;

@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "login")
	public ResponseEntity<String> login(@RequestParam String userName,@RequestParam String password){
		return userDetailsService.login(userName, password);
	}
	
	
	@RequestMapping(value = "web/authenticate")
	public ModelAndView authenticate(@RequestParam String userName,@RequestParam String password){
		return userDetailsService.webLogin(userName, password);
	}
	
	
	@RequestMapping(value = "pages/admin/addClient")
	public ResponseEntity<String> addClient(@RequestBody String data){
		return userDetailsService.createClient(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getClientList")
	public ResponseEntity<String> getClientList(){
		return userDetailsService.getClientList();
	}
	
	
	@RequestMapping(value = "pages/admin/addCompany")
	public ResponseEntity<String> addCompany(@RequestBody String data){
		return userDetailsService.createCompany(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getCompanyList")
	public ResponseEntity<String> getCompanyList(){
		return userDetailsService.getCompanyList();
	}
	
	
	@RequestMapping(value = "pages/admin/addUser")
	public ResponseEntity<String> addUser(@RequestBody String data){
		return userDetailsService.createUser(data);
	}
	
	
	@RequestMapping(value = "pages/admin/getUsersList")
	public ResponseEntity<String> getUsersList(){
		return userDetailsService.getUsersList();
	}


}
