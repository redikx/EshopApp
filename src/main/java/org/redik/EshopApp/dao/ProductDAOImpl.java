package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProduct() {
	Session session = sessionFactory.getCurrentSession();
	TypedQuery<Product> thisQuery = session.createQuery("from Product order by product_id",Product.class);
	List<Product> products = thisQuery.getResultList();
	return products;
	
	}

	@Override
	public Product getProduct(int id) {
	Session session = sessionFactory.getCurrentSession();
	Product product = session.get(Product.class,id);
	return product;
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
	Session session = sessionFactory.getCurrentSession();
	Query theQuery = session.createQuery("delete from Product where product_id = :idToDelete");
	theQuery.setParameter("idToDelete", id);
	theQuery.executeUpdate();
	}


}
