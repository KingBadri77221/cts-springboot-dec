package com.example.mts;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.mts.service.TxrService;

public class Application {

	public static void main(String[] args) {

		// init phase
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

		// use phase
		TxrService txrService = applicationContext.getBean("txrService", TxrService.class);
		txrService.txr(1000.00, "1", "2");

		// destory-phase
		applicationContext.close();

	}

}
