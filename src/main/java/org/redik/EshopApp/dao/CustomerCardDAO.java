package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCardDAO {

	public List<CustomerCard> getAllCustomerCards();
	
	public CustomerCard getCustomerCard(int id);
	
	public void saveCustomerCard(CustomerCard customerCard);
	
	public void deleteCustomerCard(int id);

	
}
