package com.attempt3.apis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.attempt3.apis.model.LocationMaster;

@Repository
public interface LocationMasterRepository extends MongoRepository<LocationMaster, String>{
	
}
