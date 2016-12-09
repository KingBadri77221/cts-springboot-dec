package com.example.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mts.model.Account;
import com.example.mts.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	@Autowired
	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional(transactionManager = "txnManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public void txr(double amount, String fromAcc, String toAcc) {

		// load fromAcc
		Account fromAccount = accountRepository.load(fromAcc);

		// load toAcc
		Account toAccount = accountRepository.load(toAcc);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// update both accounts
		accountRepository.update(fromAccount);
		// if(true)throw new RuntimeException();
		accountRepository.update(toAccount);

	}

}
