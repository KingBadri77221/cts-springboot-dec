package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.config.MTS;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	@Autowired
	private MTS mts;

	@Override
	public void txr(double amount, String from, String to) {
		System.out.println("txring....by - " + mts.getTxrType());
	}

}
