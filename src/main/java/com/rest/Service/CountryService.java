package com.rest.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Exception.ResourceNotFoundException;
import com.rest.Model.Country;
import com.rest.Repository.ICountryRepository;

@Service
@Transactional
public class CountryService implements ICountryService{
	
	@Autowired
	private ICountryRepository countryRepository;

	@Override
	public List<Country> obtenerTodos() {
		return this.countryRepository.findAll();
	}
	
	@Override
	public Country buscarUno(long countryId) {
		Optional<Country> countryDb = this.countryRepository.findById(countryId);
		if(countryDb.isPresent()) {
			return countryDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con Id: "+countryId);
		}
	}
	
	@Override
	public Country nuevo(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country actualizar(Country country) {
Optional<Country> countryDb = this.countryRepository.findById(country.getId());
if(countryDb.isPresent()) {
	Country countryUpdated = countryDb.get();
	countryUpdated.setId(country.getId());
	countryUpdated.setCountry(country.getCountry());
	countryRepository.save(countryUpdated);
	return countryUpdated;
}else {
	throw new ResourceNotFoundException("Registro no encontrado para ACTUALIZAR con Id: "+country.getId());
}
	}


	@Override
	public void eliminar(long id) {
Optional<Country> countryDb = this.countryRepository.findById(id);
if(countryDb.isPresent()) {
	this.countryRepository.delete(countryDb.get());
}else {
	throw new ResourceNotFoundException("Registro no encontrado para ELIMINAR con Id: "+ id);
}
		
	}

}
