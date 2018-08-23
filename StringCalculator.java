package com.yash.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCalculator {
	private Logger log = LoggerFactory.getLogger(StringCalculator.class);

	private int resultVal = 0;
	private List<Integer> negativeNumbers = new ArrayList<Integer>();
	private List<Integer> positiveNumbers = new ArrayList<Integer>();

	public int sumOfStrings(String input) {
		String delimString = ",|\n";
		String searchString = input;
		Pattern p = Pattern.compile("^//(.+)\\n(.*)$");
		Matcher m = p.matcher(input);
		delimString = m.matches() ? m.group(1) : delimString;
		searchString = m.matches() ? m.group(2) : searchString;
		return addInputStringByDelimiter(searchString, delimString);
	}

	private int addInputStringByDelimiter(String inputString, String delimiter) {
		log.info("Sum Method Of String Calculator.");
		List<String> inputStringArray = Arrays.asList(inputString.split(delimiter));

		resultVal = inputStringArray.get(0).isEmpty() ? 0
				: inputStringArray.stream().map(s -> Integer.parseInt(s)).filter(x -> x <= 1000)
						.mapToInt((i) -> Integer.valueOf(i)).sum();
		if (resultVal > 0)
			inputStringArray.stream().map(s -> Integer.parseInt(s))
					.forEach(i -> (i < 0 ? negativeNumbers : positiveNumbers).add(i));
		if (negativeNumbers.size() > 0)
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		return resultVal;
	}

}
