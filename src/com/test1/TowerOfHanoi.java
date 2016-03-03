package com.test1;

public class TowerOfHanoi {

	public static void main(String[] args) {		
		move(3,"A","B","C");
	}
	
	public static void move(int n, String source, String temp, String destination) {
		if(n == 1) {
			System.out.println("Move disk 1 from " + source + " to " + destination);
			return;
		}
		
		move(n-1, source, destination, temp);
		System.out.println("Move disk " + n + " from " + source + " to " + destination);
		move(n-1, temp, source, destination);
	}

}
