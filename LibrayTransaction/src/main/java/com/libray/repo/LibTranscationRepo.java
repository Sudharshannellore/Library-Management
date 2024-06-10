package com.libray.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libray.libdata.LibrayData;

@Repository
public interface LibTranscationRepo extends JpaRepository<LibrayData, Integer> {

}
