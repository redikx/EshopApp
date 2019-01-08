package org.redik.EshopApp.rest;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestCustomers {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public List<Customer> RestGetAllCustomers() {
		  return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}
	
}
