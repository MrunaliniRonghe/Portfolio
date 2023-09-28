package com.attempt3.apis.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "TRANSACTION_HISTORY")
public class TransactionHistory {
	
	@Id
	private String transactionId;
	public float transactionAmount;
	private String userId;
	private String accountNumber;
	public String transactionType;
	private String merchantName;
	private LocalDateTime transactionDate;
	private String transactionStatus;
}
