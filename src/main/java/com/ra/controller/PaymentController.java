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

import com.ra.domain.Payment;
import com.ra.repository.PaymentRepository;

@RestController
public class PaymentController extends BaseController {
	String name = "PaymentController";

	public PaymentController() {
		this.setName(name);
	}
	
     @Inject
  PaymentRepository paymentRepository;
      
     @RequestMapping(value = "/payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public Payment create(@RequestBody Payment payment) {
     	System.out.println("Payment from UI :" + payment + ":");
     	return paymentRepository.save(payment);
     }
     @RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public void deletePayment(@PathVariable Long id) {
    	 paymentRepository.delete(id);
         System.out.println("Payment item " + id  + "deleted successfully");
     }
     
    
    @RequestMapping(value = "/payment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> findPayment () {
        final List<Payment> resultList = new ArrayList<>();
        final Iterable<Payment> all = paymentRepository.findAll();
        
        Iterator<Payment> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Payment payment = (Payment) all_I.next();
			resultList.add(payment);
		}      
        return resultList;
    }
}
    
  
