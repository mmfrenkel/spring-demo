package com.learning.aopdemo.dao;

import org.springframework.stereotype.Component;


@Component 
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + ": adding account using membership dao class");
		
	}
}
