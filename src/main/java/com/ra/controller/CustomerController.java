package com.ra.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.BaseEntity;
import com.ra.domain.Customer;
import com.ra.repository.CustomerRepository;

@RestController
public class CustomerController extends BaseController {
	
	public static Logger logger = LogManager.getLogger(CustomerController.class);
	String name = "CustomerController";

	public CustomerController() {
		this.setName(name);
	}
	
    @Inject
    CustomerRepository customerRepository;
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer creaet(@RequestBody Customer customer) {
    	
    	logger.debug("Customer from UI :" +customer+ ":");
    	//Lifecycle method to add who columns save
     	updateWHOColumns(customer);
    	return customerRepository.save(customer);
    }
    
   @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@PathVariable Long id) {
	   customerRepository.delete(id);
	   logger.debug("Discount item " + id  + "deleted successfully");
    } 
    
   @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findCustomer() {
        final List<Customer> resultList = new ArrayList<>();
        final Iterable<Customer> all = customerRepository.findAll();
        
        Iterator<Customer> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Customer customer = (Customer) all_I.next();
			resultList.add(customer);
		}      
        return resultList;
    }
}
    
 