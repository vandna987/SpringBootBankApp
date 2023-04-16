package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cusrepository;
	@Autowired
	private AccountRepository accrepository;
	@Override
	public void saveCustomer(Customer customer) {
		cusrepository.save(customer);
	}
	@Override
	public List<Customer> getAllCustomer() {
		return cusrepository.findAll();
	}
	@Override
	public Customer findById(int id) {
		return cusrepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		cusrepository.deleteById(id);
	}
	@Override
	public Account mappingCusToAcc(int cusId, int accId) {
	    Customer customer = cusrepository.findById(cusId).get();
	    Account account = accrepository.findById(accId).get();
	    if(account.getCustomer()!=null) return account;
	    double balance = account.getBalance();
	    customer.setBalance(customer.getBalance()+balance);
	    List<Account> accounts = customer.getAccounts();
	    accounts.add(account);
	    
	    cusrepository.save(customer);
	    accrepository.save(account);
		return account;
	}
	@Override
	public double totalBalanceOfCus(int cusID) {
		Customer customer = cusrepository.findById(cusID).get();
		List<Account> accounts = customer.getAccounts();
		double totSum=0;
		for(Account a : accounts) {
			totSum += a.getBalance();
		}
		return totSum;
	}
	@Override
	public List<Account> tatalBankWiseBalance(int cusId) {
		return cusrepository.findById(cusId).get().getAccounts();
		
	}

}
