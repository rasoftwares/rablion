package com.ra.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ra.util.GlobalConstants;


@RequestMapping(value = GlobalConstants.REST_BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {
    
	private String name = "BaseController" ;
	
    
    @RequestMapping(value = GlobalConstants.REST_ERR_URL)
    public String error() {
        return "Error handling";
    }
    
    @RequestMapping(value = GlobalConstants.REST_HELLO_URL, method = RequestMethod.GET)
    public String sayHello(){
          return "Hello there I am Controller " + getName();
    }
    
    /*@RequestMapping(value = GlobalConstants.REST_LOGOUT_URL, method = RequestMethod.GET)
    public void logout() {
    	System.out.println("Loggingout the user" );
    	
    	//return "Hello there I am Controller " + getName();
    }*/
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

}
