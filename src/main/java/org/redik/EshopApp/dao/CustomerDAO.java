package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {

	public List<Customer> getAllCustomer();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
}
