package com.ra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="appuser")
public class User {
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private String id;
	
	@Column(name = "username", nullable = false)
    private String username;
	
	@Column(name = "usertype", nullable = false)
    private String usertype;
	
	 @Column(name = "loginid", nullable = false)
	    private String loginid;
		
	 @Column(name = "password", nullable = false)
	    private String password;
	  @Column(name = "email", nullable = false)
	    private String email;
		
	  public User(String id, String username, String usertype, 
				String loginid, String password, String email) {
			super();
			this.id = id;
			this.username = username;
			this.usertype = usertype;
			this.loginid = loginid;
			this.password = password;
			this.email =email;
			
			
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
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

}
