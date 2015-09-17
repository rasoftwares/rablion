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

import com.ra.domain.AppUser;
import com.ra.repository.ExpenseRepository;
import com.ra.repository.UserRepository;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Inject
    UserRepository userRepository;
    
    @Inject
    ExpenseRepository expenseRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
          return "Hello there !";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser create(@PathVariable String username) {
        return userRepository.save(new AppUser(username));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<>();
        final Iterable<AppUser> all = userRepository.findAll();
        //System.out.println("Total Users: " + all.iterator())
        Iterator<AppUser> all_I = all.iterator();
        while (all_I.hasNext()) {
			AppUser user = (AppUser) all_I.next();
			resultList.add(user);
		}
        /*all.forEach(new Consumer<AppUser>() {
            @Override
            public void accept(AppUser appUser) {
                resultList.add(appUser);
            }
        });*/
        
        return resultList;
    }
}
