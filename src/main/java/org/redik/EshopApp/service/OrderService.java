package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Order;

public interface OrderService {

	public List<Order> getAllOrder();

	public Order getOrder(int id);

	public void saveOrder(Order order);

	public void deleteOrder(int id);

	}
