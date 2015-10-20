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

import com.ra.domain.Appuser;
import com.ra.domain.User;
import com.ra.repository.ExpenseRepository;
import com.ra.repository.UserRepository;

@RestController
@RequestMapping(value = "/homecontroller", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Inject
    UserRepository userRepository;
    
    @Inject
    ExpenseRepository expenseRepository;

    @RequestMapping(value = "/hellothere", method = RequestMethod.GET)
    public String sayHello(){
          return "Hello there !";
    }
		
  /*  @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(@PathVariable String username) {
        return UserRepository.save(new User(username));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appuser> findAll() {
        final List<Appuser> resultList = new ArrayList<>();
        final Iterable<Appuser> all = UserRepository.findAll();
        
        Iterator<Appuser> all_I = all.iterator();
        while (all_I.hasNext()) {
        	Appuser user = (Appuser) all_I.next();
			resultList.add(user);
		}
        
        /*all.forEach(new Consumer<AppUser>() {
            @Override
            public void accept(AppUser appUser) {
                resultList.add(appUser);
            }
        });*/
        
    //    return resultList;
  // }*/
}
