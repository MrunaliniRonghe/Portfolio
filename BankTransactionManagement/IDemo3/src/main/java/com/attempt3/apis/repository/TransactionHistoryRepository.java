package com.attempt3.apis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.attempt3.apis.model.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends MongoRepository<TransactionHistory, String>{

	List findAllByUserId(String userId);
	
	@Query("{$year : {$eq : ?1} , 'userId' : ?0}")
	List findAllByYear(String id, int y);

	@Query("{$month : {&eq : ?1} , 'userId' : ?0}")
	List findByMonth(String id, int m);
}
