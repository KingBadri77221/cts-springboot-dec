package com.example.mts;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.mts.config.MTSConfig;
import com.example.mts.service.TxrService;

public class Application {

	public static void main(String[] args) {

		// init phase
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new AnnotationConfigApplicationContext(MTSConfig.class);
		System.out.println("----------------------------------------------");
		// use phase
		TxrService txrService = applicationContext.getBean("txrService", TxrService.class);
		txrService.txr(1000.00, "1", "2");

		System.out.println("----------------------------------------------");
		// destory-phase
		applicationContext.close();

	}

}
