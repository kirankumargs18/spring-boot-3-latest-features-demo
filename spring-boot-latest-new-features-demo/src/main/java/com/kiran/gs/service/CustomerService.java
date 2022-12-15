package com.kiran.gs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.gs.dto.Customer;
import com.kiran.gs.exception.CustomerNotFoundException;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@Service
public class CustomerService {

	private List<Customer> customerList = new ArrayList<>();
	
	@Autowired
	private ObservationRegistry observationRegistry;

	public Customer addCustomer(Customer customer) {

		/**
		customerList.add(customer);
		return customer;
		*/
		
		customerList.add(customer);
		return  Observation.createNotStarted("addCustomer", observationRegistry)
				.observe(()-> customer);
	}

	public List<Customer> getCustomers() {

		/* return customerList; */
		
		return Observation.createNotStarted("getAllCustomers", observationRegistry)
				.observe(()-> customerList);
	}

	public Customer getCustomerById(Integer id) {
		
		/**
		 * inside observe(()-> object)
		 * object is something that we have to written
		 * */
		return Observation.createNotStarted("getCustomerById", observationRegistry)
				.observe(()->customerList.stream().filter(customer -> Objects.equals(customer.getId(), id)).findAny()
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID :" + id)));

	}

}
