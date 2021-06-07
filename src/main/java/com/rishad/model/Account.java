/**
 * 
 */
package com.rishad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rishadali
 *
 */
@Entity
public class Account {
	@Id
	private String name;
	private double balance;
	private String email;
	
	public Account() {
		
	}
	public Account(String name, double balance, String email) {
		this.name = name;
		this.balance = balance;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
