package com.ra.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ra.domain.User;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerIntegrationTests extends BaseControllerIntegrationTests{
	@Test
	public void create() {
		User response = (User) create(entity, POST, User.class);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, User[].class); 
    	
    	User[] user = (User[])response.getBody();
    	
    	if(user != null) {
    		Assert.assertEquals("Total user Found ", 1, user.length);
    		Assert.assertNotNull(user);
    		Assertions.assertThat(user.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(user).isNull();
    	}
    }
    
	@Before
	public void setup() {
		entity = "user";
		initialize();
	}
}