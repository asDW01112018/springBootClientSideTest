package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	/**
	 * This returns Hello World string
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String helloWithParams(@RequestParam(value = "username", defaultValue = "World")String name) {
		System.out.println("Request recived"+name);
		return "Hello " + name;
	}
}
