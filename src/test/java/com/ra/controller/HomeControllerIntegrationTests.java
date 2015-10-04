package com.ra.controller;

import java.sql.Date;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ra.config.AppConfig;
import com.ra.domain.Expense;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@WebIntegrationTest("server.port:9000")
public class HomeControllerIntegrationTests {

    RestTemplate restTemplate = new TestRestTemplate();
    String url = "http://localhost:9000";
    Expense e = new Expense(1L,"User1",new Date(System.currentTimeMillis()),1234.56,"Food");

    
    @Test
    public void add_Expense_ToDB(){
		 	
	        //ResponseEntity<Expense> responseEntity = restTemplate.postForEntity(url + "/rest/expense", MockHttpServletRequest.DEFAULT_PROTOCOL, Expense.class);
		 	Expense expense = restTemplate.postForObject(url + "/rest/expense", e, Expense.class);
		 	expense = restTemplate.postForObject(url + "/rest/expense", e, Expense.class);
	        //final Expense expense = responseEntity.getBody();
	        Assertions.assertThat(expense).isNotNull();
	        Assertions.assertThat(expense.getUser()).isNotNull().isEqualTo("User1");
	    }
    
    @Test
    public void read_Expense_ToDb() {
	 	ResponseEntity<Expense[]> response = restTemplate.getForEntity(url + "/rest/expense", Expense[].class);
	 	final Expense[] expense = response.getBody();
        for(int i=0;i<expense.length;i++){
        	Assertions.assertThat(expense[i]).isNotNull();
        	Assertions.assertThat(expense[i].toString()).isNotNull().isEqualTo(e.toString());    }
        }

}
