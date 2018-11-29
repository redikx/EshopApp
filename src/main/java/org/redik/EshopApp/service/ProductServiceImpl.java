package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.dao.ProductDAO;
import org.redik.EshopApp.entity.Product;
import org.redik.EshopApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}



}
