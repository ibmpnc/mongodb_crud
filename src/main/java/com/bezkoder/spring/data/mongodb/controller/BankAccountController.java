package com.bezkoder.spring.data.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.model.BankAccount;
import com.bezkoder.spring.data.mongodb.model.Student;
import com.bezkoder.spring.data.mongodb.service.BankAccountService;
import com.bezkoder.spring.data.mongodb.service.RegistrationService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(value = "/accounts")
@AllArgsConstructor
@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;

	@GetMapping
	public Flux<BankAccount> getAll() {
		System.out.println("::will returns ALL Students records::");
		return bankAccountService.getAll();
	}
	
	
	@GetMapping("{id}")
	public Mono<BankAccount> getById(@PathVariable("id") final String id) {
		System.out.println("::will return a bankAccount record::");
		return bankAccountService.getById(id);
	}

	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final BankAccount bankAccount) {
		System.out.println("::update the bankAccount record::");
		return bankAccountService.update(id, bankAccount);
	}

	@PostMapping
	public Mono save(@RequestBody final BankAccount bankAccount) {
		System.out.println("will insert the bankAccount record :: "+ bankAccount.getName() );
		return bankAccountService.save(bankAccount);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		System.out.println("::will delete a Student record::");
		return bankAccountService.delete(id);
	}
	
	
	@GetMapping("/deleteall")
	public Mono deleteAll() {
		System.out.println("::will delete all bankaccount records::");
		return bankAccountService.deleteAll();
	}
}
