package com.rest.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rest.Repository.ICustomerRepository;
import com.rest.Model.Customer;
import com.rest.Exception.ResourceNotFoundException;


@Service 
@Transactional 
public class CutomerService implements ICustomerService {

	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAll() {
		return this.customerRepository.findAll();
	}
	

	@Override
	public Customer getById(long customerId) {

		Optional<Customer> employeedb = this.customerRepository.findById(customerId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}
	}


	@Override
	public Customer neww(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		Optional<Customer> employeedb = this.customerRepository.findById(customer.getId());
        //getters and setters
		if (employeedb.isPresent()) {
			Customer customerUpdate = employeedb.get();
			customerUpdate.setId(customer.getId());
			customerUpdate.setName(customer.getName());
			customerUpdate.setSurname(customer.getSurname());
			customerRepository.save(customerUpdate);
			return customerUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + customer.getId());
		}
	}


	@Override
	public void deleteCustomer(long customerId) {
		Optional<Customer> employeedb = this.customerRepository.findById(customerId);

		if (employeedb.isPresent()) {
			this.customerRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}

	}

}



