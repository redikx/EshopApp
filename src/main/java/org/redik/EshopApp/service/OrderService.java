package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.entity.Product;

public interface OrderService {

	public List<Order> getAllOrder();

	public Order getOrder(int id);

	public void saveOrder(Order order);

	public void deleteOrder(int id);
	
	public void saverOrderProducts(Order order, Order_products oproducts );
	
	public void addProductToOrder(Order order, Order_products product);
	
	public void saveOrderProducts();

	public void deleteWholeOrder(int id);

	}
