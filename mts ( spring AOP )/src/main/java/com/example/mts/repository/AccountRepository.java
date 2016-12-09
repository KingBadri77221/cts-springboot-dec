package com.example.mts.repository;

import com.example.mts.model.Account;

public interface AccountRepository {
	
	Account load(String num);
	void update(Account account);

}
