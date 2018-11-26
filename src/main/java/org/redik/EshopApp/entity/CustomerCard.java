package org.redik.EshopApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer_card")
public class CustomerCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "card_number")
	private String card_number;

	public CustomerCard() {
	}

	public CustomerCard(int id, String cardNumber) {
		this.id = id;
		card_number = cardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return card_number;
	}

	public void setCardNumber(String cardNumber) {
		card_number = cardNumber;
	}

	@Override
	public String toString() {
		return "CustomerCard [id=" + id + ", CardNumber=" + card_number + "]";
	}

}
