package com.lesson5.prefixsums;

import org.junit.Test;

public class PassingCars {

	
	private final int MAX = 1000000000;
	
	@Test
	public void test(){
		
		//int [] A = {0,1,0,1,1};
		int [] A = new int[100000];
		for(int i=0;i<A.length;i++){
			A[i] = ((int)(Math.random()*10))%2;
		}
		
		long s = System.currentTimeMillis();
		System.out.println( "answer : "+new PassingCars().solution(A) );
		System.out.println((System.currentTimeMillis()-s)+" msec");
	}
	
	public int solution(int[] A){
		int cnt = 0;
		MYLOOP:for(int i=0;i<A.length;i++){
			
			int a = A[i];
			
			for(int j=i+1;j<A.length;j++){
				
				int b = A[j];
				
				if(a-b==-1){
					cnt++;
				}
				
				//if(cnt>1000000000){
				/*
				if(cnt>MAX){
					cnt=-1;
					break MYLOOP;
				}
				*/
				
			}
		}
		return cnt;
	}
	
	
	/**
	 * N is an integer within the range [1..100,000];
	 * @param A
	 * @return
	 */
	public int solution_old(int[] A){
		int cnt = 0;
		MYLOOP:for(int i=0;i<A.length;i++){
			for(int j=i+1;j<A.length;j++){
				int a = A[i];
				int b = A[j];
				if(a-b==-1){
					cnt++;
				}
				//if(cnt>1000000000){
				if(cnt>1000000000){
					cnt=-1;
					break MYLOOP;
				}
			}
		}
		return cnt;
	}
}
