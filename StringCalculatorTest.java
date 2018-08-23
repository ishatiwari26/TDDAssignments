package com.yash.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.yash.controller.StringCalculator;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock
	Logger logger;

	@InjectMocks
	StringCalculator stringCalculator;

	@Test
	public void sholudReturnZeroWhenInputIsEmptyString() {
		assertEquals(0, stringCalculator.sumOfStrings(""));
	}

	@Test
	public void sholudReturnSameValueWhenInputIsDigit() {
		assertEquals(1, stringCalculator.sumOfStrings("1"));
	}

	@Test
	public void sholudReturnSumOfTwoValuesWhenPassTwoDigits() {
		assertEquals(9, stringCalculator.sumOfStrings("3,6"));
	}

	@Test
	public final void sholudReturnSumOfAllValuesWhenPassAnyNumberOfDigits() {
		assertEquals(6, stringCalculator.sumOfStrings("1,2,3"));
	}

	@Test
	public final void whenNewLineAsSapraterThenReturnValuesAreTheirSums() {
		assertEquals(6, stringCalculator.sumOfStrings("1\n2,3"));
	}

	@Test
	public final void whenCustomDilimeterAsSapraterThenReturnSumOfThem() {
		assertEquals(3, stringCalculator.sumOfStrings("//;\n1;2"));
	}

	@Test
	public final void whenDigitMoreThan1000ThenIgnoreItAndSumOfOtherDigits() {
		assertEquals(1009, stringCalculator.sumOfStrings("3,1000,1001,6"));
	}

	@Test
	public void shouldCallWhileCallSumOfStringOfStringCalculator() {
		Mockito.doNothing().when(logger).info("Sum Method Of String Calculator.");
		stringCalculator.sumOfStrings("3,1000,1001,6");
		Mockito.verify(logger).info("Sum Method Of String Calculator.");

	}

	@Test
	public void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		exception.expect(RuntimeException.class);

		stringCalculator.sumOfStrings("3,-6,15,18,46,33");
	}

	@Test
	public void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			stringCalculator.sumOfStrings("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		assertNotNull(exception);
		assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}

}
