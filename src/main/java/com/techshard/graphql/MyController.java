package com.techshard.graphql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veh")
public class MyController {
	
	{
		System.out.println("hellllllllll");
	}
	
	@RequestMapping("/le")
	public String show() {
		
		return "Bye Byeee";
	}


}
