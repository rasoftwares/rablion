package com.ra.domain;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Currency extends BaseEntity{
	public Currency() {
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "sourcevalue", nullable = false)
    private Double sourcevalue;
   
    @Column(name = "inrvalue", nullable = false)
    private Double inrvalue;
   
     
	
    public Currency(Long id, String currency,Double sourcevalue,Double inrvalue,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.currency=currency;
		this.sourcevalue=sourcevalue;
		this.inrvalue=inrvalue;
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


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Double getSourcevalue() {
		return sourcevalue;
	}


	public void setSourcevalue(Double sourcevalue) {
		this.sourcevalue = sourcevalue;
	}


	public Double getInrvalue() {
		return inrvalue;
	}


	public void setInrvalue(Double inrvalue) {
		this.inrvalue = inrvalue;
	}
	
}
	
	