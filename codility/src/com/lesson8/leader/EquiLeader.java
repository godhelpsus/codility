package com.lesson8.leader;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class EquiLeader {

	
	@Test
	public void Correctness(){
		
		int [] A = {4,3,4,4,4,2};
		
		System.out.println( new EquiLeader().solution(A) );
		
	}
	
	public int solution(int [] A){
		
		// 앞쪽 리더
		int [] L1 = new int[A.length];
		// 뒤쪽 리더
		int [] L2 = new int[A.length];
		
		HashMap<Integer, Integer> L1Map = new HashMap<Integer, Integer>();
		
		
		// 앞쪽 리더 구하기
		for(int i=0;i<A.length;i++){
			
			int lCnt = 0;
			int prevL = 0;
			
			// 리더  후보 갯수 증가
			if(L1Map.get(A[i])==null){
				lCnt = 1;
			}else{
				lCnt = L1Map.get(A[i])+1;
			}
			
			L1Map.put(A[i], lCnt);
			
			if(lCnt > ((i+1)/2)){
				L1[i] = A[i];
			}else{
				L1[i] = Integer.MIN_VALUE;
			}
		}
		
		return 0;
		
	}
	
}
