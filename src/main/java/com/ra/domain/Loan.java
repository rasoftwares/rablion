package com.ra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "loanno", nullable = false)
    private String loanno;
	
	@Column(name = "customername", nullable = false)
    private String customername;
	
	 @Column(name = "amount", nullable = false)
	    private double amount;
		
	 @Column(name = "totalweight", nullable = false)
	    private double totalweight;
		
	 @Column(name = "item", nullable = false)
	    private String item;
		
	 @Column(name = "action", nullable = false)
	    private String action;
	 
	 
	 public Loan(Long id,String loanno, String customername, double amount,
				Long totalweight, String item, String action) {
			super();
			this.id = id;
			this.loanno = loanno;
			this.customername = customername;
			this.amount = amount;
			this.totalweight = totalweight;
			this.item = item;
			this.action = action;
		}

		public Loan() {
			
		}

		public Long getid() {
			return id;
		}

		public void setid(Long id) {
			this.id = id;
		}

		public String getLoanno() {
			return loanno;
		}

		public void setLoanno(String loanno) {
			this.loanno = loanno;
		}

		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public double getTotalweight() {
			return totalweight;
		}

		public void setTotalweight(double totalweight) {
			this.totalweight = totalweight;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

}
	
	
			
	
	