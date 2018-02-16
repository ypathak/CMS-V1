package com.commons.utils;

public interface ApplicationConstants {
	
	String LOGGER_NAME = "CMS";
	boolean MAIL_ENABLED = true;
	boolean LOGGING_ENABLED = true;
	
	/*
	 * ROLE
	 */
	String EMPLOYEE ="EMPLOYEE";
	String SUPER_ADMIN ="SUPER_ADMIN";
	String ADMIN ="ADMIN";
	
	String ONLYALPABET = "[a-zA-Z]+";
	
	
	String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	String ID_PATTERN = "[0-9]+";  
	String MOBILE_PATTERN = "[0-9]{10}";  
	
	String Zip_Code_pattern="^[1-9][0-9]{5}$";
	
	String Pan_number_Patter = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
	
	String Adhar_number_patter="^[2-9]{1}[0-9]{11}$";
	
	String Gstin_number_pattern="/^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/";
	
}
