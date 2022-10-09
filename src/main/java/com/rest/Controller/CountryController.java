package com.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Exception.Mensaje;
import com.rest.Model.Country;
import com.rest.Service.ICountryService;

//@CrossOrigin(origins="*", methods = {RequestMethod.POST})
@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private ICountryService countryService;
	
	
//Methods
	
	@GetMapping("/find")
	public ResponseEntity<?> find(){
		List<Country> lista = countryService.obtenerTodos();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin data en la BD."), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryService.obtenerTodos());
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Country> findById(@PathVariable long id){
		return ResponseEntity.ok().body(countryService.buscarUno(id));
	}

	@PostMapping("/save")
	public ResponseEntity<Country> save(@RequestBody Country country){
		return ResponseEntity.ok().body(this.countryService.nuevo(country));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Country> update(@PathVariable long id, @RequestBody Country country){
		country.setId(id);
		return ResponseEntity.ok().body(this.countryService.actualizar(country));
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable long id ) {
		this.countryService.eliminar(id);
		return HttpStatus.OK;
	}

}
