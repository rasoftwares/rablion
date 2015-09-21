package com.ra.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String user;
    
    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "amount", nullable = false)
    private Double amount;
    
    @Column(name = "type", nullable = false)
    private String type;
    
    
    
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Expense() {
    	
    }

    public Expense(String user) {
        this.user = user;
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
    
   
}
