package com.bezkoder.spring.data.mongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.data.mongodb.model.BankAccount;



@Repository
public interface BankAccountRepository extends  ReactiveMongoRepository<BankAccount, String>{

}
