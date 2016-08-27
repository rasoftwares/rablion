package com.ra.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity

public class Article {
	public Article() {
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publishdate", nullable = false)
    private Date publishdate;
   
    @Column(name = "content", nullable = false)
    private String content;
    
    @Column(name = "category", nullable = false)
    private String category;
    
    @Column(name = "type", nullable = false)
    private String type;
     
    @Column(name = "item", nullable = false)
    private String item;
    
    @Column(name = "summary", nullable = false)
    private String summary;
    
    
    public Article(Long id, String title,Date publishdate,String content,String category,String type,String item,String summary) {
		super();
		this.id = id;
		this.title=title;
		this.publishdate=publishdate;
		this.content=content;
		this.category=category;
		this.type=type;
		this.item=item;
		this.summary=summary;
		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}
}