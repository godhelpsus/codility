package com.lesson6.sorting;

import java.util.Arrays;

import org.junit.Test;

public class MaxProductOfThree {

	@Test
	public void Correctness(){

		int [][] A = {
			  {-3, 1, 2, -2, 5, -6} // 60
			 ,{-1, 2, 5, 2, -7} // 
		};
		
		for(int idx=0 ; idx<A.length ; idx++){
			String str = "answer = "+new MaxProductOfThree().solution(A[idx]);
			System.out.println(str);
		}
	}
	
	public int solution(int [] A){
		Arrays.sort(A);
		int max = Integer.MIN_VALUE;
		int size = A.length;
		for(int i=0;i<size-2;i++){
			int a = A[i];
			int b = A[i+1];
			int c = A[i+2];
			
			int m = a*b*c;
			if(max<m){
				max=m;
			}
			
			if(a<0&&b<0){
				m = a*b*A[size-1];
				if(max<m){
					max=m;
				}	
			}
			
		}
		return max;
	}
	
	
	
}
