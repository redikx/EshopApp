package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Product;

public interface ProductService {

	public List<Product> getAllProduct();

	public Product getProduct(int id);

	public void saveProduct(Product customer);

	public void deleteProduct(int id);

	}
