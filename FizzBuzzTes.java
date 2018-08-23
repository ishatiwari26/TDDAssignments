package com.yash.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.yash.controller.FizzBuzz;

public class FizzBuzzTes {
	FizzBuzz fizzBuzzController = new FizzBuzz();

	@Test
	public void shouldReturnFizzIfNumberDividedByThree() {
		Assert.assertEquals("Fizz", fizzBuzzController.getDivisionOfNumber(9));
	}

	@Test
	public void shouldReturnBuzzIfNumberDividedByFive() {
		assertEquals("Buzz", fizzBuzzController.getDivisionOfNumber(35));
	}

	@Test
	public void shouldReturnFizzBuzzIfNumberDividedByThreeAndFive() {
		assertEquals("FizzBuzz", fizzBuzzController.getDivisionOfNumber(30));
	}

	@Test
	public void shouldReturnSameNumberIfNumberDividedByAnyNumber() {
		assertEquals("11", fizzBuzzController.getDivisionOfNumber(11));
	}

}
