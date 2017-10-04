package com.ra.test.controller;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ra.domain.Catalog;
import com.ra.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CatalogControllerIntegrationTests extends BaseControllerIntegrationTests {
	Class cls = Catalog.class;
	
	@Test
	public void create() {
		Catalog response = (Catalog) create(entity, POST, cls);
		Catalog response_2 = (Catalog) create(entity, POST, cls);
		Assert.assertNotNull(response);
	}
	
    @Test
    public void find() {
    	
    	ResponseEntity<Object[]> response = find(entity, GET, Catalog[].class); 
    	
    	Catalog[] catalog = (Catalog[])response.getBody();
    	
    	if(catalog != null) {
    		Assert.assertEquals("Total catalogs Found ", 1, catalog.length);
    		Assert.assertNotNull(catalog);
    		Assertions.assertThat(catalog.length).isEqualTo(1);
    	}
    	else {
    		Assertions.assertThat(catalog).isNull();
    	}
    }
    
    @Test
	public void delete() {
		delete(entity, DELETE, cls);
	}
    
	@Before
	public void setup() {
		entity = "catalog";
		initialize();
	}
}