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

import com.ra.domain.Discount;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DiscountControllerIntegrationTests extends BaseControllerIntegrationTests{
	@Test
	public void create() {
		Discount response = (Discount) create(entity, POST, Discount.class);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Discount[].class); 
    	
    	Discount[] discount = (Discount[])response.getBody();
    	
    	if(discount != null) {
    		Assert.assertEquals("Total discount Found ", 1, discount.length);
    		Assert.assertNotNull(discount);
    		Assertions.assertThat(discount.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(discount).isNull();
    	}
    }
    
	@Before
	public void setup() {
		entity = "discount";
		initialize();
	}
}