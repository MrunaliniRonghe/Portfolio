package com.attempt3.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.attempt3.apis.model.AccountInformation;
import com.attempt3.apis.model.TransactionHistory;
import com.attempt3.apis.repository.AccountInformationRepository;
import com.attempt3.apis.repository.TransactionHistoryRepository;

@Service
public class TransactionHistoryService {

	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;
	
	AccountInformation accountInformation = new AccountInformation();
	
	TransactionHistory transactionHistory = new TransactionHistory();
	
	
	public String createTransaction(TransactionHistory transactionHistory) {
		transactionHistoryRepository.save(transactionHistory);
		return "Transaction successfully saved for userId: "+transactionHistory.getUserId();
	}

	//for clearing Transaction History collection
	public String deleteAllTransactionHistory() {
		transactionHistoryRepository.deleteAll();
		return "All records in TRANSACTION_HISTORY deleted successfully.";
	}
	
	public float calculateCreditAmount (List<TransactionHistory> list) {
		float creditAmount = 0;
		return  list.stream()
				.filter(n -> n.transactionType.equals("Credit"))
				.map(TransactionHistory::getTransactionAmount)
				.reduce(Float::sum)
				.orElse(0f);
	}
	
	public float calculateDebitAmount (List<TransactionHistory> list) {

		float debitAmount = 0;
		
		List<TransactionHistory> list1 = list.stream().filter(n -> n.transactionType.equals("Debit")).collect(Collectors.toList());
		return  list.stream()
				.filter(n -> n.transactionType.equals("Debit"))
				.map(TransactionHistory::getTransactionAmount)
				.reduce(Float::sum)
				.orElse(0f);
	}

	public String getAllTransaction(String userId, int year) {
		List list = transactionHistoryRepository.findAllByYear(userId, year);
		float creditAmount  = calculateDebitAmount(list);
		float debitAmount = calculateDebitAmount(list);
		
		float balanceAmount = accountInformation.getAccountBalance();
		
		return "balanceAmount: " + balanceAmount +"\ntotalCreditAmount: "+ creditAmount +"\ntotalDebitAmount: "+ debitAmount+"\n"+ transactionHistoryRepository.findAllByYear(userId, year).toString();
	}

	
	public List<TransactionHistory> getTransactionMonthWise(String userId, int month) {
		return transactionHistoryRepository.findByMonth(userId, month);
	}

}
