package org.redik.EshopApp.rest;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/api")
public class RestCustomers {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/allCustomers")
	public List<Customer> RestGetAllCustomers() {
		  return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping("/getCustomerOrders")
	public String getCustomerOrder(@RequestParam("customerId") int customerId) {
		List<Order> listOrders = orderService.getAllOrderOfCustomer(customerId);
		String str1 = "";
		for (Order order : listOrders) {
			str1 = str1 + order.toString() + "\r\n";
		}
		return str1;
	}
	
}
