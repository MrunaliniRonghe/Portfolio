package com.attempt3.apis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ALLOWED_CUSTOMER")
public class AllowedCustomer {
	
	@Id
	private String userId;
	private String updatingAllowed;
}
