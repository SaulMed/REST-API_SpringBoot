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
import com.rest.Model.Address;
import com.rest.Service.IAddressService;


@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private	IAddressService addressservice;

	
	@GetMapping("/GetAll")
	public ResponseEntity<?> getAll() {
		List<Address> lista = addressservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(addressservice.getAll());
	}


	@GetMapping("/GetById/{id}")
	public ResponseEntity<Address> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(addressservice.getById(id));
	
	}
	
	
	@PostMapping("/NewAddress")
	public ResponseEntity<Address>neww(@RequestBody Address address) {
		return ResponseEntity.ok().body(this.addressservice.neww(address));
	}
	


	@PutMapping("/UpdateAddress/{id}")
	public ResponseEntity<Address> update(@PathVariable long id, @RequestBody Address address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.addressservice.update(address));
	}

	
	@DeleteMapping("/DeleteAddress/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.addressservice.deleteAddress(id);
		return HttpStatus.OK;
	}
}