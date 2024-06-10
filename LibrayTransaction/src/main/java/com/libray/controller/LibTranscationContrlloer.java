package com.libray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.libray.libdata.LibrayData;
import com.libray.model.BookData;
import com.libray.model.ResponseData;
import com.libray.model.UserData;
import com.libray.repo.LibTranscationRepo;

@RestController
@RequestMapping("/transcation")
public class LibTranscationContrlloer {

  @Autowired
  private RestTemplate template;	
  
  @Autowired
  private LibTranscationRepo repo;
  
  
  @PostMapping("/save")
  public LibrayData  save(@RequestBody LibrayData data) {
	return repo.save(data);
  }
  
  
  @GetMapping("/get/{transcationId}")
  public ResponseData get(@PathVariable int transcationId) {
	  
	  LibrayData data = repo.findById(transcationId).get();
	  ResponseData responseData = new ResponseData();
	  responseData.setLibdata(data);  
	  BookData bookData = template.getForObject("http://BOOKSSERVICE/book/get/"+data.getBookId(), BookData.class);
	  responseData.setBookData(bookData);
	  UserData userData = template.getForObject("http://USERSERVICE/user/get/"+data.getUserId(), UserData.class);
	  responseData.setUserData(userData);
	  
	  return responseData;
  }
  
  @DeleteMapping("/delete/{transcationId}")
  public String delete(@PathVariable int transcationId) {
	repo.deleteById(transcationId);
	return transcationId+" Deleted Succesfull";
  }
  
  @PutMapping("/update/{transcationId}")
  public LibrayData update(@PathVariable int transcationId, @RequestBody LibrayData data) {
	LibrayData old = repo.findById(transcationId).get();
	
	old.setBookId(data.getBookId());
	old.setUserId(data.getUserId());
	old.setIssuedDate(data.getIssuedDate());
	old.setReturnDate(data.getReturnDate());
	old.setStatus(data.getStatus());
	
	return repo.save(old);
}
  
}
