package com.yash.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
	private String stringRegx = "[,][$&+,:;=?@#|\\s]";

	public Map<String, Integer> getUniqueWordWithCount(String delimitedString) {
		Pattern regex = Pattern.compile(stringRegx);
		Matcher matcher = regex.matcher(delimitedString);

		String delimString = matcher.find() ? matcher.group(0) : "";

		List<String> inputStringArray = Arrays.asList(delimitedString.split(delimString));

		return inputStringArray.parallelStream().filter(x -> x != "")
				.collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
	}
}
