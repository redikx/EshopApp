package org.redik.EshopApp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="order_id")
private int orderId;

@Column(name="order_date")
private Date orderDate;

@Column(name="order_notes")
private String orderNotes;

@Column(name="customer_id")
private int customerId;

@OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<Order_products> orderProducts = new ArrayList<>();
//private Set<Order_products> orderProducts = new HashSet<Order_products>();

public Order() {}

public Order(Date orderDate) {
	super();
	this.orderDate = orderDate;
}

public void addProduct(Order_products op) {
	orderProducts.add(op);
	op.setOrder(this);
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public String getOrderNotes() {
	return orderNotes;
}

public void setOrderNotes(String orderNotes) {
	this.orderNotes = orderNotes;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public List<Order_products> getOrderProducts() {
	return orderProducts;
}


public void setOrderProducts(List<Order_products> orderProducts) {
	this.orderProducts = orderProducts;
	System.out.println(orderProducts.toString());;
	
}

@Override
public String toString() {
	return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderNotes=" + orderNotes + ", customerId="
			+ customerId + ", orderProducts=" + orderProducts.size() + "] \n";
}


}





