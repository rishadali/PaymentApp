/**
 * 
 */
package com.rishad.service;

import com.rishad.model.Transaction;

/**
 * @author rishadali
 *
 */
public interface TransactionService {
	Iterable<Transaction> findAllForAccount(String name);
	String makePayment(Transaction transaction);
	
}
