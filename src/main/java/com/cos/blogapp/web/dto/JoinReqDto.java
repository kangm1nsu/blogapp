package com.cos.blogapp.web.dto;

import javax.validation.constraints.NotBlank;

import com.cos.blogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinReqDto {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	
	public User toEntity() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}
}
