package com.commons.formvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.commons.entity.User;
import com.commons.utils.ApplicationConstants;

public class UserValidatorForm implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "birthdate.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aniversarydate", "aniversarydate.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeadd", "homeadd.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "offadd", "offadd.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pancardnum", "pancardnum.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aadharnum", "aadharnum.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gstin", "gstin.required");
		
		User usr = (User) obj;
		if(usr.getFirstname().matches(ApplicationConstants.ONLYALPABET)){
			errors.rejectValue("firstname", "onlyalphabet");
		}
	}

}
