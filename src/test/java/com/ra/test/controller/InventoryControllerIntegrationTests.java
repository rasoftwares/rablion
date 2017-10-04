package com.ra.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ra.domain.Inventory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InventoryControllerIntegrationTests extends BaseControllerIntegrationTests {
	
	Class cls = Inventory.class;
	@Test
	public void create() {
		Inventory response = (Inventory) create(entity, POST, cls);
		Inventory response_2 = (Inventory) create(entity, POST, cls);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Inventory[].class); 
    	
    	Inventory[] inventory = (Inventory[])response.getBody();
    	
    	if(inventory != null) {
    		Assert.assertEquals("Total inventorys Found ", 1, inventory.length);
    		Assert.assertNotNull(inventory);
    		Assertions.assertThat(inventory.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(inventory).isNull();
    	}
    }
    
    @Test
	public void delete() {
		delete(entity, DELETE, cls);
	}
	@Before
	public void setup() {
		entity = "inventory";
		initialize();
	}
}