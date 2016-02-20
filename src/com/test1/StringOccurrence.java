package com.test1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class StringOccurrence {

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			StringOccurrence.printSumOfOccurrence(line);
		}
		br.close();
	}

	public static void printSumOfOccurrence(String input) {
		int sum = input.length();
		for (int i = 1; i < input.length(); i++) {
			String subStr = input.substring(i);
			int count = 0;
			if (subStr.charAt(0) == input.charAt(0)) {
				xyz: if (subStr.length() == 1) {
					count = 1;
				} else {
					count = 1;
					for (int j = 1; j < subStr.length(); j++) {
						if (subStr.charAt(j) == input.charAt(j)) {
							count++;
						} else {
							break xyz;
						}
					}
				}
			}
			System.out.println(input + " : " + subStr + " : " + count);
			sum += count;
		}
		System.out.println(sum);
	}
}
