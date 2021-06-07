/**
 * 
 */
package com.rishad.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

/**
 * @author rishadali
 *
 */
@Entity
public class Transaction {
	/*
	public enum TransactionType {
	    IN,
	    OUT
	}
	@Enumerated(EnumType.STRING)
    private TransactionType type;
    */
	
	@Id
	@GeneratedValue
	private int id;
	@CreationTimestamp
	private Timestamp datetime;
	private double amount;
	private String payto;
	private String payfrom;

	public Transaction() {}
	
	public Transaction(String from, String to, double amount) {
		this.amount = amount;
		this.payto = to;
		this.payfrom = from;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPayto() {
		return payto;
	}

	public void setPayto(String payto) {
		this.payto = payto;
	}

	public String getPayfrom() {
		return payfrom;
	}

	public void setPayfrom(String payfrom) {
		this.payfrom = payfrom;
	}
	
}
