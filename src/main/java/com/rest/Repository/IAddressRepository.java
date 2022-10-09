package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Model.Address;

//Notación para indicar que es un repositorio
@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}

