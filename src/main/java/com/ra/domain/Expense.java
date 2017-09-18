package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String user;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "expensetype")
    private String expenseType;
       
    
    public Expense(long l, String string, Date date2, double d, String string2) {
    	
    }

    public Expense(String user) {
        this.user = user;
        
    }
    
    public Expense() {
    	
    }
   
    public Expense(Long id, String user, Date date, Double amount, String expenseType, String createdby, Date createdtimestamp, String modifiedby, Date modifiedtimestamp) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		
		this.amount = amount;
		this.expenseType = expenseType;
		createdby=createdby;
		createdtimestamp=createdtimestamp;
		modifiedby=modifiedby;
		modifiedtimestamp=modifiedtimestamp;
	}
    
	public Expense(long id, String user) {
        this.id = id;
        this.user = user;        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpeseType(String expenseType) {
		this.expenseType = expenseType;
	}


}
