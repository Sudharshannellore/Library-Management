package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.model.BookData;

@Repository
public interface BookRepo extends JpaRepository<BookData, Integer> {

}
