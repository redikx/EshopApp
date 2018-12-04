package org.redik.EshopApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="order_products")
public class Order_products {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="product_id", foreignKey=@ForeignKey(name="FK_order_products_product"))
private Product product;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="order_id")
private Order order;

@Column(name="quantity")
private int quantity;

public Order_products() {
}


public Order_products(Product product, int quantity) {
	super();
	this.product = product;
	this.quantity = quantity;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Order_products [id=" + id + ", product=" + product + ", order=" + order + ", quantity=" + quantity + "]";
}



}
