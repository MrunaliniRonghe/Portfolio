package com.attempt3.apis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "USER_INFORMATION")
public class UserInformation {

	@Id
	private String userId;
	private String name;
	private String phoneNumber;
	private String homeAddress;
	private String homePinCode;
	private String homeBranch;
}
