package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAllOrder() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Order> thisQuery = session.createQuery("from Order order by id",Order.class);
		List<Order> order = thisQuery.getResultList();
		return order;
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
		Query thisQuery = session.createQuery("delete from Order where id = :toDelete");
		session.setProperty("toDelete", id);
		thisQuery.executeUpdate();
	}

}
