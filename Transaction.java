package com.monocept.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	private LocalDateTime time ;
//	@Column(name = "receiver_acc")
//	private Account receiverAcc;
	private double amount;
	
	//@JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;
    
    //@JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
	
    @Column(name = "transaction_type")
    private String transactionType;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime localDateTime) {
		this.time = localDateTime;
	}
	
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	
	public Transaction(int transactionId, LocalDateTime time, double amount, Account fromAccount,
			Account toAccount) {
		super();
		this.transactionId = transactionId;
		this.time = time;
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	public Transaction() {
	}
	public int getTransaction_id() {
		return transactionId;
	}
	public void setTransaction_id(int transaction_id) {
		this.transactionId = transaction_id;
	}
	
	

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
