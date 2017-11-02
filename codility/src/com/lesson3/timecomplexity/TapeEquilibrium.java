package com.lesson3.timecomplexity;

public class TapeEquilibrium {

	public static void main(String [] args){
		
		int [] A = {3,1,2,4,3};
		
		System.out.println( new TapeEquilibrium().solution(A) );
	}


	public int solution(int[] A){
		
		int totSum	 = 0;
		int minDif 	= 9999;
		int sumA 	= 0;
		int sumB 	= 0;
		
		for(int i:A){
			totSum += i;
		}
		
		for(int i=0;i<A.length;i++){
			if(i>0){
				sumB = totSum - sumA;
				int dif = Math.abs(sumA-sumB); 
				if(dif<minDif){
					minDif = dif;
				}
			}
			sumA += A[i];
		}
		
		return minDif;
	}
	
	
}
