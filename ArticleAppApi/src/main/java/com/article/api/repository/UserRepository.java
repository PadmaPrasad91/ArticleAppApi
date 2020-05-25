package com.article.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.article.api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUsername(String username);
}
