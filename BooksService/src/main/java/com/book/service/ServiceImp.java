package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.BookData;
import com.book.repo.BookRepo;

@Service
public class ServiceImp {

	@Autowired
	private BookRepo repo;
	
	public BookData save(BookData data) {
		return repo.save(data);
	}
	
	public BookData get(int id) {
        return repo.findById(id).get();		
	}
	public void delete(int id) {
       repo.deleteById(id);;		
	}
	
	public BookData update(int id, BookData data) {
		
		BookData old = repo.findById(id).get();
		
		old.setTitle(data.getTitle());
		old.setAuthor(data.getAuthor());
		old.setPublishedDate(data.getPublishedDate());
		old.setStatus(data.getStatus());
		
		return repo.save(old);
	}
}
