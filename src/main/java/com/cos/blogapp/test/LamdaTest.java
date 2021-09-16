package com.cos.blogapp.test;

//1.8 람다식

interface MySupplier{
	void get();
	
}

public class LamdaTest {
	
	static void start(MySupplier s) {
		s.get();
	}
	
	
	public static void main(String[] args) {
		start(new MySupplier() {
			
			@Override
			public void get() {
				System.out.println("get함수 호출됨");
			}
		});
	}
}
