package com.book.model;

import java.sql.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class BookData {
	
    @Id
    private int id;
    private String title;
    private String author;
    private Date publishedDate;
    private String status;
    
	public BookData() {
		System.out.println("Books Executed");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
