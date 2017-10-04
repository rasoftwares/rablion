package com.ra.test.controller;

import org.junit.Assert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ra.test.util.EntityFactory;
import com.ra.test.util.RestClient;

public class BaseControllerIntegrationTests {

	String username = "admin";
	String password = "password";

	String url;
	String protocol = "http://";
	String host = "localhost";

	String application_prefix = "rest";

	String entity;

	HttpEntity<String> request;
	HttpHeaders headers;

	RestClient client;

	String POST = "POST";
	String GET = "GET";
	String DELETE = "DELETE";
	String UPDATE = "UPDATE";

	@LocalServerPort
	private int port;

	public void initialize() {
		headers = new HttpHeaders();
		request = new HttpEntity<String>(headers);

		client = new RestClient();
		client.setApplicationPath("");
		String url = client.login("admin", "password");

		url = getProtocol() + getHost() + ":" + port + "/" + application_prefix;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getHost() {
		return host;
	}

	public ResponseEntity<Object[]> find(String entityName, String methodName, Class obj) {
		ResponseEntity<Object[]> response = null;
		if (methodName.equals(GET)) {
			response = client.template().exchange(client.apiUrl(entityName), HttpMethod.GET, request, obj);
		} else {
		}
		//System.out.println("====>" + response);
		return response;
	}

	public Object create(String entityName, String methodName, Class obj) {
		Object response = null;
		Object entityObj = EntityFactory.getDomainEntityforClass(obj);
		//System.out.println("Entiy object" + entityObj);

		if (methodName.equals(POST)) {
			response = client.template().postForObject(client.apiUrl(entityName), entityObj, obj);
		}
		Assert.assertNotNull(response);
		return response;
	}
	
	public void delete(String entityName, String methodName, Class obj) {
		boolean flag = false;
		
		//Always delete the second entry that gets created during the test scenario.

		if (methodName.equals(DELETE)) {
			//System.out.println("Deleting object " + entityName + ":" + client.apiUrl(entityName) + "/" + "2");
			client.template().delete(client.apiUrl(entityName) + "/" + "2");
			flag = true;
		}
		
		Assert.assertTrue( entityName + " deleted Successfully", flag == true);
		
	}
	
}
