package com.lesson6.sorting;

import java.util.HashMap;

import org.junit.Test;

public class NumberOfDiscIntersections {

	@Test
	public void Correctness(){

		int [][] A = {
			  {1, 5, 2, 1, 4, 0} // 11
			  ,{1, 1, 1} // 3
			  ,{2147483647, 2147483647} // 1
		};
		
		for(int idx=0 ; idx<A.length ; idx++){
			String str = "answer = "+new NumberOfDiscIntersections().solution(A[idx]);
			System.out.println(str);
		}
		
	}
	
//	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			
			int [] A = new int[(int)Math.pow(10, N)];
			for(int i=0;i<A.length;i++){
//				A[i] = ((int)(Math.random()*1000000000));
				//A[i] = 2147483647;
				A[i] = 1;
//				if(i%2==0) A[i]=2;
			}
			
			long sTime = System.currentTimeMillis();
			int c = new NumberOfDiscIntersections().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
		}
		
		
	}
	
	
	public int solution_temp(int [] A){
		
		int c = 0;
		int size = A.length;
		int maxCnt = 10000000; 
		
		HashMap<Integer, Integer> minIdxMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> maxIdxMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<size;i++){
			maxIdxMap.put(A[i], i);
			if(minIdxMap.get(A[i])!=null){
				minIdxMap.put(A[i], i);
			}
		}
		
		c = minIdxMap.keySet().size();
		
		return c;	
	}
	
	public int solution(int [] A){
	
		int c = 0;
		int size = A.length;
		int maxCnt = 10000000; 
		
		LOOP1:for(int i=0;i<size-1;i++){
			
			int a = A[i];
			
			int aMax = i+a;
//			int aMin = i-a<0?0:i-a;
			for(int j=i+1;j<size;j++){
				
				int b = A[j];
				
//				int bMax = j+b;
				
				int bMin = j - b;

				if((aMax-bMin)>=0){
					c++;
				}
				
				/*
				int bMin = j-b<0?0:j-b;
				
				if((aMax-bMin)>0){
					c = 2;
				}
				
				
				if(aMax >= bMin ){
					c++;
				}
				*/
				if(c>maxCnt){
					c = -1;
					break LOOP1;
				}
				
				
			}
		}
		
		
		return c;
	}
	
}
