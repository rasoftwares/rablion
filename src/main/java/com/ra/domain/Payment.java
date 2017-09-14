package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment extends BaseEntity {
	    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "txnid", nullable = false)
    private String txnid;
    
    @Column(name = "userid", nullable = false)
    private String userid;
    
    @Column(name = "orderid", nullable = false)
    private String orderid;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "amount", nullable = false)
    private Long amount;
    
    @Column(name = "date", nullable = false)
    private Date date;
           
    public Payment(){
    }
    
       
    public Payment(Long id, String txnid,String userid,String orderid,String status,Long amount,Date date,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.txnid=txnid;
		this.userid=userid;
		this.orderid=orderid;
		this.status=status;
		this.amount=amount;
		this.date=date;
		createdby=createdby;
		createdtimestamp=createdtimestamp;
		modifiedby=modifiedby;
		modifiedtimestamp=modifiedtimestamp;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTxnid() {
		return txnid;
	}


	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
}
