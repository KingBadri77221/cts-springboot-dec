package com.example.mts.repository;

import org.apache.log4j.Logger;

import com.example.mts.model.Account;

public class JdbcAccountRepository  implements AccountRepository{
	
	private static Logger logger = Logger.getLogger(AccountRepository.class);

	@Override
	public Account load(String num) {
		logger.info("loading account - "+num);
		return null;
	}

	@Override
	public void update(Account account) {
		//logger.info("updating account - "+account.getNum());
	}

}
