package com.attempt3.apis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "USER_ID_HISTORY")
public class UserIdHistory {

	private String userId;
	@Id
	private String previousId;
}
