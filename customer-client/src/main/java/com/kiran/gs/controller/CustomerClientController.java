package com.kiran.gs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.gs.client.CustomerClientService;
import com.kiran.gs.dto.Customer;

@RestController
@RequestMapping("/api/v1/customer-client")
public class CustomerClientController {

	@Autowired
	private CustomerClientService customerClientService;

	@GetMapping
	public List<Customer> fecthAllCustomersFromCustomerService() {
		return customerClientService.getAllCustomersFromCustomerService();
	}

}
