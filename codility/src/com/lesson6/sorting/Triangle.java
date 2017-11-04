package com.lesson6.sorting;

import java.util.Arrays;

import org.junit.Test;

public class Triangle {

	@Test
	public void Correctness(){

		int [][] A = {
			  {10, 2, 5, 1, 8, 20} // 1
			 ,{1, 2, 5, 2} // 0
		};
		
		for(int idx=0 ; idx<A.length ; idx++){
			String str = "answer = "+new Triangle().solution(A[idx]);
			System.out.println(str);
		}
	}
	
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			
			int [] A = new int[(int)Math.pow(10, N)];
			for(int i=0;i<A.length;i++){
				A[i] = ((int)(Math.random()*1000000));
				//A[i] = i;
				//if(A[i]%2==0) A[i]=A[i]*-1;
			}
			
			long sTime = System.currentTimeMillis();
			new Triangle().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec");	
		}
		
		
	}
	
	
	public int solution(int[] A){
		
		Arrays.sort(A);
		int size = A.length;	
		int result = 0;
		
		for(int i=0;i<size-2;i++){
			long a = (long)A[i];
			long b = (long)A[i+1];
			long c = (long)A[i+2];
			if(triplet(a,b,c)==1){
				result = 1;
				break;
			} 
		}
		
		return result;
	}
	
	
	public int triplet(long a, long b, long c){
		if(a<b+c && b<a+c && c<a+b) {
			return 1;
		}else{
			return 0;
		}
	}
	
}
