package org.redik.EshopApp;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.EshopApp.config.AppConfig;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.redik.EshopApp.service.CustomerCardService;
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
	
	@Test
	//@Rollback(value=false)
	public void CreateNewCustomer() {
		CustomerCard newCustomerCard = new CustomerCard("CUSTOM20");
		Customer newCustomer = new Customer("John","Bregovitch","brego@gmail.com");
		newCustomer.setCustomerCard(newCustomerCard);
	logger.info(newCustomer.toString());	
		customerCardService.saveCustomerWithCard(newCustomer, newCustomerCard);
	}
		
	

}
