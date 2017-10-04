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

import com.ra.domain.Customer;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerIntegrationTests extends BaseControllerIntegrationTests{
	Class cls = Customer.class;
	
	@Test
	public void create() {
		Customer response = (Customer) create(entity, POST, cls);
		Customer response_2 = (Customer) create(entity, POST, cls);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Customer[].class); 
    	
    	Customer[] customer = (Customer[])response.getBody();
    	
    	if(customer != null) {
    		Assert.assertEquals("Total customer Found ", 1, customer.length);
    		Assert.assertNotNull(customer);
    		Assertions.assertThat(customer.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(customer).isNull();
    	}
    }
    
    @Test
	public void delete() {
		delete(entity, DELETE, cls);
	}
    
	@Before
	public void setup() {
		entity = "customer";
		initialize();
	}
}