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

import com.ra.domain.Currency;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CurrencyControllerIntegrationTests extends BaseControllerIntegrationTests{
	@Test
	public void create() {
		Currency response = (Currency) create(entity, POST, Currency.class);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Currency[].class); 
    	
    	Currency[] currency = (Currency[])response.getBody();
    	
    	if(currency != null) {
    		Assert.assertEquals("Total currency Found ", 1, currency.length);
    		Assert.assertNotNull(currency);
    		Assertions.assertThat(currency.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(currency).isNull();
    	}
    }
    
	@Before
	public void setup() {
		entity = "currency";
		initialize();
	}
}