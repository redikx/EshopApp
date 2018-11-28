package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO {

	public List<Order> getAllOrder();
	
	public Order getOrder(int id);
	
	public void saveOrder(Order order);
	
	public void deleteOrder(int id);
	
}
