package demo.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {
	
	
	@RequestMapping(value = "/saveObjectJson", method = RequestMethod.GET)
	public @ResponseBody Shop save(@RequestBody Shop jsonString) {
		
		Shop shop = new Shop();
		shop.setName("AName");
		shop.setStaffName(new String[] { "arrOne", "arrTwo" });

		return shop;
	}

	@RequestMapping(value = "/getObjectJson", method = RequestMethod.GET)
	public @ResponseBody Shop getObjectJson() {

		Shop shop = new Shop();
		shop.setName("AName");
		shop.setStaffName(new String[] { "arrOne", "arrTwo" });

		return shop;
	}
	
	@RequestMapping(value = "/getCollectionJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getCollectionJson() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");

		return map;
	}

	class Shop {
		String name;
		String[] staffName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String[] getStaffName() {
			return staffName;
		}

		public void setStaffName(String[] staffName) {
			this.staffName = staffName;
		}

	}

}