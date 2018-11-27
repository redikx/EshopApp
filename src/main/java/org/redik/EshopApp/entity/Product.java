package org.redik.EshopApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="product_id")
private int productId;

@Column(name="product_name")
private String productName;

@Column(name="product_description")
private String productDescription;

@OneToOne( fetch = FetchType.EAGER )
@JoinColumn(name="manufacturer_id")
private Manufacturer manufacturer;

public Product() {}

public Product(String productName, String productDescription) {
	super();
	this.productName = productName;
	this.productDescription = productDescription;}

public Product(String productName, String productDescription, Manufacturer manufacturer) {
	super();
	this.productName = productName;
	this.productDescription = productDescription;
	this.manufacturer = manufacturer;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public Manufacturer getManufacturer() {
	return manufacturer;
}

public void setManufacturer(Manufacturer manufacturer) {
	this.manufacturer = manufacturer;
}

@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
			+ productDescription + ", manufacturer=" + manufacturer + "]";
}


}
