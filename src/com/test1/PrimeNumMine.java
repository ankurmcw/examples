package com.test1;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumMine {

	public static void main(String[] args) {
		PrimeNumMine.printPrimeNumbers(11);

	}

	private static void printPrimeNumbers(int range) {
		List<Integer> primeNums = new ArrayList<Integer>();
		int numOfLoop = 0;
		for (int i = 2; i <= range; i++) {			
			int j = 2;
			boolean flag = true;
			do {
				numOfLoop++;
				if (i == j) {
					primeNums.add(i);
					flag = false;
				} else if (i % j == 0) {
					flag = false;
					break;
				}
				j++;
			} while (j < i);
			if (flag) {
				primeNums.add(i);
			}			
		}
		System.out.println(primeNums);
		System.out.println(numOfLoop);
	}
}