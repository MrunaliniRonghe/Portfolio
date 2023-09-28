package com.attempt3.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attempt3.apis.model.LocationMaster;
import com.attempt3.apis.service.LocationMasterService;

@Controller
public class LocationMasterController {

	@Autowired
	LocationMasterService locationMasterService;
	
	@PostMapping("/addLocationMaster")
	public String postLocation(@RequestBody LocationMaster locationMaster) {
		return locationMasterService.postLocation(locationMaster);
	}
	
	@PutMapping("/updateLocation/{id}")
	public String updateLocation(@RequestBody LocationMaster locationMaster, @PathVariable String id) {
		return locationMasterService.updateLocation(locationMaster, id);
	}
}
