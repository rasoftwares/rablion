package com.ra.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.ra.domain.Catalog;
import com.ra.repository.CatalogRepository;
import com.ra.repository.InventoryRepository;

@RestController
public class CatalogController extends BaseController {

	String name = "CatalogController";

	public CatalogController() {
		this.setName(name);
		}
	
     @Inject
    CatalogRepository catalogRepository;
      
     @RequestMapping(value = "/catalog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public Catalog create(@RequestBody Catalog catalog) {
     	System.out.println("Catalog from UI :" + catalog + ":");
     	return catalogRepository.save(catalog);
     }
     @RequestMapping(value = "/catalog/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public void deleteCatalog(@PathVariable Long id) {
         catalogRepository.delete(id);
         System.out.println("Catalog item " + id  + "deleted successfully");
     }
     
    
    @RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Catalog> findCatalog () {
        final List<Catalog> resultList = new ArrayList<>();
        final Iterable<Catalog> all = catalogRepository.findAll();
        
        Iterator<Catalog> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Catalog catalog = (Catalog) all_I.next();
			resultList.add(catalog);
		}      
        return resultList;
    }
}
    
  
