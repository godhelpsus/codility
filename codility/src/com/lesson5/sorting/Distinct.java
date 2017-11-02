package com.lesson5.sorting;

import org.junit.Test;

public class Distinct {

	@Test
	public void Correctness(){

		int [][] A = {
			  {2, 1, 1, 2, 3, 1} // 3
			, {1, 2, 3, 4, 5, 6} // 6
			, {1, 1, 1, 4, 1, 1} // 2
			, {1} 	// 1
			, {} 	// 0
		};
		
		for(int idx=0 ; idx<A.length ; idx++){
			String str = "answer = "+new Distinct().solution(A[idx]);
			System.out.println(str);
		}
		
	}
	
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			
			int [] A = new int[(int)Math.pow(10, N)];
			for(int i=0;i<A.length;i++){
				//A[i] = ((int)(Math.random()*1000000));
				A[i] = i;
				//if(A[i]%2==0) A[i]=A[i]*-1;
			}
			
			long sTime = System.currentTimeMillis();
			new Distinct().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec");	
		}
		
		
	}
	
	

	public int solution(int[] A){
		int distinctCnt = 0;
		int N = A.length;
		java.util.HashMap<Integer, Integer> distinctMap = new java.util.HashMap<Integer, Integer>();  
		for(int i=0;i<N;i++){
			int n = A[i];
			if(distinctMap.get(n)!=null){
			}else{
				distinctMap.put(n,1);
				distinctCnt++;
			}
		}
		return distinctCnt;
	}
	
}

