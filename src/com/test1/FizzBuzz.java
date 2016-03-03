package com.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		long startTime = System.currentTimeMillis();		
		while ((line = buffer.readLine()) != null) {
			line = line.trim();						
			printFB(line);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(startTime + " : " + endTime);
		System.out.println(endTime - startTime);
		buffer.close();
	}

	public static void printFB(String line) {
		String[] tempArr = line.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= Integer.valueOf(tempArr[2]); i++) {

			boolean flag = false;
			if (i % Integer.valueOf(tempArr[0]) == 0) {
				sb.append("F");
				flag = true;
			}

			if (i % Integer.valueOf(tempArr[1]) == 0) {
				sb.append("B");
				flag = true;
			}

			if (!flag) {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
