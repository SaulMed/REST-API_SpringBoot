package com.rest.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rest.Repository.ICityRepository;
import com.rest.Model.City;
import com.rest.Exception.ResourceNotFoundException;


@Service 
@Transactional 
public class CityService implements ICityService {

	
	@Autowired
	private ICityRepository cityRepository;
	
	@Override
	public List<City> getAll() {
		return this.cityRepository.findAll();
	}


	@Override
	public City neww(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City update(City city) {
		Optional<City> employeedb = this.cityRepository.findById(city.getId());
        //gettes and setters
		if (employeedb.isPresent()) {
			City cityUpdate = employeedb.get();
			cityUpdate.setId(city.getId());
			cityUpdate.setCity(city.getCity());
			cityRepository.save(cityUpdate);
			return cityUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + city.getId());
		}
	}

	
	@Override
	public City getById(long cityId) {

		Optional<City> employeedb = this.cityRepository.findById(cityId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + cityId);
		}
	}

	@Override
	public void deleteCity(long cityId) {
		Optional<City> employeedb = this.cityRepository.findById(cityId);

		if (employeedb.isPresent()) {
			this.cityRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + cityId);
		}

	}

}



