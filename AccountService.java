package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;

public interface AccountService {

	void createAccount(Account account);

	List<Account> getAll();

	Account getById(int id);

	void deleteById(int id);

	double accTotalBalance(int accnum);

	void transferMoney(int fromAccountNumber, int toAccountNumber, Double amount);

	void transferMoney(int accNum, double amount);

	

}
