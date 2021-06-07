/**
 * 
 */
package com.rishad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishad.dao.AccountRepo;
import com.rishad.model.Account;
import com.rishad.service.AccountService;

/**
 * @author rishadali
 *
 */
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepo accRepo;
	
	@Override
	public Iterable<Account> findAll() {
		return accRepo.findAll();
	}

}
