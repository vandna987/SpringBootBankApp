package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accRepository;
	@Autowired
	private CustomerService customerService;
	@Override
	public void createAccount(Account account) {
		accRepository.save(account);
	}
	@Override
	public List<Account> getAll() {
		return accRepository.findAll();
	}
	@Override
	public Account getById(int id) {
		return accRepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		accRepository.deleteById(id);
	}
	@Override
	public double accTotalBalance(int accnum) {
		Account account = accRepository.findById(accnum).get();
		return account.getBalance();
	}
	@Override
	public void transferMoney(int fromAccountNumber, int toAccountNumber, Double amount) {
		Account fromAccount = accRepository.findById(fromAccountNumber).get();
		if(fromAccount==null) return;
		Account toAccount = accRepository.findById(toAccountNumber).get();
		if(toAccount==null) return;
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		fromAccount.getCustomer().setBalance(fromAccount.getCustomer().getBalance()-amount);
		toAccount.getCustomer().setBalance(toAccount.getCustomer().getBalance()+amount);
	}
	@Override
	public void transferMoney(int accNum, double amount) {
		Account account = accRepository.findById(accNum).get();
		if(account==null) return;
		account.setBalance(account.getBalance()+amount);
		account.getCustomer().setBalance(account.getCustomer().getBalance()+amount);
	}

}
