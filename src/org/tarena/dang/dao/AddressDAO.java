package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Address;

public interface AddressDAO {
	public List<Address> findByUserId(int userId) throws Exception;
	
	public List<Address> findAll() throws Exception;
	
	public Address findByFullAddress(String fullAddress) throws Exception;
	
	public void save(Address address) throws Exception;
	
	public Address findById(int id) throws Exception;

}
