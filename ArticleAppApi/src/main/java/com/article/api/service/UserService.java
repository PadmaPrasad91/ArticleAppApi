package com.article.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.article.api.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);
	UserDto getUserByUsername(String username);
}
