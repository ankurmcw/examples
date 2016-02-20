package com.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line=br.readLine()) != null) {
			containsAllAlphabets(line);
		}
		br.close();
	}
	
	private static void containsAllAlphabets(String sentence) {
		String regex = "/^[a-z]+$";
		Pattern patter = Pattern.compile(regex);
		Matcher matcher = patter.matcher(sentence);
		if(matcher.matches()) {
			System.out.println("Contains all character");
		} else {
			System.out.println("Does not contains all character");
		}
	}

}
