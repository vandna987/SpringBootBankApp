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

import com.monocept.entity.Bank;
import com.monocept.entity.Customer;
import com.monocept.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private BankService service  ;
	@PostMapping("/save")
	public void createBank(@RequestBody Bank bank) {
		service.createBank(bank);
	}
	@GetMapping("/get")
	public List<Bank> getAllBank(){
		return service.getAllBank();
	}
	@GetMapping("/get/{id}")
	public Bank getById(@PathVariable int id) {
		return service.getById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id)
	{
		service.deleteById(id);
	}
	@PutMapping("/{bankid}/{cusId}")
	public List<Customer> addCusInBank(@PathVariable int bankid,@PathVariable int cusId) {
		return service.addCusInBank(bankid,cusId);
	}
}
