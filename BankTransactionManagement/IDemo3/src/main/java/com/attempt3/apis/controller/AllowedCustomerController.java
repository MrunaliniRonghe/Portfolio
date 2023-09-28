package com.attempt3.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.AllowedCustomer;
import com.attempt3.apis.service.AllowedCustomerService;

@Controller
public class AllowedCustomerController {

	@Autowired
	AllowedCustomerService allowedCustomerService;
	
	@PostMapping("/addAllowedCustomer")
	public String postAllowedCustomer(@RequestBody AllowedCustomer allowedCustomer) {
		return allowedCustomerService.postAllowedCustomer(allowedCustomer);
	}
}
