package com.attempt3.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attempt3.apis.model.LocationMaster;
import com.attempt3.apis.repository.AllowedCustomerRepository;
import com.attempt3.apis.repository.LocationMasterRepository;

@Service
public class LocationMasterService {

	@Autowired
	LocationMasterRepository locationMasterRepository;
	
	@Autowired
	AllowedCustomerService allowedCustomerService;

	public String postLocation(LocationMaster locationMaster) {

		locationMasterRepository.save(locationMaster);
		return "Location details saved successfully for userId: "+locationMaster.getUserId();
	}

	public String updateLocation(LocationMaster locationMaster, String id) {

		String per = allowedCustomerService.findByUserId(id).getUpdatingAllowed();
		
		if(per == "y") {
			locationMasterRepository.deleteById(id);
			locationMasterRepository.save(locationMaster);
			return "Location details successfully updated for userId: "+id;
		}
		else {
			return "Permission denied. Updating location information unsuccessfull for UserId:"+id;
		}
	}
}
