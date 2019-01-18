package org.redik.EshopApp.Controllers;

import java.util.List;

import org.redik.EshopApp.entity.Customer;
import org.redik.EshopApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reportsControllers {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/allCustomers") 
	public String RepAllCustomers( Model model) {
		List<Customer> lcust = customerService.getAllCustomer();
		model.addAttribute("listCustomers", lcust);
		return "RepAllCustomers";
	}
}
