package org.redik.EshopApp;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.EshopApp.config.AppConfig;
import org.redik.EshopApp.service.CustomerCardService;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.redik.EshopApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


public class AppTest2 {

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
	public void updateCustomer() {
		String encoded=new BCryptPasswordEncoder().encode("111");
		System.out.println(encoded);
		}
	
}
