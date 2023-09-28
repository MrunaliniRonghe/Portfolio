package com.attempt3.apis.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.TransactionHistory;
import com.attempt3.apis.service.AccountInformationService;
import com.attempt3.apis.service.TransactionHistoryService;

@Controller
public class TransactionHistoryController {

	@Autowired
	TransactionHistoryService transactionHistoryService;
	
	@Autowired
	AccountInformationService accountInformationService;
	
	@PostMapping("/addTransaction")
	public String createTransaction(@RequestBody TransactionHistory transactionHistory) {
		transactionHistory.setTransactionDate(LocalDateTime.now());
		float amount = transactionHistory.getTransactionAmount();
		String userId = transactionHistory.getUserId();
		String type = transactionHistory.getTransactionType();
		accountInformationService.saveNewTransaction(userId,amount,type);
		return transactionHistoryService.createTransaction(transactionHistory);
	}
	
	@GetMapping("/getByYear/{userId}/{year}")
	public String getAllTransaction(@PathVariable("userId") String userId, @PathVariable("year") int year){
		return transactionHistoryService.getAllTransaction(userId,year);
	}
	
	@GetMapping("/betNyMonth/{userId}/{month}")
	public List<TransactionHistory> getTransactionMonthWise(@PathVariable("userId") String userId, @PathVariable("month") int month) {
		return transactionHistoryService.getTransactionMonthWise(userId, month);
	}
	
	@DeleteMapping("/deleteAllTransactionHistory")
	public String deleteAllTransactionHistory() {
		return transactionHistoryService.deleteAllTransactionHistory();
	}
}
