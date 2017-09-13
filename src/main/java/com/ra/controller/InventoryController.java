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
import com.ra.domain.Inventory;
import com.ra.repository.InventoryRepository;

@RestController
public class InventoryController extends BaseController {
	public static Logger logger = LogManager.getLogger(BaseController.class);

	String name = "InventoryController";

	public InventoryController() {
		this.setName(name);
	}
	
    @Inject
    InventoryRepository inventoryRepository;
    
    @RequestMapping(value = "/inventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventory creaet(@RequestBody Inventory inventory) {
    	logger.debug("Inventory from UI :" + inventory + ":");
    	return inventoryRepository.save(inventory);
    }
    
   @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteInventory(@PathVariable Long id) {
        inventoryRepository.delete(id);
        logger.debug("Inventory item " + id  + "deleted successfully");
    }
    
    
    @RequestMapping(value = "/inventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Inventory> findInventory() {
        final List<Inventory> resultList = new ArrayList<>();
        final Iterable<Inventory> all = inventoryRepository.findAll();
        logger.debug("Fetching inventory items");
        Iterator<Inventory> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Inventory inventory = (Inventory) all_I.next();
			resultList.add(inventory);
		}      
        return resultList;
    }
}
    
 /*   @RequestMapping(value = "/amountSpent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, AmountSpent> amountSpent(@RequestParam String username) {
    	
    	//TODO: Validate null for username, period
    	String period = "Week";
    	
    	System.out.println( "--->" +username + ":" + period);
    	List<Inventory> resultList = new ArrayList<>();
        
        final Iterable<Inventory> all = InventoryRepository.findAll();
        
        Iterator<Inventory> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Inventory user = (Inventory) all_I.next();
			resultList.add(user);
		}
        
        System.out.println("resultList Size :" + resultList.size());
        
        if(resultList.size() == 0) {
        	System.out.println("FATAL : there are no Inventorys found for userid " + username);
        	return new HashMap<String,AmountSpent>();
        }
        
        HashMap<String, AmountSpent> fmap = filterInventorys(resultList,username,period);
        
        return fmap;
    }
    
    
    public List<Inventory> dummyData(){
    	List<Inventory> list = new ArrayList<Inventory>();
    	list.add(new Inventory(1L,"User1", new Date(115,00,1),"INR",300.30,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(115,00,2),"INR",100.30,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(115,00,14),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(115,00,14),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(115,00,14),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(116,00,24),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(116,00,14),"INR",100.00,"Mobile"));
    	
    	list.add(new Inventory(1L,"User1", new Date(115,01,5),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User1", new Date(115,06,11),"INR",100.00,"Mobile"));
    	
    	list.add(new Inventory(1L,"User2", new Date(115,02,12),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User2", new Date(115,02,13),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User2", new Date(115,02,14),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User2", new Date(115,02,15),"INR",100.00,"Mobile"));
    	
    	list.add(new Inventory(1L,"User3", new Date(115,02,12),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User3", new Date(115,02,13),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User3", new Date(115,02,14),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User3", new Date(115,02,15),"INR",100.00,"Mobile"));
    	list.add(new Inventory(1L,"User3", new Date(115,11,15),"INR",100.00,"Mobile"));
    	
    	return list;
    }
    
    public HashMap<String, AmountSpent> filterInventorys(List<Inventory> list, String username, String period) {
    	
    	//String username = "User3";
    	//String period = "Week";
    	
    	//System.out.println(list);
    	//TODO: null validation for list, username, period
    	
    	HashMap<String, AmountSpent> fmap = new HashMap<String,AmountSpent>();
    	
    	HashMap<String, List<Inventory>> m = new HashMap<String,List<Inventory>>();
    	
    	//Seperate the master list by userwise
    	for(Inventory e : list) {
    		if(!m.containsKey(e.getUser())) {
    			ArrayList<Inventory> l = new ArrayList<Inventory>();
    			l.add(e);
    			m.put(e.getUser(), l);
    		}
    		else if(m.containsKey(e.getUser())){
    			List<Inventory> l = m.get(e.getUser());
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
    	
    	if(m.get(username) == null || m.get(username).size() ==0) {
        	System.out.println("FATAL : there are no Inventorys found for userid " + username);
        	return new HashMap<String,AmountSpent>();
        }
    	
    	List<Inventory> fList = m.get(username);
    	
    	
    	String week = "";
    	for(Inventory e : fList) {
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
	
}*/