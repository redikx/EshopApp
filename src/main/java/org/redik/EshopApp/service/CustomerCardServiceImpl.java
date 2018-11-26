package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.redik.EshopApp.dao.CustomerCardDAO;
import org.redik.EshopApp.entity.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCardServiceImpl implements CustomerCardService{

	@Autowired 
	private CustomerCardDAO customerCardDAO;
	
	
	@Override
	@Transactional
	public List<CustomerCard> getAllCustomerCards() {
	return customerCardDAO.getAllCustomerCards();
	}

	@Override
	@Transactional
	public CustomerCard getCustomerCard(int id) {
	return customerCardDAO.getCustomerCard(id);
	}

	@Override
	@Transactional
	public void saveCustomerCard(CustomerCard customerCard) {
	customerCardDAO.saveCustomerCard(customerCard);
	}

	@Override
	@Transactional
	public void deleteCustomerCard(int id) {
	customerCardDAO.deleteCustomerCard(id);
	}

}
