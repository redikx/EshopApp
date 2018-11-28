package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO {

	public List<Product> getAllProduct();
	
	public Product getProduct(int id);
	
	public void saveProduct(Product product);
	
	public void deleteProduct(int id);
	
}
