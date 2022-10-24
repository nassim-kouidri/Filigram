package com.filigram.account.Repository;

import org.springframework.stereotype.Repository;

import com.filigram.account.Modele.Account;



/**
 * Fake Repository used for some tests...
 */
@Repository
public class FakeUserRepository {

	public Account findByFullname(String fullname) {
		// Fake data
		Account account = new Account();
		account.setFullname(fullname);
		account.setPassword("test");
		account.setMail(fullname+"@mail.com");
		return account;
	}	
	
}