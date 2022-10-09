package com.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.Model.Address;
import com.rest.Repository.IAddressRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class MicroServiceAddressesTest {
	@Autowired
	IAddressRepository addressRepo;

	@Test
	public void testNewAddress() {
		Address address = new Address();
		address.setStreet("Insurgentes");
		addressRepo.save(address);

		assertNotNull(addressRepo.findAll());
	}

	@Test
	public void testGetAllAddress() {
		List<Address> lista = addressRepo.findAll();
		assertThat(lista).size().isGreaterThan(0);
	}

	@Test
	public void testGetByIdAddress() {
		Address address = addressRepo.findById((long) 13).get();
		assertNotEquals("Street Test", address.getStreet());
	}

	@Test
	public void testUpdateAddress() {
		Address address = addressRepo.findById((long) 14).get();
		address.setStreet("Av. Adolfo Lopez Mateos");
		addressRepo.save(address);
		assertEquals("Av. Adolfo Lopez Mateos", addressRepo.findById((long) 14).get().getStreet());
	}

	@Test
	public void testDeleteAddress() {
		assertThat(addressRepo.existsById((long) 20)).isFalse();
	}

}
