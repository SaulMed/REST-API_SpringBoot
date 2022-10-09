package com.rest.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rest.Repository.IAddressRepository;
import com.rest.Model.Address;
import com.rest.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class AddressService implements IAddressService {

	
	@Autowired
	private IAddressRepository addressRepository;
	
	@Override
	public List<Address> getAll() {
		return this.addressRepository.findAll();
	}


	@Override
	public Address neww(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address update(Address address) {
		Optional<Address> employeedb = this.addressRepository.findById(address.getId());
        //gettes and setters
		if (employeedb.isPresent()) {
			Address addressUpdate = employeedb.get();
			addressUpdate.setId(address.getId());
			addressUpdate.setStreet(address.getStreet());
			addressRepository.save(addressUpdate);
			return addressUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + address.getId());
		}
	}

	
	@Override
	public Address getById(long addressId) {

		Optional<Address> employeedb = this.addressRepository.findById(addressId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + addressId);
		}
	}

	@Override
	public void deleteAddress(long addressId) {
		Optional<Address> employeedb = this.addressRepository.findById(addressId);

		if (employeedb.isPresent()) {
			this.addressRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + addressId);
		}

	}

}



