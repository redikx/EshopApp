package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.media.jfxmedia.logging.Logger;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAllOrder() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Order> thisQuery = session.createQuery("from Order order by order_id",Order.class);
		List<Order> order = thisQuery.getResultList();
		return order;
	}

	@Override
	@Transactional
	public List<Order> getOrderOfCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Order> thisQuery = session.createQuery("from Order where customer_id = :customerId",Order.class);
		thisQuery.setParameter("customerId", customerId);
		List<Order> OrderList = thisQuery.getResultList();
		return OrderList;
	}
	
	
	@Override
	@Transactional
	public Order getOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, id);
		return order;
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query thisQuery = session.createQuery("delete Order where order_id = :toDelete");
		thisQuery.setParameter("toDelete", id);
		thisQuery.executeUpdate();
	}


}
