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
import com.ra.domain.Catalog;
import com.ra.util.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@WebIntegrationTest("server.port:9000")
public class CatalogControllerIntegrationTests {

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
    	
    	ResponseEntity<Catalog[]> response = client.template().exchange(client.apiUrl("catalog"), HttpMethod.GET, request, Catalog[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Catalog[] catalog = response.getBody();
    	if(catalog != null) {
    		System.out.println("Total catalog Found " + catalog.length);
    	}
    	for(int i=0;i<catalog.length;i++) {
        	Assertions.assertThat(catalog[i]).isNotNull();    
        }
    	
    
    }
}