package com.lesson9.maximumsliceproblem;

import java.util.Arrays;

import org.junit.Test;

public class MaxDoubleSliceSum {

	@Test
	public void Correctness(){
		
		int [][] AA = { 
				 {3,2,6,-1,4,5,-1,2} // 5
				  
		};
		
		for(int []A : AA){
			System.out.println(new MaxDoubleSliceSum().solution(A));
		}
		
	}
	
	
	public int solution(int[] A){
		
		long [] maxSliceLeft = new long[A.length];
		long maxEnding = 0;
		long maxSlice = 0;
		for(int i=1;i<A.length-1;i++){
			maxEnding = Math.max(0, maxEnding+A[i]);
			maxSlice = Math.max(maxEnding, maxSlice);
			maxSliceLeft[i] = maxSlice;
		}
		
		long [] maxSliceRight = new long[A.length];
		maxEnding = 0;
		maxSlice = 0;
		for(int i=A.length-2;i>0;i--){
			maxEnding = Math.max(0, maxEnding+A[i]);
			maxSlice = Math.max(maxEnding, maxSlice);
			maxSliceRight[i] = maxSlice; 
		}
		
		int maxDoubleSlice = 0;
		for(int i=1;i<A.length-1;i++){
			maxDoubleSlice = (int)Math.max(maxDoubleSlice, maxSliceLeft[i-1]+maxSliceRight[i+1]);
			
		}
		
		return maxDoubleSlice;
	}
	
	
	
}
