package com.lesson9.maximumsliceproblem;

import org.junit.Test;

public class MaxProfit {

	
	@Test
	public void Correctness(){
		
		int [][] AA = {
				  {} // 0
				, {1} // 0
				, {40, 20, 30, 5} // 10
				, {23171,21011,21123,21366,21013,21367} // 356
				, {1,2,3,4} // 3
				, {4,3,2,1} // 0
				, {4,3,2,1,2} // 1
				, {4,3,2,10,20,2} // 18
				, {4,30,2,10,20,2} // 26
		};
		
		for(int []A : AA){
			System.out.println(new MaxProfit().solution(A));
		}
		
	}
	
	public int solution(int[] A){

		int maxProfit = 0 ;
		int minPrice1 = 0;
		
		if(A.length>0) minPrice1 = A[0];
		
		for(int i=1;i<A.length;i++){

			int price1 = A[i-1];
			int price2 = A[i];
			
			if(price1 < minPrice1){
				minPrice1 = price1;
			}
			
			int profit = price2 - minPrice1; 
			if(profit>0){
				if(profit > maxProfit){
					maxProfit = profit;
				}
			}
		}
		
		return maxProfit;
	}
	
}
