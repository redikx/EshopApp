package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;

public interface CustomerService {

	public List<Customer> getAllCustomer();

	public Customer getCustomer(int id);

	public void saveCustomer(Customer customer);

	public void deleteCustomer(int id);

	void saveCustomerWithCard(Customer theCustomer);

	void saveCustomerWithCard2(Customer theCustomer);

}
