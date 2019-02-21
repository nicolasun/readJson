package com.utrack.data.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
//	@Autowired
//	private DBTransation dbTransation;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home() {
		
		log.info("start of it");
//		dbTransation.storeJsonToDB();
		log.info("end of it");
		
		log.info("Welcome home! The client locale is {}.");
		
		return "home";
	}
	
}
