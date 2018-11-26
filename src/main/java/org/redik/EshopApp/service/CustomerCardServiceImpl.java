package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.CustomerCardDAO;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCardServiceImpl implements CustomerCardService{

	@Autowired 
	private CustomerCardDAO customerCardDAO;
	
	 @Autowired
    private SessionFactory sessionFactory;

	
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

	@Override
	@Transactional
	public void saveCustomerWithCard(Customer theCustomer, CustomerCard theCustomerCard) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(theCustomerCard);
		session.persist(theCustomer);
	}

	
}
