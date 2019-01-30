package org.redik.EshopApp.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.boot.jaxb.hbm.spi.ResultSetMappingBindingDefinition;
import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.entity.CustomerCard;
import org.redik.EshopApp.entity.Order;
import org.redik.EshopApp.entity.Order_products;
import org.redik.EshopApp.service.CustomerCardService;
import org.redik.EshopApp.service.CustomerService;
import org.redik.EshopApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/formForUpdateOrder")
	public String updateOrder(@RequestParam("orderId") int id, Model model) {
		Order order = orderService.getOrder(id);
		List<Order_products> orderProducts = order.getOrderProducts();
		model.addAttribute("o", order);
		model.addAttribute("op",orderProducts);
		System.out.println(orderProducts.toString());
		return "editOrderForm";
	}
	
	@RequestMapping(value="/formForSaveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model) {
	customerService.saveCustomerWithCard(customer);
	List<Customer> lcust = customerService.getAllCustomer();
	model.addAttribute("listCustomers", lcust);
	return "RepAllCustomers";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	@RequestMapping(value="/formForSaveOrder", method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order,BindingResult result,Model model) {
	System.out.println("SAVING");
	//orderService.saveOrder(order);
	//List<Customer> lcust = customerService.getAllCustomer();
	//model.addAttribute("listCustomers", lcust);
	return "RepAllCustomers";
	}
	
	@RequestMapping(value="/formForSaveOrderProducts", method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("orderProducts") Order_products op,Model model, BindingResult bindingResult) {
	System.out.println("SAVING PRODUCTS");
	
	//List<Customer> lcust = customerService.getAllCustomer();
	//model.addAttribute("listCustomers", lcust);
	return "RepAllCustomers";
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
