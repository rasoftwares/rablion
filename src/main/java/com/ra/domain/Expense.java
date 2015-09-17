package com.ra.domain;

import javax.persistence.*;

public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String user;
    
   public Expenses() {
    	
    }

    public Expenses(String user) {
        this.user = user;
    }

    public Expenses(long id, String user) {
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
