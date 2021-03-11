package com.bezkoder.spring.data.mongodb.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document

public class BankAccount implements Serializable{

	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private  String balance;
	private  String name;
	private  String address;
	private  String accountType;
	
	

	@Override
	    public String toString() {
	        return "bank_account{" +
	        		"id='" + id+ '\'' +
	                "name='" + name + '\'' +
	                ", address='" + address + '\'' +
	                "balancd='" + balance+ '\'' +
	                "account_type='" + accountType + '\'' +
	                '}';
	    }
}