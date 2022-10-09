package com.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Exception.Mensaje;
import com.rest.Model.Customer;
import com.rest.Service.ICustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private	ICustomerService customerservice;

	
	@GetMapping("/GetAll")
	public ResponseEntity<?> getAll() {
		List<Customer> lista = customerservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(customerservice.getAll());
	}


	@GetMapping("/GetById/{id}")
	public ResponseEntity<Customer> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(customerservice.getById(id));
	
	}
	
	
	@PostMapping("/NewCustomer")
	public ResponseEntity<Customer>neww(@RequestBody Customer customer) {
		return ResponseEntity.ok().body(this.customerservice.neww(customer));
	}
	


	@PutMapping("/UpdateCustomer/{id}")
	public ResponseEntity<Customer> update(@PathVariable long id, @RequestBody Customer customer) {
		customer.setId(id);
		return ResponseEntity.ok().body(this.customerservice.update(customer));
	}

	
	@DeleteMapping("/DeleteCustomer/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.customerservice.deleteCustomer(id);
		return HttpStatus.OK;
	}
}