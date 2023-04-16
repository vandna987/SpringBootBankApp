package com.monocept.entity;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_num")
	private int accNum=(int) (Math.random()*Math.pow(10, 5));
	
	private double balance=1000;

	@JsonIgnore
	@OneToMany(mappedBy = "fromAccount")
    private Set<Transaction> outgoingTransactions = new HashSet<>();
    
	@JsonIgnore
    @OneToMany(mappedBy = "toAccount")
    private Set<Transaction> incomingTransactions = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="fk_cus_id")
	private Customer customer;

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	



	public Account(int accNum, double balance, Set<Transaction> outgoingTransactions,
			Set<Transaction> incomingTransactions, Customer customer) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.outgoingTransactions = outgoingTransactions;
		this.incomingTransactions = incomingTransactions;
		this.customer = customer;
	}

	public Account() {

	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<Transaction> getOutgoingTransactions() {
		return outgoingTransactions;
	}

	public void setOutgoingTransactions(Set<Transaction> outgoingTransactions) {
		this.outgoingTransactions = outgoingTransactions;
	}

	public Set<Transaction> getIncomingTransactions() {
		return incomingTransactions;
	}

	public void setIncomingTransactions(Set<Transaction> incomingTransactions) {
		this.incomingTransactions = incomingTransactions;
	}

	

	

}
