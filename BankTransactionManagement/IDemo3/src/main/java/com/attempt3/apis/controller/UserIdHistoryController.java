package com.attempt3.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.UserIdHistory;
import com.attempt3.apis.service.UserIdHistoryService;

@Controller
public class UserIdHistoryController {

	@Autowired
	UserIdHistoryService userIdHistoryService;
	
	@PostMapping("/addUserIdHistory")
	public String addUserIdHistory(@RequestBody UserIdHistory userIdHistory) {
		//return userIdHistoryService.addUserIdHistory(userIdHistory);
		return "Hello World";
	}
	
	@PutMapping("/updateUserIdHistory/{p_userId}")
	public String updateUserIdHistory(@RequestBody UserIdHistory userIdHistory, @PathVariable String p_userId) {
		return userIdHistoryService.updateUserId(userIdHistory, p_userId);
	}
}
