package com.example.mts;

import com.example.mts.repository.AccountRepository;
import com.example.mts.repository.JdbcAccountRepository;
import com.example.mts.service.TxrService;
import com.example.mts.service.TxrServiceImpl;

public class Application {

	public static void main(String[] args) {

		// init phase
		AccountRepository accountRepository=new JdbcAccountRepository();
		TxrService txrService=new TxrServiceImpl(accountRepository);

		// use phase
		txrService.txr(1000.00, "1", "2");
		

		// destory-phase
		txrService=null; // bad code..

	}

}
