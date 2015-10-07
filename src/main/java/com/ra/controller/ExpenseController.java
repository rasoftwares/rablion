package com.ra.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Consumer;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.BaseEntity;
import com.ra.domain.Expense;
import com.ra.repository.ExpenseRepository;

@RestController
public class ExpenseController extends BaseController {
	String name = "ExpenseController";

	public ExpenseController() {
		this.setName(name);
	}
	
    @Inject
    ExpenseRepository expenseRepository;
    
    @RequestMapping(value = "/expense", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Expense creaet(@RequestBody Expense expense) {
    	System.out.println("Expense from UI :" + expense + ":");
    	return expenseRepository.save(expense);
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
    
    @RequestMapping(value = "/amountSpent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, AmountSpent> amountSpent(@RequestParam String username) {
    	
    	//TODO: Validate null for username, period
    	String period = "Week";
    	
    	System.out.println( "--->" +username + ":" + period);
    	final List<Expense> resultList = new ArrayList<>();
        
        final Iterable<Expense> all = expenseRepository.findAll();
        
        Iterator<Expense> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Expense user = (Expense) all_I.next();
			resultList.add(user);
		}
        HashMap<String, AmountSpent> fmap = filterExpenses(resultList,username,period);
        
        return fmap;
    }
    
    
    public List<Expense> dummyData(){
    	List<Expense> list = new ArrayList<Expense>();
    	list.add(new Expense(1L,"User1", new Date(115,00,1),300.30,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(115,00,2),100.30,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(115,00,14),100.00,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(115,00,14),100.00,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(115,00,14),100.00,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(116,00,24),100.00,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(116,00,14),100.00,"Mobile"));
    	
    	list.add(new Expense(1L,"User1", new Date(115,01,5),100.00,"Mobile"));
    	list.add(new Expense(1L,"User1", new Date(115,06,11),100.00,"Mobile"));
    	
    	list.add(new Expense(1L,"User2", new Date(115,02,12),100.00,"Mobile"));
    	list.add(new Expense(1L,"User2", new Date(115,02,13),100.00,"Mobile"));
    	list.add(new Expense(1L,"User2", new Date(115,02,14),100.00,"Mobile"));
    	list.add(new Expense(1L,"User2", new Date(115,02,15),100.00,"Mobile"));
    	
    	
    	list.add(new Expense(1L,"User3", new Date(115,02,12),100.00,"Mobile"));
    	list.add(new Expense(1L,"User3", new Date(115,02,13),100.00,"Mobile"));
    	list.add(new Expense(1L,"User3", new Date(115,02,14),100.00,"Mobile"));
    	list.add(new Expense(1L,"User3", new Date(115,02,15),100.00,"Mobile"));
    	list.add(new Expense(1L,"User3", new Date(115,11,15),100.00,"Mobile"));
    	
    	return list;
    }
    
    public HashMap<String, AmountSpent> filterExpenses(List<Expense> list, String username, String period) {
    	
    	//String username = "User3";
    	//String period = "Week";
    	
    	//System.out.println(list);
    	//TODO: null validation for list, username, period
    	
    	
    	HashMap<String, List<Expense>> m = new HashMap<String,List<Expense>>();
    	
    	//Seperate the master list by userwise
    	for(Expense e : list) {
    		if(!m.containsKey(e.getUser())) {
    			ArrayList<Expense> l = new ArrayList<Expense>();
    			l.add(e);
    			m.put(e.getUser(), l);
    		}
    		else if(m.containsKey(e.getUser())){
    			List<Expense> l = m.get(e.getUser());
    			l.add(e);
    		}
    	}
    	
    	//System.out.println(m.size());
    	
    	//User wise grouping done for the records
    	Set<String> keys =  m.keySet();
    	Iterator keysI = keys.iterator();
    	//while(keysI.hasNext()){
    		//System.out.println(m.get(keysI.next()));
    	//}
    	
    	//Group by period 
    	SimpleDateFormat week_df = new SimpleDateFormat(getPeriod("Week"));
    	SimpleDateFormat month_df = new SimpleDateFormat(getPeriod("Month"));
    	
    	System.out.println("Period :" + getPeriod(period));
    	List<Expense> fList = m.get(username);
    	
    	HashMap<String, AmountSpent> fmap = new HashMap<String,AmountSpent>();
    	String week = "";
    	for(Expense e : fList) {
    		week = week_df.format(e.getDate());
    		
    		if(!fmap.containsKey(week)) {
    			AmountSpent rb = new AmountSpent(week_df.format(e.getDate()), month_df.format(e.getDate()), e.getAmount(), e.getUser());
    			fmap.put(week,rb);
    		}
    		else if(fmap.containsKey(week)){
    			AmountSpent rb = fmap.get(week);
    			rb.setAmount(rb.getAmount() + e.getAmount()); 
    		}
    		else {
    			System.out.println("ERROR : Invalid data found" );
    		}
    	}
    	
    	System.out.println("-----------------------------------");
    	//User wise grouping done for the records
    	Set<String> keys1 =  fmap.keySet();
    	Iterator keys1I = keys1.iterator();
    	
    	while(keys1I.hasNext()){
    		System.out.println(fmap.get(keys1I.next()));
    	}
    	
    	return fmap;
    	
    }
    
    public static String getPeriod(String period) {
    	String p = "";
    	switch(period){
    	case "Week": p="w"; break;
    	case "Month": p="M"; break ;
    	case "Year": p="Y"; break ;
    	default :
    			break;
    	}
    	return p;
    }
    
}

class AmountSpent extends BaseEntity {
	
	String week;
	double amount;
	String username;
	String month;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public AmountSpent(String week, String month, Double amount,String username) {
		this.week = week;
		this.month = month;
		this.amount = amount;
		this.username = username;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}