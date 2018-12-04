package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.OrderDAO;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAllOrder() {
		return orderDAO.getAllOrder();
	}

	@Override
	@Transactional
	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		orderDAO.saveOrder(order);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}

	@Override
	@Transactional
	public void saverOrderProducts(Order order, Order_products oproducts) {
	Session session = sessionFactory.getCurrentSession();
	session.persist(order);
	session.persist(oproducts);
	}

	@Override
	public void saveOrderProducts() {
		// TODO Auto-generated method stub
		
	}
	
	
}
