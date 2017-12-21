package com.commons.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commons.service.UserService;
import com.commons.utils.ApplicationConstants;

@Controller
@RequestMapping(value = "e")
@PreAuthorize(value = "EMPLOYEE")
public class EmployeeController implements ApplicationConstants{
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashboard() {
		return "e";
	}
}
