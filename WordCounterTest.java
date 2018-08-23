package com.yash.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.yash.controller.WordCounter;

public class WordCounterTest {

	private WordCounter wordCounterController = new WordCounter();

	private Map<String, Integer> getExpectedUniqueWordMap() {
		Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
		expectedWordCount.put("boom", 2);
		expectedWordCount.put("bang", 1);
		return expectedWordCount;
	}

	@Test
	public void shouldReturnCountOfUniqueWordWhenPassDelimitedString() {
		Map<String, Integer> expectedWordCount = getExpectedUniqueWordMap();
		Map<String, Integer> mapUniqueWordCount = wordCounterController.getUniqueWordWithCount("boom,@bang,@boom");
		Assert.assertEquals(expectedWordCount, mapUniqueWordCount);

	}

}
