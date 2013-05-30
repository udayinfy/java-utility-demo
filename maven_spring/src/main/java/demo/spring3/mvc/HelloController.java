package demo.spring3.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(ModelMap modelMap){
		
		modelMap.addAttribute("message", "Hello World!");
		
		return "hello";
	}

}
