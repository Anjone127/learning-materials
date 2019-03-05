package com.anjone.spring.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
	volatile static Integer i =2;

	private ThreadLocal<Integer> a = new ThreadLocal<Integer>();

	public static void main(String[] args){
		new Test().a();
	}

	public void a(){
		b();
	}
	public void b(){
		System.out.println(a.get());
	}
}
