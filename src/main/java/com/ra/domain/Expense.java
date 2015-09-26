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
    

    public Expense(Long id, String user, Date date, Double amount, String type) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.amount = amount;
		this.type = type;
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
	
	/*public static void main(String a[]){
		System.out.println(new Expense(1L,"demouser",new Date(System.currentTimeMillis()),1234.56,"Food"));
	}*/
}
