package com.monocept.service;

import java.util.List;

import com.monocept.entity.Bank;
import com.monocept.entity.Customer;

public interface BankService {

	void createBank(Bank bank);

	List<Bank> getAllBank();

	Bank getById(int id);

	void deleteById(int id);

	List<Customer> addCusInBank(int bankid, int cusId);

}
