package com.cos.blogapp.domain.board;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cos.blogapp.domain.comment.Comment;
import com.cos.blogapp.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 50)
	private String title;
	@Lob
	private String Content;
	@JoinColumn(name="userId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	//양방향 매핑
	//﻿mappedBy fk의 주인의 변수이름을 추가한다
	@JsonIgnoreProperties({"board"})// comment 객체 내부의 필드를 제외시키는 방법 data를 리턴할때 필요한것
	@OneToMany(mappedBy = "board",fetch = FetchType.LAZY)
	@OrderBy(value = "id asc")
	private List<Comment> comments;

	
}
