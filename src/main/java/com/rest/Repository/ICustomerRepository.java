package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Model.Customer;

//Notación para indicar que es un repositorio
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}

