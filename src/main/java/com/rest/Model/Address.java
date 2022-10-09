package com.rest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Address")
public class Address {
	
	@Id //Llave primaria de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "street")
	private String street;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}