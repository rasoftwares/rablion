package com.ra.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ra.domain.Expense;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExpenseControllerIntegrationTests extends BaseControllerIntegrationTests {
	
	Class cls = Expense.class;
	@Test
	public void create() {
		Expense response = (Expense) create(entity, POST, cls);
		Expense response_2 = (Expense) create(entity, POST, cls);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Expense[].class); 
    	
    	Expense[] expense = (Expense[])response.getBody();
    	
    	if(expense != null) {
    		Assert.assertEquals("Total expenses Found ", 1, expense.length);
    		Assert.assertNotNull(expense);
    		Assertions.assertThat(expense.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(expense).isNull();
    	}
    }
    
    @Test
   	public void delete() {
   		delete(entity, DELETE, cls);
   	}
       
    
	@Before
	public void setup() {
		entity = "expense";
		initialize();
	}
}