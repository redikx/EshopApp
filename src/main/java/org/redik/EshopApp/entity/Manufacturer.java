package org.redik.EshopApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="manufacturer_id")
private int manId;

@Column(name="manufacturer_name")
private String manName;

@Column(name="country")
private String manCountry;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="manufacturer_id", referencedColumnName="manufacturer_id")
private List<Product> products;

public Manufacturer() {}

public Manufacturer(String manName, String manCountry) {
	super();
	this.manName = manName;
	this.manCountry = manCountry;
}



public int getManId() {
	return manId;
}

public void setManId(int manId) {
	this.manId = manId;
}

public String getManName() {
	return manName;
}

public void setManName(String manName) {
	this.manName = manName;
}

public String getManCountry() {
	return manCountry;
}

public void setManCountry(String manCountry) {
	this.manCountry = manCountry;
}

@Override
public String toString() {
	return "Manufacturer [manId=" + manId + ", manName=" + manName + ", manCountry=" + manCountry + "]";
}




}
