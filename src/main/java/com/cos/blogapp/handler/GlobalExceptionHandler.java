package com.cos.blogapp.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.handler.ex.MyNotFoundException;
import com.cos.blogapp.util.Script;
import com.cos.blogapp.web.dto.CMRespDto;

//@ControllerAdvice 1.익셉션 핸들링 2. @Controller의 역할까지 한다
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MyNotFoundException.class)
	public @ResponseBody String error1(MyNotFoundException e) {
		System.out.println("오류터졌어 : " + e.getMessage());
		return Script.href("/", e.getMessage());
	}
	
	@ExceptionHandler(value = MyNotFoundException.class)
	public @ResponseBody CMRespDto<String> error2(MyNotFoundException e) {
		System.out.println("오류터졌어 : " + e.getMessage());
		return new CMRespDto<String>(-1,e.getMessage(),null);
	}
}
