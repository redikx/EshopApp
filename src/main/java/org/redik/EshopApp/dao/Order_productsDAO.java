package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Order_products;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_productsDAO {

	public List<Order_products> getAllOrder_products();
	
	public Order_products getOrder_products(int id);
	
	public void saveOrder_products(Order_products order_products);
	
	public void deleteOrder_products(int id);
	
}
