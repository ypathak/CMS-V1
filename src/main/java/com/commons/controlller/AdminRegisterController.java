package com.commons.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("a")
public class AdminRegisterController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public void dashboard(){
		    
	}
	
}
