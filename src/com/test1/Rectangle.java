package com.test1;

public class Rectangle {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

	public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
		// write your code in Java SE 8
		
		int area1 = (Math.abs(K-M) * Math.abs(L-N));
		int area2 = (Math.abs(P-R) * Math.abs(Q-S));
		int totalArea = area1 + area2;
		
		if(K < R && M > P && L < S && N > Q) {
			int x1 = Math.max(K, P);
			int x2 = Math.min(M, R);
			int y1 = Math.max(L, Q);
			int y2 = Math.min(N, S);
			int intersectArea = (Math.abs(x2 - x1) * Math.abs(y2 - y1));
			totalArea = totalArea - intersectArea;
		}
		if(totalArea > Integer.MAX_VALUE) {
			totalArea = -1;
		}
		return totalArea;
	}

}
