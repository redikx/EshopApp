package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Customer> thisQuery = session.createQuery("from Customer order by id",Customer.class);
		List<Customer> customer = thisQuery.getResultList();
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query thisQuery = session.createQuery("delete from Customer where id = :toDelete");
		session.setProperty("toDelete", id);
		thisQuery.executeUpdate();
	}

}
