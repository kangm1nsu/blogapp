package com.cos.blogapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

@Controller
public class UserController {

	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/test/query/join")
	public void testQueryJoin(){
		
		userRepository.join("ssar","1234","ssar@naver.com");
	}
	
	@GetMapping("/test/join")
	public void testJoin(){
		User user = new User();
		user.setUsername("ssar");
		user.setPassword("1234");
		user.setEmail("ssar@nate.com");
		
		//insert into user(username, password, email) values('ssar', '1234', 'ssar@nate.com');
		userRepository.save(user);
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		//()안에는변수로 받을수도 있고 오브젝트로 받을수도있음
		
		System.out.println(dto.getUsername());
		System.out.println(dto.getPassword());
		//1.username,password 받기 (매개변수에 변수만넣어도 request.getParameter)
		//2.DB 조회
		//3.있으면
		//4.session에 저장
		//5.메인페이지를 돌려주기
		return "home";
	}
	
	@PostMapping("/join")
	public String join(JoinReqDto dto) {// username=love&password=1234&email=love@nate.com
		User user = new User();
		
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		
		userRepository.save(user);
		
		return "redirect:/loginForm"; //리다이렉션(300)
	}
	
}
