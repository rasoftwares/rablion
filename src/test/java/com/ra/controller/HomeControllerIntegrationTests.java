package com.ra.controller;

import java.sql.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ra.config.AppConfig;
import com.ra.domain.Expense;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {AppConfig.class})
//@WebIntegrationTest("server.port:9000")
public class HomeControllerIntegrationTests {

    RestTemplate restTemplate = new TestRestTemplate();
    String url = "http://localhost:9095";
    Expense e = new Expense(1L,"User1",new Date(System.currentTimeMillis()),"INR",1234.56,"Food");

    
    @Test
    public void read_Expense_ToDB(){
		 	
	        //ResponseEntity<Expense> responseEntity = restTemplate.postForEntity(url + "/rest/expense", MockHttpServletRequest.DEFAULT_PROTOCOL, Expense.class);
	    	/*String plainCreds = "robin:password";
	    	byte[] plainCredsBytes = plainCreds.getBytes();
	    	byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
	    	String base64Creds = new String(base64CredsBytes);
	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("Authorization", "Basic " + base64Creds);
	    	
	    	final HttpEntity<String> request = new HttpEntity<String>(headers);	
	    	
	    	final ResponseEntity<Expense[]> response = restTemplate.exchange(url + "/rest/expense", HttpMethod.GET, request, Expense[].class);
	    	final Expense[] expense = response.getBody();
	    	
	    	for(int i=0;i<expense.length;i++) {
	        	Assertions.assertThat(expense[i]).isNotNull();    
	        }*/
	    }
    
    @Test
    public void create_Expense_ToDB() {
    	/*
	 	ResponseEntity<Expense[]> response = restTemplate.getForEntity(url + "/rest/expense", Expense[].class);
	 	final Expense[] expense = response.getBody();
        for(int i=0;i<expense.length;i++){
        	Assertions.assertThat(expense[i]).isNotNull();
        	Assertions.assertThat(expense[i].toString()).isNotNull().isEqualTo(e.toString());    }
        */}

}
