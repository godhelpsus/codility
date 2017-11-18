package com.lesson9.maximumsliceproblem;

import org.junit.Test;

public class MaxSliceSum {

	@Test
	public void Correctness(){
		
		int [][] AA = { 
				  {3,2,-6,4,0} // 5
				, {10} // 10
				, {-10, -10} // -10
				, {10,2} // 12
				, {-10,10,-1, 2} // 11
		};
		
		for(int []A : AA){
			System.out.println(new MaxSliceSum().solution(A));
		}
		
	}
	
	
	public int solution(int[] A){
		
		int max 	= Integer.MIN_VALUE;
		
		// 최대값 구하기
		for(int a:A){
			max = a>max?a:max;
		}
		
		// 모두 음수인경우 최대값이 maxSliceSum이 된다.
		if(max < 0){
			return max; 
		}
		
		int maxSliceSum = 0;
		int currentSum = 0;
		
		for(int i=0;i<A.length;i++){
			
			int a = A[i];
			
			currentSum = currentSum + a;
			if(currentSum < 0){ // 음수가 되어버리는 경우, 현재 구한 최대값보다 커질수가 없다
				currentSum = 0;
			}
			
			maxSliceSum =  currentSum > maxSliceSum ? currentSum : maxSliceSum;
			
		}
		
		return maxSliceSum;
		
	}
}
