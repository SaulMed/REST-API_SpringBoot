package com.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.Model.Country;
import com.rest.Repository.ICountryRepository;

@SpringBootTest
public class MicroServiceCountryTest {

	@Autowired
	ICountryRepository countryRepo;

	@Test
	public void testSave() {
		Country country = new Country();
		country.setCountry("Toluca");
		countryRepo.save(country);
		assertNotNull(countryRepo.findAll());
	}

	@Test
	public void testFind() {
		List<Country> lista = countryRepo.findAll();
		assertThat(lista).size().isGreaterThan(0);
	}

	@Test
	public void testFindById() {
		Country country = countryRepo.findById((long) 3).get();
		assertEquals("Test Country", country.getCountry());
	}

	@Test
	public void testUpdateCountry() {
		Country country = countryRepo.findById((long) 3).get();
		country.setCountry("Updated Country");
		countryRepo.save(country);
		assertNotEquals("Updated Country Remix", countryRepo.findById((long) 3).get().getCountry());
	}

	@Test
	public void testDeleteCountry() {
		assertThat(countryRepo.existsById((long) 30)).isFalse();
	}
}
