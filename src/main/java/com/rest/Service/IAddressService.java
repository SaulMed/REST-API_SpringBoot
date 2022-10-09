package com.rest.Service;

import java.util.List;
import com.rest.Model.Address;

public interface IAddressService {

	Address neww(Address address);

	Address update(Address address);
	
	List<Address> getAll();

	Address getById(long addressId);

	void deleteAddress(long id);
}
