package com.test1;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int [] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = s.nextInt();
		}
		int Q = s.nextInt();
		for(int j=0; j<Q; j++) {
			if(s.nextInt() == 1) {
				arr[s.nextInt()-1] = s.nextInt();
			} else {
				System.out.println(getLCM(s.nextInt(), s.nextInt()));
			}
		}
		s.close();
	}
	
	public static int getLCM(int a, int b) {
		int max = a>b?a:b;
		int min = a<b?a:b;
		int x = 1;
		int lcm = 1;
		for(int i=1;i<=min;i++) {
			x=max*i;
			if(x%min==0){
				lcm = x;
				break;
			} else {
				
			}
		}
		return lcm;
	}

}
