package com.rishad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icegreen.greenmail.util.GreenMailUtil;
import com.rishad.dao.AccountRepo;
import com.rishad.dao.TransactionRepo;
import com.rishad.model.Account;
import com.rishad.model.Transaction;
import com.rishad.service.TransactionService;

/**
 * @author rishadali
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepo transRepo;
	
	@Autowired
	private AccountRepo accRepo;
		
	@Override
	public Iterable<Transaction> findAllForAccount(String name) {
		return transRepo.findByPaytoOrPayfrom(name,name);
	}

	@Override
	public String makePayment(Transaction transaction) {
		
		String response = "";
		
		Account from = null;
		Account to = null;
		try {
			from = accRepo.findById(transaction.getPayfrom()).orElseThrow();
			to = accRepo.findById(transaction.getPayto()).orElseThrow();
			//Check both to/from are not same
			if(transaction.getPayfrom().equals(transaction.getPayto())) {
				response = "Invalid request!";
			}
			else if (transaction.getAmount()==0) {
				response = "Invalid request!";
			}
			else {
				//Check balance
				if(checkBalance(transaction, from)) {
					
					//Update balance in to/from accounts
					updateBalance(transaction, from, to);
					
					//Send email
					sendEmail(from, to, transaction);
					
					//Save the transaction
					transRepo.save(transaction);
					
					response = "Hurray... transaction was successful!";
				}
				else {
					response = "Insufficient balance, transaction was unsuccessful!";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = "Invalid request!";
		}
		return response;
	}

	private void updateBalance(Transaction transaction, Account from, Account to) {
		from.setBalance(from.getBalance()-transaction.getAmount());
		to.setBalance(to.getBalance()+transaction.getAmount());
		accRepo.save(from);
		accRepo.save(to);
	}

	private void sendEmail(Account from, Account to, Transaction transaction) {

		String fromMsg = "Your account has been credited with £"+transaction.getAmount()+". You new balance is £"+from.getBalance();
		String toMsg = "Your account has been debted with £"+transaction.getAmount()+". You new balance is £"+to.getBalance(); 
		
		System.out.println(fromMsg);
		System.out.println(toMsg);
		
		try {
			//Send email to sending account
			GreenMailUtil.sendTextEmailTest(from.getEmail(), "mrishadali@gmail.com", "Transaction Update", fromMsg);
			
			//Send email to receiving account
			GreenMailUtil.sendTextEmailTest(to.getEmail(), "mrishadali@gmail.com", "Transaction Update", toMsg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}

	private boolean checkBalance(Transaction transaction, Account from) {
		return transaction.getAmount()<=from.getBalance();
	}

}
