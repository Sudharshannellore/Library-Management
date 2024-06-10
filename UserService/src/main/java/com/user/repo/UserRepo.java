package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.model.UserData;

@Repository
public interface UserRepo extends JpaRepository<UserData, Integer> {

}
