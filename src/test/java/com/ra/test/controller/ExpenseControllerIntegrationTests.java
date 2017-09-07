package com.ra.test.controller;

/*
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@WebIntegrationTest("server.port:9000")
public class ExpenseControllerIntegrationTests {

    RestTemplate restTemplate = new TestRestTemplate();
    //String url = "http://localhost:9095";
    
    Expense e1 = new Expense(1L,"User1",new Date(System.currentTimeMillis()),1234.56,"Food");
    Expense e2 = new Expense(2L,"User2",new Date(System.currentTimeMillis()),789.12,"Travel");

    
    @Test
    public void find(){
    	
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("robin", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Expense[]> response = client.template().exchange(client.apiUrl("expense"), HttpMethod.GET, request, Expense[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Expense[] expense = response.getBody();
    	if(expense != null) {
    		System.out.println("Total Expenses Found " + expense.length);
    	}
    	for(int i=0;i<expense.length;i++) {
        	Assertions.assertThat(expense[i]).isNotNull();    
        }
    	
    
    }
    
    @Test
    public void create(){
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("robin", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Expense[]> response = client.template().exchange(client.apiUrl("expense"), HttpMethod.POST, request, Expense[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Expense[] expense = response.getBody();
    	if(expense != null) {
    		System.out.println("Total Expenses Found " + expense.length);
    	}
    	for(int i=0;i<expense.length;i++) {
        	Assertions.assertThat(expense[i]).isNotNull();    
        }
    
    	
    }
    
    @Test
    public void delete(){
    	HttpHeaders headers = new HttpHeaders();
    	final HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	RestClient client = new RestClient();
    	client.setApplicationPath("");
    	String url = client.login("robin", "password");
    	System.out.println(url);
    	
    	ResponseEntity<Expense[]> response = client.template().exchange(client.apiUrl("expense"), HttpMethod.DELETE, request, Expense[].class);
    	System.out.println("Response -->" + response.getBody());
    	
    	final Expense[] expense = response.getBody();
    	if(expense != null) {
    		System.out.println("Total Expenses Found " + expense.length);
    	}
    	for(int i=0;i<expense.length;i++) {
        	Assertions.assertThat(expense[i]).isNotNull();    
        }
    
    }
}

*/





