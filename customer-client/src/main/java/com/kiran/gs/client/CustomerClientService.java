package com.kiran.gs.client;

import java.util.List;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.kiran.gs.dto.Customer;

@HttpExchange("/api/v1/customer-service")
public interface CustomerClientService {
	
	@GetExchange
	 List<Customer> getAllCustomersFromCustomerService();

}
