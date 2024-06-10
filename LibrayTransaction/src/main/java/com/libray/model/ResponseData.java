package com.libray.model;

import com.libray.libdata.LibrayData;

public class ResponseData {
	
	private LibrayData libdata;
	private BookData bookData;
	private UserData userData;
	
	public ResponseData() {
		System.out.println("ResponseData Started");
	}

	public LibrayData getLibdata() {
		return libdata;
	}

	public void setLibdata(LibrayData libdata) {
		this.libdata = libdata;
	}

	public BookData getBookData() {
		return bookData;
	}

	public void setBookData(BookData bookData) {
		this.bookData = bookData;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
	
	

}
