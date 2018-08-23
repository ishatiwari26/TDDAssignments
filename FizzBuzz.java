package com.yash.controller;

import java.util.Optional;

public class FizzBuzz {

	public String getDivisionOfNumber(int input) {

		String result = Optional.of(input).map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "")).get();

		return result.isEmpty() ? Integer.toString(input) : result;
	}
}
