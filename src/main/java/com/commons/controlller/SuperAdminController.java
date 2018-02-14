package com.commons.controlller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/s")
public class SuperAdminController implements ApplicationConstants{
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	MasterDbService masterDbService;

	@Autowired
	private UserValidatorForm userValidatorForm;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidatorForm);
	}

	@RequestMapping(value = "/d", method = RequestMethod.GET)
	public String dashboard(Model model) {
		return "superadmin/dashboard";
	}

	@RequestMapping(value = "/a/r/p", method = RequestMethod.GET)
	public String userregister(Model model, @RequestParam(required = false, name="homecountryid") Integer homecountryid, 
			@RequestParam(required = false, name="homestateid") Integer homestateid,
			@RequestParam(required = false, name="officecountryid") Integer offcountryid, 
			@RequestParam(required = false, name="officestateid") Integer offstateid) throws Exception {
		model.addAttribute("admindata", new User());

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

		return "superadmin/adminregister";
	}

	@RequestMapping(value="/a/r", method = RequestMethod.POST)
	public String adminregister(@ModelAttribute("admindata") @Validated User user,
			BindingResult bindingResult,Model model) throws Exception{
		if (bindingResult.hasErrors()) {
			model.addAttribute("admindata", user);

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

			return "superadmin/adminregister";
		}
		UserDetails currentLoginUser = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setCreatedBy(appUserDetailsService.loadUserByUsername(currentLoginUser.getUsername()).getUser().getId());
		user.setCreatedDate(new Date());
		List<Role> roles=userService.fetchrole("ADMIN");
		user.setRoles(new HashSet<>(roles));
		userService.save(user);
		return "superadmin/adminregister";
	}
}
