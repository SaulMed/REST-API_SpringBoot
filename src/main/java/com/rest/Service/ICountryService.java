package com.rest.Service;

import java.util.List;

import com.rest.Model.Country;

public interface ICountryService {
	
	Country nuevo(Country country);
	
	Country actualizar(Country country);
	
	List<Country> obtenerTodos();
	
	Country buscarUno(long countryId);
	
	void eliminar(long id);
}
