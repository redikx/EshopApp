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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public void saveCustomerWithCard(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		CustomerCard cCard = theCustomer.getCustomerCard();
		System.out.println(cCard);
		System.out.println(theCustomer);
		session.saveOrUpdate(cCard);
		session.saveOrUpdate(theCustomer);
	}

	@Override
	@Transactional
	public void saveCustomerWithCard2(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(theCustomer);
		String convertedId = Integer.toString(theCustomer.getId());
		int sizeId = convertedId.length();

		String cardString = "A";
		for (int i=1;i<6-sizeId;i++) {
			cardString=cardString+"0";
		}
		cardString = cardString + convertedId;
		CustomerCard custCard = new CustomerCard(cardString);
		theCustomer.setCustomerCard(custCard);
		custCard.setCustomer(theCustomer);
		session.saveOrUpdate(custCard);
		session.saveOrUpdate(theCustomer);
	}
	
	
}
