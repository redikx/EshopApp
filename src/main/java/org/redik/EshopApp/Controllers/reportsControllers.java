package org.redik.EshopApp.Controllers;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.service.CustomerCardService;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class reportsControllers {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerCardService cardService;
	
	
	@GetMapping("/allCustomers") 
	public String RepAllCustomers( Model model) {
		List<Customer> lcust = customerService.getAllCustomer();
		model.addAttribute("listCustomers", lcust);
		return "RepAllCustomers";
	}
	
	@GetMapping("/allOrders") 
	public String RepAllOrders( Model model) {
		return "RepAllOrders";
	}
	
	
	@RequestMapping("/getCustomerOrders")
	public String getCustomerOrders(@RequestParam("customerId") int id, Model model) {
		List<Order> orders = orderService.getAllOrderOfCustomer(id);
		model.addAttribute("ordersOfCustomer", orders);
		return "list-customer-order";
	}
	
	
	@RequestMapping("/formForUpdateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		CustomerCard cCard = customer.getCustomerCard();
		model.addAttribute("customerCard", cCard);
		model.addAttribute("customer",customer);
		return "editCustomerForm";
	}
	
	@RequestMapping(value="/formForSaveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model) {
	customerService.saveCustomerWithCard(customer);
	List<Customer> lcust = customerService.getAllCustomer();
	model.addAttribute("listCustomers", lcust);
	return "RepAllCustomers";
	}
	
	@RequestMapping(value="/formForUpdateOrder")
	public String updateOrder(@RequestParam("orderId") int id, Model model) {
		Order order = orderService.getOrder(id);
		List<Order_products> orderProducts = order.getOrderProducts();
		System.out.println(order.toString());
		model.addAttribute("order", order);
		model.addAttribute("orderProducts",orderProducts);
		return "editOrderForm";
	}
	
	@RequestMapping(value="/formForSaveOrder")
	public String saveOrder(@ModelAttribute("order") Order order,Model model) {
	System.out.println("SAVING");
	//orderService.saveOrder(order);
	//List<Customer> lcust = customerService.getAllCustomer();
	//model.addAttribute("listCustomers", lcust);
	return "customer-details-form";
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
