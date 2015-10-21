package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Consumer;



import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.Loan;
import com.ra.repository.MortgageRepository;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class MortgageController {
	String name = "MortgageController";

	public MortgageController() {
	
			}

   	@Inject
    MortgageRepository mortgageRepository;
   
    
    @RequestMapping(value = "/helloLoan", method = RequestMethod.GET)
    public String sayHello(){
          return "Hello there !";
    }

     @RequestMapping(value = "/loan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan createloan(@RequestBody Loan loan) 
    {
    	System.out.println("Request Body :" + loan + ":");
    	
        return mortgageRepository.save(loan);
    	
    }	
    
   
   /* @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteExpense(@PathVariable Long id) {
        mortgageRepository.delete(id);
        
        System.out.println("Expense item " + id  + "deleted successfully");
    }*/
   
    
    @RequestMapping(value = "/loan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Loan> findloan() {
        final List<Loan> resultList = new ArrayList<>();
        final Iterable<Loan> all = mortgageRepository.findAll();
        
        Iterator<Loan> all_I = all.iterator();
        
        while (all_I.hasNext()) {
        	Loan loan = (Loan) all_I.next();
			resultList.add(loan);
		}
        
        return resultList;
    }

}
