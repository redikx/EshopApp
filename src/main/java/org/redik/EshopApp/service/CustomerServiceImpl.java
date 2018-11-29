package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.CustomerDAO;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerDAO customerDAO;
	
	 @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
	return customerDAO.getAllCustomer();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
	return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
	customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
	customerDAO.deleteCustomer(id);
	}


	@Override
	@Transactional
	public void saveCustomerWithCard(Customer theCustomer, CustomerCard customerCard) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(theCustomer);
		session.persist(theCustomer);
	}

	
}
