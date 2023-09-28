package com.attempt3.apis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.attempt3.apis.model.AllowedCustomer;

@Repository
public interface AllowedCustomerRepository extends MongoRepository<AllowedCustomer, String>{

	public AllowedCustomer findByUserId(String id);

	
	
}
