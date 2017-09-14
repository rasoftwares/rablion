package com.ra.util;

import com.ra.domain.Catalog;
import com.ra.domain.Currency;
import com.ra.domain.Customer;
import com.ra.domain.Discount;
import com.ra.domain.Expense;
import com.ra.domain.Inventory;
import com.ra.domain.Payment;
import com.ra.domain.User;

public class GlobalConstants {

	/*
	 * Constants used for url mapping
	 */
	public static final String REST_BASE_URL = "/rest";
	
	//public static final String REST_ERR_URL = "/error";
	
	//public static final String REST_HELLO_URL = "/hello";
	
	//public static final String REST_LOGOUT_URL = "/logout";
	
	//public static final String LOGIN_PAGE = "/login";
	
	
	public static final String FILE_SEPERATOR = "/";
	public static final String URL_SEPERATOR = "/";
	public static final String URL_RESOURCE_SEPERATOR = "?";
	public static final String URL_PARAM_SEPERATOR = "&";
	
	/*
	 * This clsArray is used for testing the domain entities from one location. The test suite will fetch this clsArray variable and execute basic 
	 * CURD methods on these entities
	 * Incase of any new 
	 * 
	 * TODO : When a new new entity is defined then the same should be declared here. 
	 * 
	 */
	public static final Class[] clsArray = { User.class, Catalog.class, Inventory.class, Expense.class, Payment.class, Discount.class,
			Currency.class, Customer.class };
	
}
