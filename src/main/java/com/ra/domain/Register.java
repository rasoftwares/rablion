package com.ra.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class Register {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id", nullable = false)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
        

	public void setId(long id){
    	this.id = id;
    }
    
    public long getId(){
    	return id;
    }
    

    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Register() {}

    public Register(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

   
}