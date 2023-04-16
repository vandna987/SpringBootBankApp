package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Bank;
import com.monocept.entity.Customer;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.BankRepository;
import com.monocept.repository.CustomerRepository;
@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankRepository bankrepository;
	@Autowired
	private CustomerRepository cusrepository;
	
	@Override
	public void createBank(Bank bank) {
		bankrepository.save(bank);
	}

	@Override
	public List<Bank>  getAllBank() {
		return bankrepository.findAll();
		
	}

	@Override
	public Bank getById(int id) {
		return bankrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bankrepository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Customer> addCusInBank(int bankid, int cusId) {
		
		Bank bank = bankrepository.findById(bankid).get();
		
		 Customer customer = cusrepository.findById(cusId).get();
		 if(customer.getBank()!=null) return bank.getCustomers();
		 customer.setBank(bank);
	     List<Customer> customers = bank.getCustomers();
	    customers.add(customer);
	    bank.setCustomers(customers);
	    bankrepository.save(bank);
	    cusrepository.save(customer);
	    return bank.getCustomers();
	}

	
	

}
