package com.rest.Service;

import java.util.List;

import com.rest.Model.Customer;


public interface ICustomerService {

	Customer neww(Customer customer);

	Customer update(Customer customer);
	
	List<Customer> getAll();

	Customer getById(long customerId);

	void deleteCustomer(long id);
}
