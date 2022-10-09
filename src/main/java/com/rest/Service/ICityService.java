package com.rest.Service;

import java.util.List;

import com.rest.Model.City;

public interface ICityService {

	City neww(City city);
	
	City update(City city);
	
	List<City> getAll();

	City getById(long cityId);
	
	void deleteCity(long id);
}
