package com.lesson5.prefixsums;

import java.util.ArrayList;

import org.junit.Test;

public class PassingCars {

	private final int MAX = 1000000000;
	
	@Test
	public void Correctness(){
		
		int [][] AA = {
				{0,1,0,1,1} // 5
			, 	{0} // 0
			, 	{0,0,0,0,0} // 0
			, 	{0,0,0,0,1} // 4
			, 	{1,0,0,0,0} // 0
			, 	{0,1,0,1} // 3
				
		};
		
		for(int []A : AA){
			System.out.print( new PassingCars().solution_old2(A) +" = ");
			System.out.println( new PassingCars().solution(A) );	
		}
		
	}
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			
			int NN = (int)Math.pow(10, N);
			int A[] = new int[NN];

			for(int i=0;i<NN;i++){
				A[i] = ((int)(Math.random()*10))%2;
				A[i] = 0;
				if(i==NN-1) A[i] = 1;
			}
			
			long sTime = System.currentTimeMillis();
			int c = new PassingCars().solution(A);
			System.out.println("NN = "+NN+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
			
		}
	}
	
	public int solution(int[] A){
		
		int passingCarCnt = 0;
		ArrayList<Integer> eastPrev = new ArrayList<Integer>();
		
		if(A[0]==0) eastPrev.add(0);
		
		for(int i=1;i<A.length;i++){
			
			int a = A[i];
			
			if(a==1){
				passingCarCnt += eastPrev.size();
				
				if(passingCarCnt>MAX){
					passingCarCnt = -1;
					break;
				}
				
			}else{
				eastPrev.add(i);
			}
			
		}
		
		return passingCarCnt;
		
	}
	
	
	public int solution_old2(int[] A){
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
