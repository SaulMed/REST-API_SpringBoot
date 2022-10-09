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
import com.rest.Model.City;
import com.rest.Service.ICityService;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private	ICityService cityservice;

	@GetMapping("/GetAll")
	public ResponseEntity<?> getAll() {
		List<City> lista = cityservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(cityservice.getAll());
	}

	@GetMapping("/GetById/{id}")
	public ResponseEntity<City> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(cityservice.getById(id));
	
	}
	
	@PostMapping("/NewCity")
	public ResponseEntity<City>neww(@RequestBody City city) {
		return ResponseEntity.ok().body(this.cityservice.neww(city));
	}
	
	@PutMapping("/UpdateCity/{id}")
	public ResponseEntity<City> update(@PathVariable long id, @RequestBody City city) {
		city.setId(id);
		return ResponseEntity.ok().body(this.cityservice.update(city));
	}
	
	@DeleteMapping("/DeleteCity/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.cityservice.deleteCity(id);
		return HttpStatus.OK;
	}
}