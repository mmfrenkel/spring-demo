package com.learning.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.aopdemo.Account;


@Component
public class AccountDAO {
	
	String name;
	String serviceCode;
	
	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": doing database work, adding account");
	}
	
	public List<Account> findAccounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts and add them
		accounts.add(new Account("John", "Silver"));
		accounts.add(new Account("Aimee", "Gold"));
		accounts.add(new Account("Andrew", "Bronze"));
		
		return accounts;
	}
	
	public void addInfo(boolean vipFlag) {
		
		System.out.println(getClass() + ": adding info, with VIP flag");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
}
