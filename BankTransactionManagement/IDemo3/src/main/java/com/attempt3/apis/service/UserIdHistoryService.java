package com.attempt3.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attempt3.apis.model.UserIdHistory;
import com.attempt3.apis.repository.UserIdHistoryRepository;

@Service
public class UserIdHistoryService {

	@Autowired
	UserIdHistoryRepository userIdHistoryRepository;
	
	@Autowired
	AllowedCustomerService allowedCustomerService;

	public String updateUserId(UserIdHistory userIdHistory, String p_userId) {
String per = allowedCustomerService.findByUserId(p_userId).getUpdatingAllowed();
		
		if(per == "y") {
			userIdHistoryRepository.save(userIdHistory);
			return "Information successfully updated for userId: "+p_userId;
		}
		else {
			return "Permission denied. Updating user information unsuccessfull for UserId:"+p_userId;
		}
	}

	public String addUserIdHistory(UserIdHistory userIdHistory) {
		userIdHistoryRepository.save(userIdHistory);
		return "UserId history saved successfully";
	}
}
