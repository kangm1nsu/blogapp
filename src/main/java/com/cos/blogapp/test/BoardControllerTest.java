package com.cos.blogapp.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blogapp.domain.board.Board;
import com.cos.blogapp.domain.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardControllerTest {

	private final BoardRepository boardRepository;
	
	@GetMapping("/test/board/{id}")
	public Board detail(@PathVariable int id) {
		//영속성 컨텍스트 = Board(User 있음, List<comment>
		Board boardEntity = boardRepository.findById(id).get();
		System.out.println(boardEntity); //객체를 호출하면 자동으로toString()함수가 호출된다
		return boardEntity;
	}
}
