package com.cos.blogapp.test;

//1.8 람다식
//1 함수를 넘기는게 목적
//2 인터페이스에 함수가 무조건 하나여야함
//3
interface MySupplier{
	void get();
	
}

public class LamdaTest {
	
	static void start(MySupplier s) {
		s.get();
	}
	
	
	public static void main(String[] args) {
		start(() -> {System.out.println("get함수 호출됨");});
	}
}
