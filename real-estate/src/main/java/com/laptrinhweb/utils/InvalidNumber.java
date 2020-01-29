package com.laptrinhweb.utils;

public class InvalidNumber extends Exception{

	private static final long serialVersionUID = 1L;
	public InvalidNumber(String message) {
		super(message);//super: gọi hàm dựng của Exception->là lớp cha nó thừa kế
	}
}
