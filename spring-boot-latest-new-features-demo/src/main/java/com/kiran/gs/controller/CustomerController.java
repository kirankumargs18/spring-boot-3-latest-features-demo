package com.kiran.gs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.gs.dto.Customer;
import com.kiran.gs.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer-service")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customerService.addCustomer(customer);
	}
	
	
	@GetMapping
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
		
	}
	
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
	
		return customerService.getCustomerById(id);
	}

}
