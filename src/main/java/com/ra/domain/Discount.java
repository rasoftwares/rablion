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

   
      
    @Column(name = "startdate", nullable = false)
    private Date startdate;
    
    @Column(name = "enddate", nullable = false)
    private Date enddate;
    
    @Column(name = "percentage", nullable = false)
    private Long percentage;
    
    @Column(name = "isactive", nullable = false)
    private String isactive;
    
    @Column(name = "createdby", nullable = false)
    private String createdby;
    
    @Column(name = "createdtimestamp", nullable = false)
    private Date createdtimestamp;
    
    @Column(name = "modifiedby", nullable = false)
    private String modifiedby;
    
    @Column(name = "modifiedtimestamp", nullable = false)
    private Date modifiedtimestamp;
    




    
    
    public Discount(){
    }
    
       
    public Discount(Long id, Date startdate,Date enddate,Long percentage,String isactive,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.startdate=startdate;
		this.enddate=enddate;
		this.percentage=percentage;
		this.isactive=isactive;
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


	public String getIsactive() {
		return isactive;
	}


	public void setIsactive(String isactive) {
		this.isactive = isactive;
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
