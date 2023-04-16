package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;
import com.monocept.entity.Transaction;

public interface TransactionService {

	void save(Transaction transaction);

	List<Transaction> getAll();

	Transaction getById(int id);

	void deleteById(int id);

	void transactionSave(Account fromAccount, Account toAccount, Double amount);

	void transactionSave(Account account, double amount);

}
