package org.redik.EshopApp;

import java.util.Date;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.EshopApp.config.AppConfig;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.entity.Product;
import org.redik.EshopApp.service.CustomerCardService;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.redik.EshopApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
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
	SessionFactory sessionFactory;
	
	@Autowired
	CustomerCardService customerCardService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
		
	
	@Test
	@Transactional
	//@Rollback(false)
	public void TestNewOrderCreation() {
	
		Session session = sessionFactory.getCurrentSession();
		
		Product product1 = productService.getProduct(6);
		Product product2 = productService.getProduct(13);
		Customer newCustomer = customerService.getCustomer(11);
		Date date = new Date(); 
		
		//Create Order with proper Date, Notes and CustomerId
		Order order = new Order(date);
		order.setOrderDate(date);
		order.setOrderNotes("zamowienie z nienacka");
		order.setCustomerId(newCustomer.getId());
		
		//Create Order_Products for Order
		Order_products op = new Order_products();
		op.setProduct(product1);
		op.setQuantity(99);
		
		Order_products op2 = new Order_products();
		op2.setProduct(product2);
		op2.setQuantity(2);
		
		//Make proper constraint
		order.addProduct(op);
		order.addProduct(op2);

		session.persist(order);
		session.persist(op);
		session.persist(op2);
		session.persist(order);
			}
	

}
