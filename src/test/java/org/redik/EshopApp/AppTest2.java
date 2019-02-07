package org.redik.EshopApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.EshopApp.config.AppConfig;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.redik.EshopApp.service.CustomerCardService;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.redik.EshopApp.service.ProductService;
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



class AppTest2 {

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
	
	@Test
	@Transactional
	public void createNewCustomer2() {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = new Customer("AAA","BBB","yzowany@gmail.com");
		System.out.println("Customer : " + customer.toString());
		session.persist(customer);
		customerService.saveCustomerWithCard2(customer);
		//card.setCustomer(customer);
		//Session session = sessionFactory.getCurrentSession();
		//customerService.saveCustomerWithCard(customer);
		//session.persist(customer);
		//session.persist(card);
	}
	
	@Test
	@Transactional
	public void updateCustomer() {
	Customer customer = customerService.getCustomer(11);
	customer.setEmail("nwy@gmail.com");
	customerService.saveCustomerWithCard(customer);
	}
	
}
