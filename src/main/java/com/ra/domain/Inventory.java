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

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "type", nullable = false)
    private String type;
    
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    
    @Column(name = "alertlimit", nullable = false)
    private Long alertlimit;
    
    @Column(name = "price", nullable = false)
    private Long price;
    
    @Column(name = "discount", nullable = false)
    private Long discount;
    
  
    
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
    
       
    public Inventory(Long id, String name,String type,Long quantity,Long alertlimit,Long price,Long discount,String image,String createdby,Date createdtimestamp,String modifiedby,Date modifiedtimestamp) {
		super();
		this.id = id;
		this.name= name;
		this.type= type;
		this.quantity= quantity;
		this.alertlimit= alertlimit;
		this.price=price;
		this.discount=discount;
		this.image=image;
	
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
	
	
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getDiscount() {
		return discount;
	}


	public void setDiscount(Long discount) {
		this.discount = discount;
	}


	
	


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
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
