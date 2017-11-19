package com.test;


import java.util.Arrays;

import org.junit.Test;


public class TestBeforeSKT {
	
	
	@Test
	public void Correctness(){
		
		int [][] AA = {
				  {1,2,3} // 4
				, {-1,-3} // 1
				, {1,3,6,4,1,2} // 5
				, {0,0,10,0,0,-5,-5,-9} // 1
				, {1,2,3,4,8,5,7} // 6
		};
		
		for(int []A : AA){
			System.out.println(new TestBeforeSKT().solution(A));
		}
		
	}
	
	
	// solution
	public int solution(int[] A){
		
		Arrays.sort(A);
		
		int s = 1; // smallest positive integer 
		
		for(int a : A){
			if(a == s){
				s++;
			}
		}
		
		return s;
	}
}
