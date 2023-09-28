package com.attempt3.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attempt3.apis.model.AllowedCustomer;
import com.attempt3.apis.model.UserInformation;
import com.attempt3.apis.repository.AllowedCustomerRepository;
import com.attempt3.apis.repository.UserInformationRepository;

@Service
public class UserInformationService {

	@Autowired
	UserInformationRepository userInformationRepository;
	
	@Autowired
	AllowedCustomerService allowedCustomerService;
	
	public List<UserInformation> getPersonalInfo(String id) {
		return userInformationRepository.findAllByUserId(id);
	}

	public String updatePersonalInfo(UserInformation userInformation, String id) {
		
		String per = allowedCustomerService.findByUserId(id).getUpdatingAllowed();
		
		if(per == "y") {
			userInformationRepository.deleteById(id);
			userInformationRepository.save(userInformation);
			return "Information successfully updated for userId: "+id;
		}
		else {
			return "Permission denied. Updating user information unsuccessfull for UserId:"+id;
		}
	}

	public String deletePersonalInfo(String id) {
		AllowedCustomer allowedCustomer = allowedCustomerService.findByUserId(id);
		String per = allowedCustomer.getUpdatingAllowed();
		
		if(per == "y") {
			userInformationRepository.deleteById(id);
			return "Information successfully updated for userId: "+id;
		}
		else {
			return "Permission denied. Deleting user information unsuccessfull for UserId:"+id;
		}
	}

	public String deleteAllUserInformation() {
		userInformationRepository.deleteAll();
		return "User Information collection cleared successfully.";
	}

	public String addUserInformation(UserInformation userInformation) {
		userInformationRepository.save(userInformation);
		return "User information saved successfully for userId: "+userInformation.getUserId();
	}
	
}
