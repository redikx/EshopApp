package org.redik.EshopApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	@GetMapping("/")
	public String loginPage() {
		return "index";
	}
}
