package com.attempt3.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attempt3.apis.model.AllowedCustomer;
import com.attempt3.apis.repository.AllowedCustomerRepository;

@Service
public class AllowedCustomerService {

	@Autowired
	AllowedCustomerRepository allowedCustomerRepository;

	public AllowedCustomer findByUserId(String id) {
		return allowedCustomerRepository.findByUserId(id);
	}

	public String postAllowedCustomer(AllowedCustomer allowedCustomer) {
		allowedCustomerRepository.save(allowedCustomer);
		return "Information stored successfully";
	}
	
	
}
