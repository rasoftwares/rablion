package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="appuser")
public class User {
	
	public User(){
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;
	
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
	  
	    @Column(name = "createdby", nullable = false)
	    private String createdby;
	    
	    @Column(name = "createdtimestamp", nullable = false)
	    private Date createdtimestamp;
	    
	    @Column(name = "modifiedby", nullable = false)
	    private String modifiedby;
	    
	    @Column(name = "modifiedtimestamp", nullable = false)
	    private Date modifiedtimestamp;

		
	  public User(Long id, String username, String usertype, 
				String loginid, String password, String email,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
			super();
			this.id = id;
			this.username = username;
			this.usertype = usertype;
			this.loginid = loginid;
			this.password = password;
			this.email =email;
			this.createdby=createdby;
			this.createdtimestamp=createdtimestamp;
			this.modifiedby=modifiedby;
			this.modifiedtimestamp=modifiedtimestamp;
			
			
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Date getModifiedtimestamp() {
		return modifiedtimestamp;
	}

	public void setModifiedtimestamp(Date modifiedtimestamp) {
		this.modifiedtimestamp = modifiedtimestamp;
	}

	
	
}
