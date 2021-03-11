package com.bezkoder.spring.data.mongodb.service;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.spring.data.mongodb.model.BankAccount;
import com.bezkoder.spring.data.mongodb.repository.BankAccountRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public Flux<BankAccount> getAll() {
		return bankAccountRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<BankAccount> getById(final String id) {
		return bankAccountRepository.findById(id);
	}

	public Mono update(final String id, final BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

	public Mono save(final BankAccount bankAccount) {
		
		
		return bankAccountRepository.save(bankAccount);
	}
	
	public Mono delete(final String id) {
		final Mono<BankAccount> dbStudent = getById(id);
		if (Objects.isNull(dbStudent)) {
			return Mono.empty();
		}
		return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted -> bankAccountRepository
				.delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
	}
	
	
	
	public Mono deleteAll() {
		return bankAccountRepository.deleteAll();
	}
}

