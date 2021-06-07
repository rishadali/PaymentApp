package com.rishad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rishad.model.Transaction;
import com.rishad.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transService;
	
	
	
	@RequestMapping("/makePayment")
	public ModelAndView makePayment(Transaction transaction) {
		String response = transService.makePayment(transaction);
		ModelAndView mv = new ModelAndView("response.jsp");
		mv.addObject("response", response);
		return mv;
	}
	
	@RequestMapping("/accountTransactions")
	public ModelAndView allTransactions(String name) {
		ModelAndView mv = new ModelAndView("transactions.jsp");
		Iterable<Transaction> list = transService.findAllForAccount(name);
		mv.addObject("transactionList", list);
		return mv;
	}
}
