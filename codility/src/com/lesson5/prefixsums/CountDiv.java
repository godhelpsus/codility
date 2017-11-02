package com.lesson5.prefixsums;

public class CountDiv {

	public static void main(String [] args){
		
		int A = 0;
		int B = 2000000000;
		int K = 1;
		// 6 7 8 9 10 11
		System.out.println( new CountDiv().solution(A, B, K) );
		//System.out.println( new CountDiv().solution_old(A, B, K) );
	}
	
	public int solution(int A, int B, int K){
		
		int cnt1 = 0;
		if(A==0){
			cnt1 = -1;
		}else{
			cnt1 = (A-1)/K;
		}

		int cnt2 = B/K;
		return cnt2-cnt1;
	}


	public int solution_old(int A, int B, int K){
		
		int cnt = 0;
		for(int i=A;i<=B;i++){
			
			if(i%K==0){
				cnt++;
			}
			
		}
		
		return cnt;
	}
	
	
}
