package demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * URL : http://localhost:8080/SpringMVC/welcome
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(@RequestParam("msg") String msg, ModelMap model) {
		
		model.addAttribute("message", msg);

		return "hello";

	}

}