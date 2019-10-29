package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Serializable> {
	
	@Query("select email from UserEntity")
	public List<UserEntity> getAllEmails();

	@Query("select email from UserEntity where userId=:uid")
	public String getEmailById(Integer uid);
	
	
}
