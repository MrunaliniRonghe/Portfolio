package com.attempt3.apis.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ACCOUNT_INFORMATION")
public class AccountInformation {

	@Id
	private String userId;
	private String linkedAccount;
	private float accountBalance;
	private String accountType;
	private LocalDateTime accountOpeningDate;
	private String netBanking;
}
