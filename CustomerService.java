package com.monocept.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;

public interface CustomerService {

	void saveCustomer(Customer customer);

	List<Customer> getAllCustomer();

	Customer findById(int id);

	void deleteById(int id);

	Account mappingCusToAcc(int cusId, int accId);

	double totalBalanceOfCus(int cusID);

	List<Account> tatalBankWiseBalance(int cusId);

}
