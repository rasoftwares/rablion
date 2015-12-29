package com.ra.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;
	
	@Column(name = "task", nullable = false)
    private String task;
	
	@Column(name = "status", nullable = false)
    private String status;
	
	 @Column(name = "startdate", nullable = false)
	    private Date startdate;
		
	 @Column(name = "enddate", nullable = false)
	    private Date enddate;
		
	
	 
	 public Todo(Long id, String task, String status, Date startdate,
				Date enddate) {
			super();
			this.id = id;
			this.task = task;
			this.status = status;
			this.startdate = startdate;
			this.enddate = enddate;
			
			}
public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	}
	
	
			
	
	

