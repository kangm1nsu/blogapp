package com.cos.blogapp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.blogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinReqDto {
	@NotBlank
	@Size(min = 2, max = 20)
	private String username;
	@NotBlank
	@Size(min = 4, max = 20)
	private String password;
	@NotBlank
	@Size(min = 4, max = 50)
	private String email;
	
	public User toEntity() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}
}
