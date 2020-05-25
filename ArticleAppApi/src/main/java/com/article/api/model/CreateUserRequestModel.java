package com.article.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CreateUserRequestModel {

	@NotNull(message = "username cannot be empty")
	private String username;

	@NotNull(message = "password cannot be empty")
	private String password;

	@NotNull(message = "email cannot be empty")
	@Email
	private String email;

	@NotNull(message = "address cannot be empty")
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
