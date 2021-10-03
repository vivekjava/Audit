package com.vivek.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.jetty.util.ajax.JSONObjectConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.entity.Account;
import com.vivek.entity.Address;
import com.vivek.repository.AccountRepository;

@RestController
@RequestMapping
public class AccountResource {
	@Autowired
	private AccountRepository accRepo;
	
	
	@GetMapping(value = "/status")
	public Object GetAppStatus() {
		//List<Account> list =  accRepo.findAll();
		Account account = new Account();
		account.setAccountname("Test");
		account.setAge("adult");
		//account.setAge(name);
		Account acc = accRepo.save(account);
		return acc;
	}
	
	@GetMapping(value = "/saveandshow")
	public Object GetsavedValue(@RequestParam("name") String name,@RequestParam("id") Long id ) {
		//List<Account> list =  accRepo.findAll();
		Account acc_find = accRepo.getOne(Long.valueOf(id));
		Account account = new Account();
		account.setId(acc_find.getId());
		account.setAccountname(name);
		//account.setAge(name);
		Account acc = accRepo.save(account);
		Optional<Account> accountgGe = accRepo.findById(acc.getId());
		System.out.println("Accont "+accountgGe);
		List<Long> list = new ArrayList<Long>();
		list.add(id);
		Object resp = accRepo.findAllById(list);
		System.out.println("Details "+resp);
		return "Success";		
	}
	
	@GetMapping(value = "/show")
	public Object GeValue(@RequestParam("id") Long id) {
		
		return accRepo.findById(id);		
	}
	
	
	@GetMapping(value = "/error")
	public String HandleError() {
		return "Error";
	}
}
