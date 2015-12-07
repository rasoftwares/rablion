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
import com.ra.domain.Currency;
import com.ra.util.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@WebIntegrationTest("server.port:9000")
public class CurrencyControllerIntegrationTests {

    RestTemplate restTemplate = new TestRestTemplate();
    //String url = "http://localhost:9095";
    
     
    @Test
    public void find(){
    	
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("robin", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Currency[]> response = client.template().exchange(client.apiUrl("currency"), HttpMethod.GET, request, Currency[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Currency[] currency = response.getBody();
    	if(currency != null) {
    		System.out.println("Total currency Found " + currency.length);
    	}
    	for(int i=0;i<currency.length;i++) {
        	Assertions.assertThat(currency[i]).isNotNull();    
        }
    	
    
    }
}