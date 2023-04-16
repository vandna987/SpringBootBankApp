package com.monocept.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Transaction;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.TransacationRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransacationRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;
	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getById(int id) {
		return transactionRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		transactionRepository.deleteById(id);
	}

	@Override
	public void transactionSave(Account fromAccount, Account toAccount, Double amount) {
		Transaction transaction = new Transaction();

		transaction.setFromAccount(fromAccount);
		
		transaction.setToAccount(toAccount);
		transaction.setAmount(amount);
		System.out.println(transaction);
		transaction.setTime(LocalDateTime.now());
		transaction.setTransactionType("Transfer");
//		fromAccount.setBalance(fromAccount.getBalance()-amount);
//		toAccount.setBalance(toAccount.getBalance()+amount);
//		fromAccount.getCustomer().setBalance(fromAccount.getCustomer().getBalance()-amount);
//		toAccount.getCustomer().setBalance(toAccount.getCustomer().getBalance()+amount);
//		accountRepository.save(toAccount);
//		accountRepository.save(fromAccount);
		transactionRepository.save(transaction);

	}

	@Override
	public void transactionSave(Account account, double amount) {
		Transaction transaction = new Transaction();
		 transaction.setFromAccount(account);
	        transaction.setToAccount(account);
	        transaction.setAmount(amount);
	        transaction.setTime(LocalDateTime.now());
	        transaction.setTransactionType("Deposit");

	        transactionRepository.save(transaction);
	}

}
