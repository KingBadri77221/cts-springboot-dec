package com.example.mts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mts.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(name = "/txr", method = RequestMethod.GET)
	public ModelAndView showTxtForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("txr-form");
		return mav;
	}

	@RequestMapping(name = "/txr", method = RequestMethod.POST)
	public ModelAndView doTxr(@RequestParam double amount, @RequestParam String fromAcc, @RequestParam String toAcc) {
		txrService.txr(amount, fromAcc, toAcc);
		ModelAndView mav = new ModelAndView();
		mav.addObject("status", "Txr success");
		mav.setViewName("txr-status");
		return mav;
	}

}
