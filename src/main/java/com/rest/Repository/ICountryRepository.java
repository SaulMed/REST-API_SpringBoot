package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.Model.Country;

public interface ICountryRepository extends JpaRepository<Country , Long>{

}
