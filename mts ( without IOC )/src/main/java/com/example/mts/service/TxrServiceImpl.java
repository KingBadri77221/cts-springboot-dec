package com.example.mts.service;

import org.apache.log4j.Logger;

import com.example.mts.model.Account;
import com.example.mts.repository.JdbcAccountRepository;

/*
 * 
 *  OO principle:
 *  
 *  " closed for modification & Open for extensions"
 *  
 * 
 *  design & performance issues
 *  -----------------------------
 *  
 *  
 *  1. tight-coupling
 *  
 *     --> Maintenance issues.
 *  
 *  2. too many dependencies created/destroyed on repeated txr
 *  
 *     --> slow
 *  
 *  3. Unit Testing not possible
 *  
 *     --> bug fix slow , dev slow. 
 * 
 * 
 * 
 *  why these issues?
 *  
 *  dependent itself creating its own dependency
 *  
 *  soln:
 *  
 *  don't create dependency in dependent's class , do lookup
 *  
 *  limitation on lookup:
 *  
 *  location tight-coupling
 *  
 *  better soln:
 *  
 *  don't create & lookup , get/inject by some-one ( IOC )
 *  
 *  how to implement IOC ?
 *  
 *  --> thru 'Dependency Injection" ( DI )
 *  
 *      --> constructor DI
 *      --> setter DI
 *  
 *  --> thru AOP
 *  
 *  
 * 
 */

public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger(TxrService.class);

	@Override
	public void txr(double amount, String fromAcc, String toAcc) {

		logger.info("Txr initiated...");

		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		// load fromAcc
		Account fromAccount = accountRepository.load(fromAcc);

		// load toAcc
		Account toAccount = accountRepository.load(toAcc);

		// debit & credit

		// update both accounts
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		logger.info("Txr success...");

	}

}
