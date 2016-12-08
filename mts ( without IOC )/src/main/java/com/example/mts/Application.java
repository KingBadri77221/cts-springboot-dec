package com.example.mts;

import com.example.mts.service.TxrServiceImpl;

public class Application {

	public static void main(String[] args) {

		// init phase
		TxrServiceImpl txrService=new TxrServiceImpl();

		// use phase
		txrService.txr(1000.00, "1", "2");
		

		// destory-phase
		txrService=null; // bad code..

	}

}
