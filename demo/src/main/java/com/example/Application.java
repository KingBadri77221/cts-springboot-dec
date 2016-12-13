package com.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.example.config.MTS;
import com.example.service.TxrService;


@SpringBootApplication
// @EnableConfigurationProperties(value = { MTS.class })
// @PropertySource("mts.properties")
public class Application {

	public static void main(String[] args) {
		//
		// SpringApplication app=new SpringApplication(Application.class);
		// app.setDefaultProperties(defaultProperties);

		ApplicationContext context = SpringApplication.run(Application.class, args);
		TxrService txrService = context.getBean("txrService", TxrService.class);
		txrService.txr(1000.00, "11", "22");

	}

}
