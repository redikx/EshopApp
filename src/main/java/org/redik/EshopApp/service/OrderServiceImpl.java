package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.OrderDAO;
import org.redik.EshopApp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private OrderDAO orderDAO;

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
	
	
}
