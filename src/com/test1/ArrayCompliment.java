package com.test1;

import java.util.HashSet;

import java.util.Set;

public class ArrayCompliment {
	public static void main(String[] args) {
		int [] A = {1,8,-3,0,1,3,-2,4,5};		
		System.out.println(solution(6,A));
	}
	
	public static int solution(int K, int[] A) {
        // write your code in Java SE 8
		int compliments = 0;
		if(A.length > 1) {
			/*List<int[]> temp = Arrays.asList(A);
			for(int val: A) {
				int target = K - val;
				if(temp.contains(target)){
					compliments++;
				}
			}*/
			/*for(int i=0; i< A.length; i++) {
				for(int j=0; j<A.length; j++){
					if(A[i] + A[j] == K) {
						compliments++;
					}
				}
			}*/
			
			Set<Integer> set = new HashSet<Integer>(A.length);
			for(int val: A) {
				int target = K- val;
				if(!set.contains(target)){
	                set.add(val);
	                compliments++;
	            }
			}
			//System.out.println(set.size());
		}
		
		return compliments;
    }
}
