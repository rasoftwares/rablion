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

import com.ra.domain.Payment;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PaymentControllerIntegrationTests extends BaseControllerIntegrationTests{
	@Test
	public void create() {
		Payment response = (Payment) create(entity, POST, Payment.class);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Payment[].class); 
    	
    	Payment[] payment = (Payment[])response.getBody();
    	
    	if(payment != null) {
    		Assert.assertEquals("Total payment Found ", 1, payment.length);
    		Assert.assertNotNull(payment);
    		Assertions.assertThat(payment.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(payment).isNull();
    	}
    }
    
	@Before
	public void setup() {
		entity = "payment";
		initialize();
	}
}