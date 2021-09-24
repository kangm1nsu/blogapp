package com.cos.blogapp.handler.ex;

/**
 * @author 사람이름 2021.09.16
 * @param msg
 * 1.id를 못찾았을때 사용
 * 
 */
public class MyAsyncNotFoundException extends RuntimeException{
	
	public MyAsyncNotFoundException(String msg) {
		super(msg);
}
}
