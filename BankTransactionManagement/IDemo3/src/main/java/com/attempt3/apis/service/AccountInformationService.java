package com.attempt3.apis.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attempt3.apis.model.AccountInformation;
import com.attempt3.apis.model.TransactionHistory;
import com.attempt3.apis.repository.AccountInformationRepository;
import com.attempt3.apis.repository.TransactionHistoryRepository;

@Service
public class AccountInformationService {

	@Autowired
	AccountInformationRepository accountInformationRepository;
	
	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;

	public void saveNewTransaction(String userId, float amount, String type) {
		AccountInformation ai = accountInformationRepository.findAllByUserId(userId);
		float accBalance = ai.getAccountBalance();
		if(type=="Credit") {
			accBalance = accBalance + amount;
		}
		else {
			accBalance = accBalance - amount;
		}
		
		ai.setAccountBalance(accBalance);
		accountInformationRepository.save(ai);
	}

	public String postAccountInformation(AccountInformation accountInformation) {
		accountInformationRepository.save(accountInformation);
		return "Account information saved successfully for userId: "+accountInformation.getUserId();
	}

	public String deleteAllAccountInformation() {
		accountInformationRepository.deleteAll();
		return "All records successfully deleted from AccountInformation";
	}
}
