package com.commons.controlller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.service.UserService;
import com.commons.utils.ApplicationConstants;

@Controller
@RequestMapping(value = "s")

public class SuperAdminController implements ApplicationConstants{
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashboard(Model model) {
		model.addAttribute("admindata", new User());
		return "sa";
	}
	@RequestMapping(value="/rurl",method=RequestMethod.POST)
	public String adminregister(@Valid @ModelAttribute("admindata") User user,BindingResult bindingResult,Model model){
		     
		
		if(bindingResult.hasErrors())
		{
			return "sa";
		}
		try {
			List<Role> roles=userService.fetchrole("ADMIN");
				user.setRoles(new HashSet<>(roles));
				userService.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		        
		return "sa";
	}
}
