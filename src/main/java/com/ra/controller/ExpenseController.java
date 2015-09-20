package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Consumer;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.Expense;
import com.ra.repository.ExpenseRepository;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseController {

    @Inject
    ExpenseRepository expenseRepository;
    
    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
          return "Hello there !";
    }

    
    @RequestMapping(value = "/expense/{username}/{userid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Expense createExpense(@PathVariable String username, @PathVariable String userid) {
    	System.out.println("UserID :" + userid + ":");
    	Expense exp = new Expense(username);
        return expenseRepository.save(exp);
    }
    
    @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteExpense(@PathVariable Long id) {
        expenseRepository.delete(id);
        
        System.out.println("Expense item " + id  + "deleted successfully");
    }
    
    
    @RequestMapping(value = "/expense", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Expense> findExpenses() {
        final List<Expense> resultList = new ArrayList<>();
        final Iterable<Expense> all = expenseRepository.findAll();
        
        Iterator<Expense> all_I = all.iterator();
        
        while (all_I.hasNext()) {
        	Expense user = (Expense) all_I.next();
			resultList.add(user);
		}
        
        return resultList;
    }

}
