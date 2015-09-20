package com.ra.domain;

import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String user;
    
    @Column(name = "type", nullable = false)
    private String type;
    
    
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
