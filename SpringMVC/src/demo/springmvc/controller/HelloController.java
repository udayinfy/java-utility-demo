package demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * URL : http://localhost:8080/SpringMVC/welcome
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
		model.addAttribute("message", "Spring 3 MVC Hello World");

		return "hello";

	}

}