package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Order_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Order_productsDAOImpl implements Order_productsDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Order_products> getAllOrder_products() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Order_products> thisQuery = session.createQuery("from Order_products order by id",Order_products.class);
		List<Order_products> order_products = thisQuery.getResultList();
		return order_products;
	}

	@Override
	@Transactional
	public Order_products getOrder_products(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order_products order_products = session.get(Order_products.class, id);
		return order_products;
	}

	@Override
	@Transactional
	public void saveOrder_products(Order_products order_products) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(order_products);
	}

	@Override
	public void deleteOrder_products(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query thisQuery = session.createQuery("delete Order_products where id = :toDelete");
		thisQuery.setParameter("toDelete", id);
		thisQuery.executeUpdate();
	}

	@Override
	public void deleteOrder_allProducts(int id) {
		System.out.println("Deleting Whole order including products");
		Session session = sessionFactory.getCurrentSession();
		Query thisQuery = session.createQuery("delete Order_products where order_id = :toDelete");
		thisQuery.setParameter("toDelete", id);
		thisQuery.executeUpdate();
	}
	
	

}
