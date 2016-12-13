package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;


//@Configuration
@ConditionalOnClass(value = { TxrServiceImpl.class })
public class MTSAutoConfiguration {

//	@Bean
//	@ConditionalOnMissingBean(name = "txrService")
//	public TxrService txrService() {
//		TxrService txrService = new TxrServiceImpl();
//		return txrService;
//	}
//
//	@Bean
//	@ConditionalOnProperty(prefix = "mts", name = "txrType")
//	public TxrService impsTxrService() {
//		TxrService txrService = new TxrServiceImpl();
//		return txrService;
//	}

	
	// ...............

}
