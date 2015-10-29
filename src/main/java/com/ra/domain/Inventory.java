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
    
    
    public Inventory(){
    }
    
       
    public Inventory(Long id, String itemname,String itemtype,Long quantity,Long alertlimit) {
		super();
		this.id = id;
		this.itemname= itemname;
		this.itemtype= itemtype;
		this.quantity= quantity;
		this.alertlimit= alertlimit;
		
		
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
