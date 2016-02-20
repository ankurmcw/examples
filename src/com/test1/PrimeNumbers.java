package com.test1;

public class PrimeNumbers {

	public static void main(String[] args) {
		PrimeNumbers.printPrimeNumber(100);
	}

	private static void printPrimeNumber(int range) {
		int numOfLoop = 1;
		for(int i=2; i<= range; i++) {
			boolean flag = true;
			for (int j = 2; j < i/2; j++) {
				numOfLoop ++;
				xyz:
				if(i%j==0) {
					flag = false;
					break xyz;
				}
			}
			if(flag) {
				System.out.print(i+ ", ");
			}
		}
		System.out.println();
		System.out.println(numOfLoop);
	}
}
