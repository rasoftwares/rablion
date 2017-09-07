package com.ra.test.util;

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
			User user = new User();
			user.setId(1L);
			user.setLoginid("Demo");
			user.setUsername("Demo");
			user.setUsertype("CUSTOMER");
			user.setEmail("demo@gmail.com");
			user.setPassword("123456");
			entity = user;
		}
		return entity;
	}
	
	public static void main(String[] args) {
		System.out.println("A-------");

	}

}
