package com.attempt3.apis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.attempt3.apis.model.UserInformation;

@Repository
public interface UserInformationRepository extends MongoRepository<UserInformation, String>{

	List<UserInformation> findAllByUserId(String id);

}
