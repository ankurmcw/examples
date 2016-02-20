package com.test1.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.test1.StringOccurrence;

public class StringOccurrenceTest {

	@Test
	public void test() {
		StringOccurrence.printSumOfOccurrence("aabcaabc");
		assertTrue("This will throw an error", false);
	}

}
