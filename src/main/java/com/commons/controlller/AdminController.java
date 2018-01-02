package com.commons.controlller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.service.UserService;
import com.commons.utils.ApplicationConstants;

@Controller
@RequestMapping(value = "a")
@PreAuthorize(value = "ADMIN")
public class AdminController implements ApplicationConstants {
	@Autowired
	UserService userService;



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashboard() {

		return "a";
	}

	@RequestMapping(value = "/rurl", method = RequestMethod.POST)
	public String submitemp(@Valid @ModelAttribute("Empdata") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "userregi";
		}
		try {
			List<Role> roles = userService.fetchrole("EMPLOYEE");
			user.setRoles(new HashSet<>(roles));

			userService.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "a";

	}

	@RequestMapping(value = "/regi", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("Empdata", new User());
		return "userregi";
	}

	@RequestMapping(value = "/clnt", method = RequestMethod.GET)
	public String regiclient(Model model,HttpSession session) {

		try{
			User  user=(User)session.getAttribute("user");
			
			List<Client> clients =userService.clientlist(user.getId());
			model.addAttribute("clientdata", new Client());
			model.addAttribute("clientlist", clients);
		}catch(Exception e){
			System.out.println(e);
		}

		return "clnt";
	}
	@RequestMapping(value="/clntregister", method=RequestMethod.POST )
	public @ResponseBody List<Client> addclient(@ModelAttribute("clientdata")Client client,HttpSession session){
		List<Client> clients=null;
		try{
			User  user=(User)session.getAttribute("user");
			client.setUser(user);
			userService.saveclient(client);
			clients =userService.clientlist(user.getId());
		}catch(Exception exception)
		{
			System.out.println(exception);
		}
		return clients;
	}





}
