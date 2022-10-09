package com.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.Model.City;
import com.rest.Repository.ICityRepository;

@SpringBootTest
public class MicroServiceCityTest {

	@Autowired
	ICityRepository cityRepo;

	@Test
	public void testNewCity() {
		City city = new City();
		city.setCity("Pachuca");
		cityRepo.save(city);
		assertNotNull(cityRepo.findAll());
	}

	@Test
	public void testGetAllCity() {
		List<City> lista = cityRepo.findAll();
		assertThat(lista).size().isGreaterThan(0);
	}

	@Test
	public void testGetByIdCity() {
		City city = cityRepo.findById((long) 3).get();
		assertNotEquals("Test City", city.getCity());
	}

	@Test
	public void testUpdateCity() {
		City city = cityRepo.findById((long) 5).get();
		city.setCity("Updated City");
		cityRepo.save(city);
		assertNotEquals("Ciudad actualizada", cityRepo.findById((long) 5).get().getCity());
	}

	@Test
	public void testDeleteCity() {
		assertThat(cityRepo.existsById((long) 30)).isFalse();
	}

}
