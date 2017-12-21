package com.commons.controlller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commons.entity.AbstractEntity;
import com.commons.entity.User;
import com.commons.service.UserService;
import com.commons.utils.ApplicationConstants;

@Controller
public class WelcomeController implements AuthenticationSuccessHandler,ApplicationConstants{

	@Autowired
	UserService userService;
	
	Authentication auth;
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		String data=auth.getAuthorities().toString();
		
		if (auth != null && (!(data.toString().equals("[ROLE_ANONYMOUS]")))) {
			try {
				onAuthenticationSuccess(request, response, auth);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		  auth= SecurityContextHolder.getContext().getAuthentication();
		   new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/login";
	}
	
	@RequestMapping(name = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userdata", new User());
		return "registretion";
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Set<String> roles=AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		if(roles.contains(EMPLOYEE)){
			response.sendRedirect("e/");
		}else if(roles.contains(ADMIN)){
			response.sendRedirect("a/");
		}else if(roles.contains(SUPER_ADMIN)){
			response.sendRedirect("s/");
		}
		
	}
}
