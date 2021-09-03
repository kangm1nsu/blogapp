package com.cos.blogapp.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//테이블 모델

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //table을 만들어줌
public class User {
	@Id  //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY DB에 맞춰 숫자 증가
	private int id; //PK (자동증가 번호)
	private String username; //아이디
	private String password;
	private String email;
}
