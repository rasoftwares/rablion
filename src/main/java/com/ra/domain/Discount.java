package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount extends BaseEntity {
	    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
	    
    @Column(name = "startdate")
    private Date startdate;
    
    @Column(name = "enddate")
    private Date enddate;
    
    @Column(name = "percentage")
    private Long percentage;
    
    @Column(name = "active")
    private boolean active;
    
    
	public Discount(){
    }
    
       
    public Discount(Long id, Date startdate,Date enddate,Long percentage,boolean active,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.startdate=startdate;
		this.enddate=enddate;
		this.percentage=percentage;
		this.active=active;
		createdby=createdby;
		createdtimestamp=createdtimestamp;
		modifiedby=modifiedby;
		modifiedtimestamp=modifiedtimestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}
