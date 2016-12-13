package com.example.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mts")
public class MTS {

	// @Pattern(regexp="\\w[A-Z]")  ( check )
	private String txrType;

	public String getTxrType() {
		return txrType;
	}

	public void setTxrType(String txrType) {
		this.txrType = txrType;
	}

}
