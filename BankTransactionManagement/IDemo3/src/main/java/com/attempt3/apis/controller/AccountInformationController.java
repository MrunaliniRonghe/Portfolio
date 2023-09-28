package com.attempt3.apis.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.AccountInformation;
import com.attempt3.apis.service.AccountInformationService;

@Controller
public class AccountInformationController {

	@Autowired
	AccountInformationService accountInformationService;
	
	@PostMapping("/addAccountInformation")
	public String postAccountInformation(@RequestBody AccountInformation accountInformation) {
		accountInformation.setAccountOpeningDate(LocalDateTime.now());
		return accountInformationService.postAccountInformation(accountInformation);
	}
	
	@DeleteMapping("/deleteAllAccountInformation")
	public String deleteAllAccountInformation() {
		return accountInformationService.deleteAllAccountInformation();
	}
}
