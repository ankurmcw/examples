package com.test1;

public class FibonacciSeries {

	public static void main(String[] args) {
		int f0 = 0;
		int f1 = 1;
		System.out.print(f0 + " " + f1 + " ");
		for(int i=0; i< 10; i++) {
			int number = f0 + f1;
			System.out.print(number + " ");
			f0 = f1;
			f1 = number;
		}
	}

}
