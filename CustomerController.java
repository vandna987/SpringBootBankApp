package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping("/save")
	public void saveCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
	}
	@GetMapping("/get")
	public List<Customer> getAllCustomer(){
		return service.getAllCustomer();
	}
	@GetMapping("/get/{id}")
	public Customer findById(@PathVariable int id) {
		return service.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	@PutMapping("/{cusId}/{accId}")
	public Account mappingCusToAcc(@PathVariable int cusId,@PathVariable int accId) {
		return service.mappingCusToAcc(cusId,accId);
	}
	@GetMapping("/totalbalance/{cusID}")
	public double totalBalanceOfCus(@PathVariable int cusID) {
		return service.totalBalanceOfCus(cusID);
	}
	@GetMapping("/bankbalance/{cusId}")
	public List<Account> tatalBankWiseBalance(@PathVariable int cusId){
		return service.tatalBankWiseBalance(cusId);
	}
}
