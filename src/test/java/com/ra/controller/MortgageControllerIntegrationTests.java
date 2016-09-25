package com.ra.controller;

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
import com.ra.domain.Loan;
import com.ra.util.RestClient;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {AppConfig.class})
//@WebIntegrationTest("server.port:9000")
//public class MortgageControllerIntegrationTests {

    //RestTemplate restTemplate = new TestRestTemplate();
    //String url = "http://localhost:9095";
    
   /* Loan e1 = new Loan(1L,"User1",new Date(System.currentTimeMillis()),1234.56,"Food");
    Loan e2 = new Loan(2L,"User2",new Date(System.currentTimeMillis()),789.12,"Travel");*/

    
//   @Test
  // public void find(){
    	
    /*	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("robin", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Loan[]> response = client.template().exchange(client.apiUrl("loan"), HttpMethod.GET, request, Loan[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Loan[] loan = response.getBody();
    	if(loan != null) {
    		System.out.println("Total Loan Found " + loan.length);
    	}
    	for(int i=0;i<loan.length;i++) {
        	Assertions.assertThat(loan[i]).isNotNull();    
        }
    	
    }
    }*/
    
 /*   @Test
    public void create(){
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("raja", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Loan[]> response = client.template().exchange(client.apiUrl("loan"), HttpMethod.POST, request, Loan[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Loan[] Loan = response.getBody();
    	if(Loan != null) {
    	System.out.println("Total Loans Found " + Loan.length);
    	}
    	for(int i=0;i<Loan.length;i++) {
        	Assertions.assertThat(Loan[i]).isNotNull();    
        }
    
    	
    }
    
    @Test
    public void delete(){
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("raja", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Loan[]> response = client.template().exchange(client.apiUrl("Loan"), HttpMethod.DELETE, request, Loan[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Loan[] loan = response.getBody();
    	if(loan != null) {
    		System.out.println("Total Loans Found " + loan.length);
    	}
    	for(int i=0;i<loan.length;i++) {
        	Assertions.assertThat(loan[i]).isNotNull();    
        }
    
    }
}
*/




