package com.attempt3.apis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.attempt3.apis.model.AccountInformation;

@Repository
public interface AccountInformationRepository extends MongoRepository<AccountInformation, String>{

	AccountInformation findAllByUserId(String userId);

}
