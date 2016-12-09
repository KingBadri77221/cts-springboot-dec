package com.example.mts.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.mts.model.Account;
import com.example.mts.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void txr(double amount, String fromAcc, String toAcc) {

		// load fromAcc
		Account fromAccount = accountRepository.load(fromAcc);

		// load toAcc
		Account toAccount = accountRepository.load(toAcc);

		// debit & credit

		// update both accounts
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

	}

}
