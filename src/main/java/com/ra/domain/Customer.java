package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends BaseEntity {
	    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
      
    @Column(name = "customerid")
    private String customerid;
    
    @Column(name = "companyname")
    private String companyname;
        
    @Column(name = "title")
    private String title;
    
    @Column(name = "registrationno")
    private String registrationno;
    
    @Column(name = "registrationyear")
    private Date registrationyear;
    
    @Column(name = "ownername")
    private String ownername;
    
    @Column(name = " photograph")
    private String  photograph;
    
    @Column(name = "shortdescription")    
    private String  shortdescription;
    
    @Column(name = "registredaddress")
    private String  registredaddress;
    
    @Column(name = "officeaddress")
    private String  officeaddress;
    
    @Column(name = "landlineno")
    private Double  landlineno;
    
    @Column(name = "mobileno")
    private Double  mobileno;
    
    
    @Column(name = "emailid")
    private String  emailid;
    
    @Column(name = "website")
    private String  website;
    
    @Column(name = "aboutcompany")
    private String  aboutcompany;
    
    
    public Customer(){
    }
    
       
    public Customer(Long id,String customerid,String companyname,String title,String registrationno,Date registrationyear,String ownername,String photograph,String shortdescription,String registredaddress,String officeaddress,Double landlineno,Double mobileno,String emailid,String website,String aboutcompany,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
	    this.customerid = customerid;
	    this.companyname = companyname;
	    this.title = title;
	    this.registrationno = registrationno;
	    this.registrationyear = registrationyear;
	    this.ownername = ownername;
	    this.photograph = photograph;
	    this.shortdescription = shortdescription;
	    this.registredaddress = registredaddress;
	    this.officeaddress = officeaddress;
	    this.landlineno = landlineno;
	    this.mobileno = mobileno;
	    this.emailid= emailid;
	    this.website = website;
	    this.aboutcompany = aboutcompany;
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


	public String getCustomerid() {
		return customerid;
	}


	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}


	public String getCompanyname() {
		return companyname;
	}


	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getRegistrationno() {
		return registrationno;
	}


	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}


	public Date getRegistrationyear() {
		return registrationyear;
	}


	public void setRegistrationyear(Date registrationyear) {
		this.registrationyear = registrationyear;
	}


	public String getOwnername() {
		return ownername;
	}


	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}


	public String getPhotograph() {
		return photograph;
	}


	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}


	public String getShortdescription() {
		return shortdescription;
	}


	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}


	public String getRegistredaddress() {
		return registredaddress;
	}


	public void setRegistredaddress(String registredaddress) {
		this.registredaddress = registredaddress;
	}


	public String getOfficeaddress() {
		return officeaddress;
	}


	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}


	public Double getLandlineno() {
		return landlineno;
	}


	public void setLandlineno(Double landlineno) {
		this.landlineno = landlineno;
	}


	public Double getMobileno() {
		return mobileno;
	}


	public void setMobileno(Double mobileno) {
		this.mobileno = mobileno;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getAboutcompany() {
		return aboutcompany;
	}


	public void setAboutcompany(String aboutcompany) {
		this.aboutcompany = aboutcompany;
	}
}
