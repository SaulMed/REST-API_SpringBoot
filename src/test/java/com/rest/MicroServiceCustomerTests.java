package com.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.Model.Customer;
import com.rest.Repository.ICustomerRepository;

//Importacion de assertions
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class MicroServiceCustomerTests {

	@Autowired
	ICustomerRepository customerRepo;

	@Test
	public void testNewCustomer() {
		Customer customer = new Customer();
		customer.setName("Hi I'm Name Test3");
		customer.setSurname("Hi I'm Surname Test3");
		customerRepo.save(customer);

		assertNotNull(customerRepo.findAll());
	}

	@Test
	public void testGetAllCustomer() {
		List<Customer> list = customerRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void testGetByIdCustomer() {
		Customer customer = customerRepo.findById((long) 7).get();
		assertEquals("Angel Test", customer.getSurname());
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepo.findById((long) 6).get();
		customer.setName("Tom");
		customer.setSurname("Timal");
		customerRepo.save(customer);
		assertNotEquals("Resultado Esperado", customerRepo.findById((long) 6).get().getSurname());
	}

	@Test
	public void testDeleteCustomer() {
		assertThat(customerRepo.existsById((long) 13)).isFalse();
	}

}
