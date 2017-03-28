package com.ra.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory extends BaseEntity {
	    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "itemname", nullable = false)
    private String itemname;
    
    @Column(name = "itemtype", nullable = false)
    private String itemtype;
    
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    
    @Column(name = "alertlimit", nullable = false)
    private Long alertlimit;
    
    @Column(name = "purchaseprice", nullable = false)
    private Long purchaseprice;
    
    @Column(name = "discountpercentage", nullable = false)
    private Long discountpercentage;
    
    @Column(name = "purchasedate", nullable = false)
    private Date purchasedate;
    
    @Column(name = "saledate", nullable = false)
    private Date saledate;
    
    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name = "createdby", nullable = false)
    private String createdby;
    
    @Column(name = "createdtimestamp", nullable = false)
    private Date createdtimestamp;
    
    @Column(name = "modifiedby", nullable = false)
    private String modifiedby;
    
    @Column(name = "modifiedtimestamp", nullable = false)
    private Date modifiedtimestamp;
    




    
    
    public Inventory(){
    }
    
       
    public Inventory(Long id, String itemname,String itemtype,Long quantity,Long alertlimit,Long purchaseprice,Long discountpercentage,Date purchasedate,Date saledate,String image,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.itemname= itemname;
		this.itemtype= itemtype;
		this.quantity= quantity;
		this.alertlimit= alertlimit;
		this.purchaseprice=purchaseprice;
		this.discountpercentage=discountpercentage;
		this.image=image;
		this.purchasedate=purchasedate;
		this.saledate=saledate;
		this.createdby=createdby;
		this.createdtimestamp=createdtimestamp;
		this.modifiedby=modifiedby;
		this.modifiedtimestamp=modifiedtimestamp;
		
		
		
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


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getItemtype() {
		return itemtype;
	}


	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Long getAlertlimit() {
		return alertlimit;
	}


	public void setAlertlimit(Long alertlimit) {
		this.alertlimit = alertlimit;
	}
	
	
	
	public Long getPurchaseprice() {
		return purchaseprice;
	}


	public void setPurchaseprice(Long purchaseprice) {
		this.purchaseprice = purchaseprice;
	}


	public Long getDiscountpercentage() {
		return discountpercentage;
	}


	public void setDiscountpercentage(Long discountpercentage) {
		this.discountpercentage = discountpercentage;
	}


	public Date getPurchasedate() {
		return purchasedate;
	}
	
	


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}


	public Date getSaledate() {
		return saledate;
	}


	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

		
	/*public static void main(String a[]){
		System.out.println(new Expense(1L,"demouser",new Date(System.currentTimeMillis()),1234.56,"Food"));
	}*/

}
