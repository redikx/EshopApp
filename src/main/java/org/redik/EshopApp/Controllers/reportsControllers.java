package org.redik.EshopApp.Controllers;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class reportsControllers {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/allCustomers") 
	public String RepAllCustomers( Model model) {
		List<Customer> lcust = customerService.getAllCustomer();
		model.addAttribute("listCustomers", lcust);
		return "RepAllCustomers";
	}
	
	@GetMapping("/formForUpdateCustomer")
	public String showformForUpdateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer theCustomer = customerService.getCustomer(id);
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/formForDisplayCustomerDetails")
	public String showformForDetailsCustomer(@RequestParam("customerId") int id, Model model) {
		Customer theCustomer = customerService.getCustomer(id);
		List<Order> listOrder = orderService.getAllOrderOfCustomer(theCustomer.getId());
		model.addAttribute("customer",theCustomer);
		model.addAttribute("listCustomerOrders", listOrder);
		return "customer-details-form";
	}
	

}
