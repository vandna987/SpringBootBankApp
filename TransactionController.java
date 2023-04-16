package com.monocept.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Transaction;
import com.monocept.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	private TransactionService service;
	
	@PostMapping("/save")
	public void save(@RequestBody Transaction transaction) {
		service.save(transaction);
	}
	
	@GetMapping("/get")
	public List<Transaction> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Transaction getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
