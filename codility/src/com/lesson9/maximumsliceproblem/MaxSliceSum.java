package com.lesson9.maximumsliceproblem;

import org.junit.Test;

public class MaxSliceSum {

	@Test
	public void Correctness(){
		
		int [][] AA = { 
				  {3,2,-6,4,0} // 5
//				, {10} // 10
//				, {-10, -10} // -10
//				, {10,2} // 12
				, {-10,10,-1, 2} // 11
		};
		
		for(int []A : AA){
			System.out.println(new MaxSliceSum().solution(A));
		}
		
	}
	
	
	public int solution(int[] A){
		
		int maxSlice 	= A[0];
		int maxEnd		= A[0]; 
		
		for(int i=1;i<A.length;i++){
			
			int a = A[i];
			
			/*
			if(maxSlice==Integer.MIN_VALUE){
				maxSlice = a;
			}
			*/
			
			if(maxSlice < maxSlice + maxEnd + a){
				maxSlice = maxSlice + maxEnd + a;
			}
			
			if(maxSlice < maxEnd + a){
				maxSlice = maxEnd + a;
			}
			
			if(maxSlice < a){
				maxSlice = a;
			}
			
			maxEnd += a;
			
		}
		
		return maxSlice;
		
	}
}
