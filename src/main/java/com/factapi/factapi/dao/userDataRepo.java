package com.factapi.factapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factapi.factapi.factentities.usersData;

@Repository
public interface userDataRepo extends JpaRepository<usersData, String>{
}
