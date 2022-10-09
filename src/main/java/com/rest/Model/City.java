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
@Table(name="City")
public class City {
	
	@Id //Llave primaria de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "city")
	private String city;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}