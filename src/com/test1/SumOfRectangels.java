package com.test1;

import java.util.Scanner;

class SumOfRectangels {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			int area = 0;
			int[][] coordinates = new int[N][4];
			for (int j = 0; j < N; j++) {
				int a = s.nextInt();
				coordinates[j][0] = a;
				int b = s.nextInt();
				coordinates[j][1] = b;
				int c = s.nextInt();
				coordinates[j][2] = c;
				int d = s.nextInt();
				coordinates[j][3] = d;
				area += getSum(a, b, c, d);
				if (j > 0) {
					int commonArea = getCommonArea(a, b, c, d, coordinates[j - 1][0], coordinates[j - 1][1],
							coordinates[j - 1][2], coordinates[j - 1][3]);
					area -= commonArea;
				}
			}
			System.out.println(area);
			s.close();
        }
    }
    
    public static int getSum(int a, int b, int c, int d){		
		return (c-a) * (d-b);
	}
	
	public static int getCommonArea(int K, int L, int M, int N, int P, int Q, int R, int S) {
		int intersectArea = 0;
		if (K < R && M > P && L < S && N > Q) {
			int x1 = Math.max(K, P);
			int x2 = Math.min(M, R);
			int y1 = Math.max(L, Q);
			int y2 = Math.min(N, S);
			intersectArea = ((x2 - x1) * (y2 - y1));
		}
		return intersectArea;
	}
}
