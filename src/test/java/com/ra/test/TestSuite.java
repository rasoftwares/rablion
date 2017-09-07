package com.ra.test;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ra.test.controller.CatalogControllerIntegrationTests;
import com.ra.test.controller.UserControllerIntegrationTests;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { 
		   UserControllerIntegrationTests.class ,CatalogControllerIntegrationTests.class
		}, webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestSuite {
	
}
