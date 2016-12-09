package com.example.mts.repository;

import org.springframework.stereotype.Repository;

import com.example.mts.model.Account;

@Repository("hibAccountRepo")
public class HibAccountRepository  implements AccountRepository{

	@Override
	public Account load(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	
	
}
