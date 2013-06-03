package demo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * URL : http://localhost:8080/SpringMVC/welcome
 * @author Administrator
 *
 */
@Controller
public class HelloController {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
		model.addAttribute("message", "Spring 3 MVC Hello World");

		return "hello";

	}
	
	@RequestMapping(value="/hello2", method = RequestMethod.GET)
	public @ResponseBody String printlWelcome2() throws Exception{
	
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println(request.getParameter("name"));
		
		return "this is a debug message.";
	}

}