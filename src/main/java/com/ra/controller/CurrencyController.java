package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ra.domain.Currency;
import com.ra.repository.CurrencyRepository;

@RestController
public class CurrencyController extends BaseController {
	String name = "CurrencyController";

	public CurrencyController() {
		this.setName(name);
	}
	
     @Inject
    CurrencyRepository currencyRepository;
      
     @RequestMapping(value = "/currency", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public Currency create(@RequestBody Currency currency) {
     	System.out.println("Currency from UI :" + currency + ":");
     	return currencyRepository.save(currency);
     }
     @RequestMapping(value = "/currency/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public void deleteCurrency(@PathVariable Long id) {
         currencyRepository.delete(id);
         System.out.println("Currency item " + id  + "deleted successfully");
     }
     
    
    @RequestMapping(value = "/currency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Currency> findCurrency () {
        final List<Currency> resultList = new ArrayList<>();
        final Iterable<Currency> all = currencyRepository.findAll();
        
        Iterator<Currency> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Currency currency = (Currency) all_I.next();
			resultList.add(currency);
		}      
        return resultList;
    }
}
    
  
