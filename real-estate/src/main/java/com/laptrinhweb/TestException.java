package com.laptrinhweb;

import com.laptrinhweb.utils.InvalidNumber;

public class TestException {
	public void calculate(Integer num1, Integer num2) throws InvalidNumber{
		Double result = null;
		if (num2 == 0) {
			throw new InvalidNumber("Không thể thực hiện phép chia cho không");
		} else {
			result = (double) (num1/num2);
		}
		System.out.println(result);
		
	}
}
