package com.lesson5.prefixsums;

import org.junit.Test;

public class MinAvgTwoSlice {

	
	
//	@Test
	public void Performance(){
		
		// expected worst-case time complexity is O(N)		
		for(int N=0;N<10;N++){
			
			int [] A = new int[N*1000];
			for(int i=0;i<A.length;i++){
				A[i] = ((int)(Math.random()*1000));
				if(A[i]%2==0) A[i]=A[i]*-1;
			}
			
			long sTime = System.currentTimeMillis();
			new MinAvgTwoSlice().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec");	
		}
		
		
	}
	
	@Test
	public void Correctness(){

		int [][] A = {
				{2, 2, 2, 2, 2, 2, 1},	// 5
				{4, 2, 2, 5, 1, 5, 8},	// 1
				{5, 6, 3, 4, 9},		// 2
				{-3, -5, -8, -4, -10}	// 2
		};
		
		for(int a=0;a<A.length;a++){
			System.out.println("answer = "+new MinAvgTwoSlice().solution(A[a]) );
		}
		
	}
	
	public int solution(int[] A){
		int a = 0;
		double minAvg = Double.MAX_VALUE;
		for(int p=0 ; p<A.length-2 ; p++){
			double avg2 = silceAvg(A, p, p+1);
			double avg3 = silceAvg(A, p, p+2);
			double avg = avg2 < avg3 ? avg2 : avg3;
			if(minAvg > avg){
				minAvg = avg;
				a = p;
			}
		}
		
		double avgLast = silceAvg(A, A.length-2, A.length-1);
		if(minAvg > avgLast){
			minAvg = avgLast;
			a = A.length-2;
		}
		
		
		return a;
	}
	
	public double silceAvg(int[] A, int p, int q){
		double sum = 0;
		for(int i=p;i<=q;i++){
			sum += A[i];
		}
		return sum/(q-p+1);
	}
	
}
