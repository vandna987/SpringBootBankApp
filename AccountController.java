package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Account;
import com.monocept.service.AccountService;
import com.monocept.service.TransactionService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/save")
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}

	@GetMapping("/get")
	public List<Account> getAll() {
		return accountService.getAll();
	}

	@GetMapping("/get/{id}")
	public Account getById(@PathVariable int id) {
		return accountService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		accountService.deleteById(id);
	}

	@GetMapping("/acctotal/{accnum}")
	public double accTotalBalance(@PathVariable int accnum) {
		return accountService.accTotalBalance(accnum);
	}

	@PutMapping("/{fromAccountNumber}/{toAccountNumber}/{amount}")
	public ResponseEntity<String> transferMoney(@PathVariable int fromAccountNumber, @PathVariable int toAccountNumber,
			@PathVariable Double amount) throws Exception {
		try {
			accountService.transferMoney(fromAccountNumber, toAccountNumber, amount);
			transactionService.transactionSave(accountService.getById(fromAccountNumber),
					accountService.getById(toAccountNumber), amount);
			return ResponseEntity.ok("Transfer successful");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insufficient balance");
		}
	}

	@PutMapping("/{accNum}/{amount}")
	public ResponseEntity<String> transferMoney(@PathVariable int accNum,@PathVariable double amount){
		accountService.transferMoney(accNum,amount);
		transactionService.transactionSave(accountService.getById(accNum),amount);
		return ResponseEntity.ok("Deposite Successfully!");
	}
}
