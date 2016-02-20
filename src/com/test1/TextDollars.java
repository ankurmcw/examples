package com.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextDollars {
	
	private static String [] onesArray = {"Zero", "One" ,"Two", "Three", "Four", "Five" ,"Six", "Seven", "Eight", "Nine"};
	private static String [] twosArray = {"Ten" ,"Eleven", "Tweleve", "Thirteen", "Fourteen" ,"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static String [] twentiesArray = {"Twenty" ,"Thirty", "Forty", "Fifty", "Sixty" ,"Seventy", "Eighty", "Ninety"};
	private static String [] hundredsArray = {"Hundred" ,"Thousand", "Million", "Billion"};
	private static StringBuilder textDollar = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String number;
		while ((number = buffer.readLine()) != null) {
			number = number.trim();
			if(Long.valueOf(number) == 0) {
				textDollar.append(onesArray[0]);
			} else {
				printDollars(Long.valueOf(number));
			}			
			System.out.println(textDollar.append("Dollars"));
			textDollar.delete(0, textDollar.length());
		}
		buffer.close();		
	}
	
	private static void printDollars(long number) {		
		if(number > 0 && number < 1_000_000_000) {
			if(number < 10) {
				// numbers between 1 to 9
				textDollar.append(onesArray[(int)(number%10)]);
			} else if (number < 20) {
				// numbers between 10 to 19
				textDollar.append(twosArray[(int)(number%10)]);
			} else if (number < 100) {
				// numbers between 20 to 99
				textDollar.append(twentiesArray[(int)(number/10 - 2)]);
				printDollars(number%10);
			} else if (number < 1000) {
				// numbers between 100 to 999
				printDollars(number/100);
				textDollar.append(hundredsArray[0]);
				printDollars(number%100);
			} else if (number < 10000) {
				// numbers between 1000 to 9999
				printDollars(number/1000);
				textDollar.append(hundredsArray[1]);
				printDollars(number%1000);
			} else if (number < 100_000) {
				// numbers between 10000 to 99999
				printDollars(number/1000);
				textDollar.append(hundredsArray[1]);
				printDollars(number%1000);
			} else if (number < 1_000_000) {
				// numbers between 100000 to 999999
				printDollars(number/1000);
				textDollar.append(hundredsArray[1]);
				printDollars(number%1000);
			} else if (number < 10_000_000) {
				// numbers between 1000000 to 9999999
				printDollars(number/1000000);
				textDollar.append(hundredsArray[2]);
				printDollars(number%1000000);
			} else if (number < 100_000_000) {
				// numbers between 10000000 to 99999999
				printDollars(number/1000000);
				textDollar.append(hundredsArray[2]);
				printDollars(number%1000000);
			} else if (number < 1_000_000_000) {
				// numbers between 100000000 to 999999999
				printDollars(number/1000000);
				textDollar.append(hundredsArray[2]);
				printDollars(number%1000000);
			}
		}
	}
}