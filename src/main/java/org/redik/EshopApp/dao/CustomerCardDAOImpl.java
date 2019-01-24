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
public class CustomerCardDAOImpl implements CustomerCardDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CustomerCard> getAllCustomerCards() {
	Session session = sessionFactory.getCurrentSession();
	TypedQuery<CustomerCard> thisQuery = session.createQuery("from CustomerCard order by id",CustomerCard.class);
	List<CustomerCard> customerCards = thisQuery.getResultList();
	return customerCards;
	
	}

	@Override
	public CustomerCard getCustomerCard(int id) {
	Session session = sessionFactory.getCurrentSession();
	CustomerCard customerCard = session.get(CustomerCard.class,id);
	return customerCard;
	}

	@Override
	@Transactional
	public void saveCustomerCard(CustomerCard customerCard) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(customerCard);
	}

	@Override
	@Transactional
	public void deleteCustomerCard(int id) {
	Session session = sessionFactory.getCurrentSession();
	Query theQuery = session.createQuery("delete from CustomerCard where id = :idToDelete");
	theQuery.setParameter("idToDelete", id);
	theQuery.executeUpdate();
	}


}
