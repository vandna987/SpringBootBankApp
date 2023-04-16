package com.monocept.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private int bankId;
	@Column(name = "full_name")
	private String fullName;
	private String abbreviation;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_bank_id",referencedColumnName = "bank_id")
	@JsonIgnore
	private List<Customer> customers = new ArrayList<>();
	
	
	public Bank(int bankId, String fullName, String abbreviation, List<Customer> customers) {
		super();
		this.bankId = bankId;
		this.fullName = fullName;
		this.abbreviation = abbreviation;
		this.customers = customers;
	}

	public Bank() {

	}
	
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	

}
