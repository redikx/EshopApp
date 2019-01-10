package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.OrderDAO;
import org.redik.EshopApp.dao.Order_productsDAO;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private Order_productsDAO order_productsDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order> getAllOrder() {
		return orderDAO.getAllOrder();
	}

	@Override
	@Transactional
	public List<Order> getAllOrderOfCustomer(int customerId) {
		return orderDAO.getOrderOfCustomer(customerId);
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
	public void deleteWholeOrder(int id) {
		order_productsDAO.deleteOrder_allProducts(id);
		orderDAO.deleteOrder(id);
	}
	
	@Override
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

	@Override
	public void addProductToOrder(Order order, Order_products oproduct) {
		oproduct.setOrder(order);
		order.addProduct(oproduct);
		Session session = sessionFactory.getCurrentSession();
		session.persist(order);
		session.persist(oproduct);
	}
	
}
