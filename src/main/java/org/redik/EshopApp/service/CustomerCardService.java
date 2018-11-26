package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;

public interface CustomerCardService {

	public List<CustomerCard> getAllCustomerCards();

	public CustomerCard getCustomerCard(int id);

	public void saveCustomerCard(CustomerCard customerCard);

	public void deleteCustomerCard(int id);

	public void saveCustomerWithCard(Customer customer, CustomerCard customerCard);
}
