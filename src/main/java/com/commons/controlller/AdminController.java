package com.commons.controlller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.formvalidator.UserValidatorForm;
import com.commons.master.entity.Countries;
import com.commons.master.entity.States;
import com.commons.service.MasterDbService;
import com.commons.service.UserService;
import com.commons.springsec.AppUserDetailsService;
import com.commons.utils.ApplicationConstants;

@Controller
@RequestMapping("/a")
@PreAuthorize(value = "ADMIN")
public class AdminController implements ApplicationConstants {
	@Autowired
	UserService userService;

	@Autowired
	MasterDbService masterDbService;
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserValidatorForm userValidatorForm;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		   binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
		binder.addValidators(userValidatorForm);
	}
	
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
			e.printStackTrace();
		}
		return "a";
	}

	@RequestMapping(value = "/r/e", method = RequestMethod.GET)
	public String register(Model model, @RequestParam(required = false, name="homecountryid") Integer homecountryid, 
			@RequestParam(required = false, name="homestateid") Integer homestateid,
			@RequestParam(required = false, name="officecountryid") Integer offcountryid, 
			@RequestParam(required = false, name="officestateid") Integer offstateid) throws Exception{
		model.addAttribute("Empdata", new User());
	

		//home address - country state and city
		List<Countries> homecountriesList = masterDbService.fetchCountries();
		model.addAttribute("homecountries", homecountriesList);
		List<States> homestatesList = masterDbService.fetchStates( null == homecountryid ? homecountriesList.get(0).getId() : homecountryid);
		model.addAttribute("homestates", homestatesList);
		model.addAttribute("homecities", masterDbService.fetchCitiesByCountryAndState(null == homecountryid ? homecountriesList.get(0).getId() : homecountryid, null == homestateid ? homestatesList.get(0).getId() : homestateid));

		//office address - country state and city
		List<Countries> offcountriesList = masterDbService.fetchCountries();
		model.addAttribute("offcountries", offcountriesList);
		List<States> offstatesList = masterDbService.fetchStates( null == offcountryid ? offcountriesList.get(0).getId() : offcountryid);
		model.addAttribute("offstates", offstatesList);
		model.addAttribute("offcities", masterDbService.fetchCitiesByCountryAndState(null == offcountryid ? offcountriesList.get(0).getId() : offcountryid, null == offstateid ? offstatesList.get(0).getId() : offstateid));

		return "admin/userregister";
	}
	@RequestMapping(value="/r", method = RequestMethod.POST)
	public String adminregister(@ModelAttribute("Empdata") @Validated User user,
			BindingResult bindingResult,Model model) throws Exception{
		if (bindingResult.hasErrors()) {
			model.addAttribute("Empdata", user);

			//home address - country state and city
			List<Countries> homecountriesList = masterDbService.fetchCountries();
			model.addAttribute("homecountries", homecountriesList);
			List<States> homestatesList = masterDbService.fetchStates(user.getHomecountryid());
			model.addAttribute("homestates", homestatesList);
			model.addAttribute("homecities", masterDbService.fetchCitiesByCountryAndState(user.getHomecountryid() , user.getHomestateid()));

			//office address - country state and city
			List<Countries> offcountriesList = masterDbService.fetchCountries();
			model.addAttribute("offcountries", offcountriesList);
			List<States> offstatesList = masterDbService.fetchStates(user.getOfficecountryid());
			model.addAttribute("offstates", offstatesList);
			model.addAttribute("offcities", masterDbService.fetchCitiesByCountryAndState(user.getOfficecountryid(), user.getOfficestateid()));

			return "admin/userregister";
		}
		UserDetails currentLoginUser = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setCreatedBy(appUserDetailsService.loadUserByUsername(currentLoginUser.getUsername()).getUser().getId());
		user.setCreatedDate(new Date());
		List<Role> roles=userService.fetchrole("EMPLOYEE");
		user.setRoles(new HashSet<>(roles));
		userService.save(user);
		return "redirect:/a/r/e";
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
	public @ResponseBody String addclient(@ModelAttribute("clientdata")Client client){
		try{
			userService.saveclient(client);
		}catch(Exception exception){
			System.out.println(exception);
		}
		return "ok";
	}
}
