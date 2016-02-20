package com.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test5 {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			findPossibleGain(line);
		}
		buffer.close();
		
	}
	
	private static void findPossibleGain (String line) {

		String[] tempArr1 = line.split(";");
		int noOfDays = 0;
		if(tempArr1.length == 2) {
			noOfDays = Integer.valueOf(tempArr1[0]);
		}
		if(noOfDays > 0) {
			String [] profitPerDay = tempArr1[1].split(" ");
			if(profitPerDay.length > 0) {
				int max_score = 0;				
				for(int i=0; i<(profitPerDay.length - noOfDays + 1); i++) {
					int sum = 0;
					for(int j=i; j<noOfDays +i; j++) {						
						sum += Integer.valueOf(profitPerDay[j]);
					}					
					if(sum > max_score) {
						max_score = sum;
					}
				}			
				System.out.println(max_score);
				
			}
		}
	
	}

}
