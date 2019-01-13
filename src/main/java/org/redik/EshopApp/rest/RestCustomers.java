package org.redik.EshopApp.rest;

import java.util.ArrayList;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
		ArrayList<Order> listOrders = (ArrayList<Order>) orderService.getAllOrderOfCustomer(customerId);
		//String lo = "Number of orders : " + listOrders.size();
		//String lo = new Gson().toJson(listOrders); 
		ArrayList<String> al = new ArrayList<>();
		//al.add(lo);
		for (Order orders: listOrders) {
			al.add(orders.toString());
		}
		
		String json =new Gson().toJson(al);
		return json;
		}
	
	}
	

