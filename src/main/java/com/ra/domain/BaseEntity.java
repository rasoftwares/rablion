package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




public class BaseEntity {
	public String entityName = "";
	
    @Column(name = "createdby", nullable = false)
    private String createdby;
    
    @Column(name = "createdtimestamp", nullable = false)
    private Date createdtimestamp;
    @Column(name = "modifiedy")
    private String modifiedby;
    @Column(name = "modifiedtimestamp")
    private Date modifiedtimestamp;

	
	
	public static Logger logger = LogManager.getLogger(BaseEntity.class);
	
	public BaseEntity() {
		
		init();
		System.out.println("Creating Entity " + entityName);
	}
	
	public void init(){
		entityName = this.getClass().getSimpleName();
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

		
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
		
	}
	
	protected void finalize() throws Throwable {
		System.out.println("+++++ Object " + entityName +" getting deleted +++++");
	}

}
