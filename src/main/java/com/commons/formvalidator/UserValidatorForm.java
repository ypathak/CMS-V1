package com.commons.formvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.commons.entity.User;
import com.commons.service.UserService;
import com.commons.utils.ApplicationConstants;

@Component
public class UserValidatorForm implements Validator{

	@Autowired
	UserService userservice;
	
	private Pattern pattern;  
	private Matcher matcher;  


	
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required");		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "repassword.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "birthdate.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aniversarydate", "aniversarydate.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeadd", "homeadd.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "offadd", "offadd.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pancardnum", "pancardnum.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aadharnum", "aadharnum.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homezipcode", "zipcode.required");	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officezipcode", "zipcode.required");	


			/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gstin", "gstin.required");*/

			User usr = (User) obj;

			if(!errors.hasFieldErrors("firstname")){
				if(!usr.getFirstname().matches(ApplicationConstants.ONLYALPABET)){
					errors.rejectValue("firstname", "onlyalphabet");
				}
				if(usr.getFirstname().length() < 3 || usr.getFirstname().length() > 50){
					errors.rejectValue("firstname", "Firstname.size");
				}
				
			}
			if(!errors.hasFieldErrors("lastname")){
				if(!usr.getLastname().matches(ApplicationConstants.ONLYALPABET)){
					errors.rejectValue("lastname", "onlyalphabet");
				}
				else if(usr.getLastname().length() < 3 || usr.getLastname().length() > 50){
					errors.rejectValue("lastname", "lastname.size");
				}
			}	
			if (!errors.hasFieldErrors("username") && usr.getUsername().length() < 3 || usr.getUsername().length() > 50) {
				errors.rejectValue("username", "Username.size");
			}
			if (userservice.findByUserName(usr.getUsername()) != null) {
				errors.rejectValue("username", "Duplicate.username");
			}
			if (!(usr.getEmail() != null && usr.getEmail().isEmpty())) {  
				pattern = Pattern.compile(ApplicationConstants.EMAIL_PATTERN);  
				matcher = pattern.matcher(usr.getEmail());  
				if (!matcher.matches()) {  
					errors.rejectValue("email", "email.valid");  
				}  
			}  
			if (!errors.hasFieldErrors("email") && userservice.findByUserName(usr.getEmail()) != null) {
				errors.rejectValue("email", "Duplicate.email");
			}
			
			if (!errors.hasFieldErrors("password") && usr.getPassword().length() < 6 || usr.getPassword().length() > 32) {
				errors.rejectValue("password", "Password.size");
			}

			if (!errors.hasFieldErrors("passwordConfirm") &&!usr.getPasswordConfirm().equals(usr.getPassword())) {
				errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
			}
			if(!(usr.getHomezipcode() != null && usr.getHomezipcode().isEmpty())){
				pattern = Pattern.compile(ApplicationConstants.Zip_Code_pattern);  
				matcher = pattern.matcher(usr.getHomezipcode());  
				if (!matcher.matches()) {  
					errors.rejectValue("homezipcode", "zipcode.size");  
				}  
			}
			if(!(usr.getOfficezipcode() != null && usr.getOfficezipcode().isEmpty())){
				pattern = Pattern.compile(ApplicationConstants.Zip_Code_pattern);  
				matcher = pattern.matcher(usr.getOfficezipcode());  
				if (!matcher.matches()) {  
					errors.rejectValue("officezipcode", "zipcode.size");  
				}  
			}
			
			if(!(usr.getPancardnum() != null && usr.getPancardnum().isEmpty())){
				pattern = Pattern.compile(ApplicationConstants.Pan_number_Patter);  
				matcher = pattern.matcher(usr.getPancardnum());  
				if (!matcher.matches()) {  
					errors.rejectValue("pancardnum", "pannumber.validation");  
				}  
			}
			if(!(usr.getAadharnum() != null && usr.getAadharnum().isEmpty())){
				pattern = Pattern.compile(ApplicationConstants.Adhar_number_patter);  
				matcher = pattern.matcher(usr.getAadharnum());  
				if (!matcher.matches()) {  
					errors.rejectValue("aadharnum", "adharnumber.validation");  
				}  
			}
			if(!(usr.getGstin() != null && usr.getGstin().isEmpty())){
				pattern = Pattern.compile(ApplicationConstants.Gstin_number_pattern);  
				matcher = pattern.matcher(usr.getGstin());  
				if (!matcher.matches()) {  
					errors.rejectValue("gstin", "gstin.validation");  
				}  
			}
			
			
		}catch(Exception e){
			System.out.println(e);	
		}
	}

}
