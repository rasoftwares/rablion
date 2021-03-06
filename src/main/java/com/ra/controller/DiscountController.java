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
import com.ra.domain.Discount;
import com.ra.repository.DiscountRepository;

@RestController
public class DiscountController extends BaseController {
	
	public static Logger logger = LogManager.getLogger(DiscountController.class);
	String name = "DiscountController";

	public DiscountController() {
		this.setName(name);
	}
	
    @Inject
    DiscountRepository discountRepository;
    
    @RequestMapping(value = "/discount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Discount create(@RequestBody Discount discount) {
    	logger.debug("Discount from UI :" + discount+ ":");
    	//Lifecycle method to add who columns save
     	updateWHOColumns(discount);
    	return discountRepository.save(discount);
    }
    
   @RequestMapping(value = "/discount/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDiscount(@PathVariable Long id) {
	   discountRepository.delete(id);
	   logger.debug("Discount item " + id  + "deleted successfully");
    }
   
   
   
  
   
   
    
    @RequestMapping(value = "/discount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Discount> findInventory() {
        final List<Discount> resultList = new ArrayList<>();
        final Iterable<Discount> all = discountRepository.findAll();
        
        Iterator<Discount> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Discount discount = (Discount) all_I.next();
			resultList.add(discount);
		}      
        return resultList;
    }
}
    
 