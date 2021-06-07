package com.rishad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rishad.model.Account;
import com.rishad.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accService;
	
	@RequestMapping("/")
	public ModelAndView accountList() {
		ModelAndView mv = new ModelAndView("home.jsp");
		Iterable<Account> list = accService.findAll();
		mv.addObject("accountList", list);
		return mv;
	}
	
	
	@RequestMapping("/payment")
	public ModelAndView payment() {
		ModelAndView mv = new ModelAndView("pay.jsp");
		Iterable<Account> list = accService.findAll();
		mv.addObject("accountList", list);
		return mv;
	}
}
