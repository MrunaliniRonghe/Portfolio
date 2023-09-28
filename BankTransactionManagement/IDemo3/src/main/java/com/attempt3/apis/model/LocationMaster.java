package com.attempt3.apis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "LOCATION_MASTER")
public class LocationMaster {

	@Id
	String userId;
	private String pinCode;
	private String cityName;
	private String stateName;
	private String countryName;
}
