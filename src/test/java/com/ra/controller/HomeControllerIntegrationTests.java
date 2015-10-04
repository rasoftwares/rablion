package com.ra.controller;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ra.config.AppConfig;
import com.ra.domain.Appuser;
import com.ra.domain.Expense;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@WebIntegrationTest("server.port:9000")
public class HomeControllerIntegrationTests {

    RestTemplate restTemplate = new TestRestTemplate();

    /*@Test
    public void shouldAdd_AppUser_ToDb(){
        ResponseEntity<Appuser> responseEntity = restTemplate.postForEntity("http://localhost:9000/homecontroller/user/Abderrazak BOUADMA", MockHttpServletRequest.DEFAULT_PROTOCOL, Appuser.class);
        final Appuser appUser = responseEntity.getBody();
        Assertions.assertThat(appUser).isNotNull();
        Assertions.assertThat(appUser.getUsername()).isNotNull().isEqualTo("Abderrazak BOUADMA");
    }*/
    
    /*@Test
    public void shouldAdd_Expense_ToDb(){
        ResponseEntity<Expense> responseEntity = restTemplate.postForEntity("http://localhost:9000/rest/expense/luba/10", MockHttpServletRequest.DEFAULT_PROTOCOL, Expense.class);
        final Expense expenses = responseEntity.getBody();
        Assertions.assertThat(expenses).isNotNull();
        Assertions.assertThat(expenses.getUser()).isNotNull().isEqualTo("luba");
    }*/
    
    /*@Test
    public void shouldDelete_Expense_ToDb(){
//        ResponseEntity<Expenses> responseEntity = restTemplate.delete("http://localhost:9000/expense/luba/18",null);
//        final Expenses expenses = responseEntity.getBody();
//        Assertions.assertThat(expenses).isNotNull();
//        Assertions.assertThat(expenses.getUser()).isNotNull().isEqualTo("luba");
    }*/
}
