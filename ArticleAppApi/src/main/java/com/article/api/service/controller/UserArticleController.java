package com.article.api.service.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.article.api.dto.UserDto;
import com.article.api.entity.ArticleEntity;
import com.article.api.model.CreateUserRequestModel;
import com.article.api.service.ArticleService;
import com.article.api.service.UserService;

@RestController
public class UserArticleController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService articleservice;

	@PostMapping("/register")
	public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("New user created");
	}

	@PostMapping("/articles")
	public ResponseEntity<String> createArticle(@Valid @RequestBody ArticleEntity articleDetails) {

		articleservice.createArticle(articleDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body("New article created");
	}

	@GetMapping("/articles")
	public List<ArticleEntity> getAllUsers() {
		return articleservice.getAllArticles();
	}

	@GetMapping("/articles/{pageNo}/{pageSize}")
	public List<ArticleEntity> getAllArticles(@PathVariable int pageNo, @PathVariable int pageSize) {
		return articleservice.getAllArticlesByPageNumber(pageNo, pageSize);
	}
}
