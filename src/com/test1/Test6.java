package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			String[] binaries = s.split(" ");
			if (binaries.length == 2) {
				System.out.println(addBinaryNumbers(binaries[0], binaries[1]));
			}
		}		
	}

	public static String addBinaryNumbers(String binary1, String binary2) {
		return Integer.toBinaryString(Integer.parseInt(binary1, 2) + Integer.parseInt(binary2, 2));
	}

}
