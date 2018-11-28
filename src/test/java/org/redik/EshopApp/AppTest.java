package org.redik.EshopApp;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.EshopApp.config.AppConfig;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.redik.EshopApp.entity.Manufacturer;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.entity.Product;
import org.redik.EshopApp.service.CustomerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("org.redik.EshopApp")
@WebAppConfiguration
@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@Transactional

public class AppTest

{
	
	@Autowired
	CustomerCardService customerCardService;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/*@Test
	public void SaveCardNumberTest() {
	CustomerCard nn = new CustomerCard(199, "AAA");
	customerCardService.saveCustomerCard(nn);
	System.out.println(nn.toString());
	}
	
	@Test
	public void ReadCardNumberTest() {
		CustomerCard customerCard = customerCardService.getCustomerCard(4);
		System.out.println(customerCard.toString());
	}*/
	
	/*@Test
	//@Rollback(value=false)
	public void CreateNewCustomer() {
		CustomerCard newCustomerCard = new CustomerCard("CUSTOM20");
		Customer newCustomer = new Customer("John","Bregovitch","brego@gmail.com");
		newCustomer.setCustomerCard(newCustomerCard);
	logger.info(newCustomer.toString());	
		customerCardService.saveCustomerWithCard(newCustomer, newCustomerCard);
	}*/
	
	@Test
	public void TestManufacturerProduct() {
		Manufacturer manufacturer1 = new Manufacturer("Joytech", "China");
		Product product1 = new Product("E-papieros","do palenia nie w piecu");
		product1.setManufacturer(manufacturer1);
		logger.info(product1.toString());

		Product product2 = new Product("Akumulator","wysokopradowy");
		product2.setManufacturer(manufacturer1);
		logger.info(product2.toString());

		
		CustomerCard newCustomerCard = new CustomerCard("CUSTOM20");
		Customer newCustomer = new Customer("John","Bregovitch","brego@gmail.com");
		newCustomer.setCustomerCard(newCustomerCard);
		customerCardService.saveCustomerWithCard(newCustomer, newCustomerCard);
		logger.info(newCustomer.toString());
		
		Order order = new Order();
		order.setCustomerId(newCustomer.getId());
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   Date date = new Date();  
		order.setOrderDate(date);
		order.setOrderNotes("zamowienie z nienacka");
		logger.info(order.toString());
		
		Order_products op = new Order_products();
		op.setOrder(order);
		op.setProduct(product1);
		op.setQuantity(2);

		Order_products op2 = new Order_products();
		op2.setOrder(order);
		op2.setProduct(product2);
		op2.setQuantity(8);
		
		logger.info(op.toString());
		logger.info(op2.toString());
	
	}
	
	
	

}
