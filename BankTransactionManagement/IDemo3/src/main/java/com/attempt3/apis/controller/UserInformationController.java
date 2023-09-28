package com.attempt3.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.UserInformation;
import com.attempt3.apis.service.UserInformationService;

@Controller
public class UserInformationController {

	@Autowired
	UserInformationService userInformationService;
	
	@GetMapping("/getUserInfo/{id}")
	public List<UserInformation> getPersonalInfo(@PathVariable String id){
		return userInformationService.getPersonalInfo(id);
	}
	
	@PostMapping("/addUserInfo")
	public String addUserInfo(@RequestBody UserInformation userInformation) {
		return userInformationService.addUserInformation(userInformation);
	}
	
	@PutMapping("/updateUserInfo/{id}")
	public String updatePersonalInfo(@RequestBody UserInformation userInformation, @PathVariable String id){
		return userInformationService.updatePersonalInfo(userInformation, id);
	}
	
	@DeleteMapping("/deleteUserInfo/{id}")
	public String deletePersonalInfo(@PathVariable String id) {
		return userInformationService.deletePersonalInfo(id);
	}
	
	//For clearing User Information collection
	@DeleteMapping("/deleteAllUserInfo")
	public String deleteAllUserInformation() {
		return userInformationService.deleteAllUserInformation();
	}
}
