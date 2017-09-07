package com.ra.test.util;

import java.sql.Date;

import com.ra.domain.Catalog;
import com.ra.domain.Currency;
import com.ra.domain.Customer;
import com.ra.domain.Discount;
import com.ra.domain.Expense;
import com.ra.domain.Inventory;
import com.ra.domain.Payment;
import com.ra.domain.User;

/*
 * 1. Create Domain Entities dynamically based on the class name
 * 2. Populate dummy data into the dynamic class from external data file 
 * 
 * 
*/

public class EntityFactory {
	
	//Create and return a domain entity for the requested class
	public static Object getDomainEntityforClass(Class obj) {
		Object entity = null;
		
		if(obj.equals(User.class)) {
			System.out.println("Returning ---> User Class");
			User user = new User();
			user.setId(1L);
			user.setLoginid("Demo");
			user.setUsername("Demo");
			user.setUsertype("CUSTOMER");
			user.setEmail("demo@gmail.com");
			user.setPassword("123456");
			entity = user;
		}
		else if(obj.equals(Catalog.class)) {
			System.out.println("Returning ---> Catalog Class");
			Catalog catalog = new Catalog();
			catalog.setId(1L);
			catalog.setModel("");
			catalog.setPrice(1D);
			catalog.setDiscount(1D);
			catalog.setImage("");
			entity = catalog;
		}
		else if(obj.equals(Inventory.class)) {
			System.out.println("Returning ---> Inventory Class");
			Inventory inventory=new Inventory();
			inventory.setId(1L);
			inventory.setName("Saree");
			inventory.setType("Cotton");
			inventory.setQuantity(47L);
			inventory.setAlertlimit(100L);
			inventory.setPrice(2000L);
			inventory.setDiscount(2000L);
			inventory.setImage("1.jpg");
			inventory.setCreatedby("");
			inventory.setCreatedtimestamp(new Date(System.currentTimeMillis()));
			inventory.setModifiedby("");
			inventory.setModifiedtimestamp(new Date(System.currentTimeMillis()));
			entity = inventory;
		}
		else if(obj.equals(Expense.class)) {
			System.out.println("Returning ---> Expense Class");
			Expense expense = new Expense();
			expense.setId(1L);
			expense.setAmount(1D);
			expense.setType("");
			expense.setUser("");
			expense.setCurrency("");
			expense.setDate(new Date(System.currentTimeMillis()));
			/*expense.setCreatedby("");
			expense.setCreatedtimestamp(new Date(System.currentTimeMillis()));
			expense.setModifiedby("");
			expense.setModifiedtimestamp(new Date(System.currentTimeMillis()));*/
			entity = expense;
		}
		else if(obj.equals(Payment.class)) {
			Payment payment = new Payment();
			payment.setId(1L);
			payment.setStatus("");
			payment.setTxnid("");
			payment.setUserid("");
			payment.setOrderid("");
			payment.setAmount(1L);
			payment.setCreatedby("");
			payment.setCreatedtimestamp(new Date(System.currentTimeMillis()));
			payment.setModifiedby("");
			payment.setModifiedtimestamp(new Date(System.currentTimeMillis()));
			payment.setDate(new Date(System.currentTimeMillis()));

			entity = payment;
		}
		else if(obj.equals(Discount.class)) {
			Discount discount = new Discount();
			discount.setId(1L);
			discount.setStartdate(new Date(System.currentTimeMillis()));
			discount.setEnddate(new Date(System.currentTimeMillis()));
			discount.setPercentage(1L);
			discount.setIsactive("");
			discount.setCreatedby("");
			discount.setCreatedtimestamp(new Date(System.currentTimeMillis()));
			discount.setModifiedby("");
			discount.setModifiedtimestamp(new Date(System.currentTimeMillis()));
			entity = discount;
		}
		else if(obj.equals(Currency.class)) {
			Currency currency = new Currency();
			currency.setId(1L);
			currency.setCurrency("");
			currency.setSourcevalue(1D);
			currency.setInrvalue(1D);
			entity = currency;
		}
		else if(obj.equals(Customer.class)) {
			Customer customer = new Customer();
			customer.setId(1L);
			customer.setCustomerid("");
			customer.setCompanyname("");
			customer.setTitle("");
			customer.setRegistrationno("");
			customer.setRegistrationyear(new Date(System.currentTimeMillis()));
			customer.setOwnername("");
			customer.setPhotograph("");
			customer.setShortdescription("");
			customer.setRegistredaddress("");
			customer.setOfficeaddress("");
			customer.setLandlineno(1D);
			customer.setMobileno(1D);
			customer.setEmailid("");
			customer.setWebsite("");
			customer.setAboutcompany("");
			entity = customer;
		}
		else{
			System.out.println("Returning ---> NULL Class");
		}
		
		
		return entity;
	}
	
	public static void main(String[] args) {
		System.out.println("A-------");

	}

}
