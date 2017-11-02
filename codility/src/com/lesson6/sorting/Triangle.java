package com.lesson6.sorting;

import org.junit.Test;

public class Triangle {

	@Test
	public void Correctness(){

		int [][] A = {
			  {10, 2, 5, 1, 8, 20} // 1
			 ,{1, 1, 5, 2} // 0
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
				//A[i] = ((int)(Math.random()*1000000));
				A[i] = i;
				//if(A[i]%2==0) A[i]=A[i]*-1;
			}
			
			long sTime = System.currentTimeMillis();
			new Triangle().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec");	
		}
		
		
	}
	
	
	public int solution(int[] A){
		
		for(int i=0;i<A.length-1;i++){
			for(int j=0;j<A.length-i-1;j++){
				int a = A[j];
				int b = A[j+1];
//				System.out.println(j+" - "+(j+1));
				if(a<b){
					A[j+1] = a;
					A[j] = b;
				}
			}
		}
		
		//////////////
//		String str = "";
//		for(int r : A){
//			str += r+", ";
//		}
//		str = str.substring(0,str.length()-2);
//		System.out.println(str);
		
		
		return 0;
	}
	
}
