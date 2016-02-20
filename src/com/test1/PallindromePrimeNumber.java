package com.test1;

public class PallindromePrimeNumber {
	
	public static void main(String[] args) {
		int limit = 999;
		for(int i=limit ; i>=2 ; i--) {
			boolean flag = true;
			if((i/100) == (i%10)) {
				xyz:
				for(int j=2; j<i/2; j++) {					
					if(i%j == 0) {
						flag = false;
						break xyz;
					}
				}
			} else {
				flag = false;
			}
			if(flag) {
				System.out.println(i);
				break;
			}
		}
	}
}