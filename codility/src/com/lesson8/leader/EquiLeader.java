package com.lesson8.leader;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class EquiLeader {

	
	@Test
	public void Correctness(){
		
		int [][] AA = {
				{4,3,4,4,4,2} // 2
			,   {1,2} // 0
			,   {1,1} // 1
			,   {-100,-100} // 1
			,   {1,1,1,2,2,2,1} // 0
			,   {4, 4, 2, 5, 3, 4, 4, 4} // 3
				
		};
		
		for(int []A : AA){
			System.out.println( new EquiLeader().solution(A) );	
		}
		
	}
	
//	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			
			int NN = (int)Math.pow(10, N);
			int A[] = new int[NN];

			for(int i=0;i<NN;i++){
				A[i] = -1000000000;
//				A[i] = ((int)(Math.random()*10000000));
			}
			
			long sTime = System.currentTimeMillis();
			int c = new EquiLeader().solution(A);
			System.out.println("NN = "+NN+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
			
		}
	}
	
	
	public int solution(int [] A){
		
		// 앞쪽 리더
		int [] L1 = new int[A.length];
		HashMap<Integer, Integer> L1Map = new HashMap<Integer, Integer>();
		Stack<Integer> l1Stack = new Stack<Integer>();
		
		// 뒤쪽 리더
		int [] L2 = new int[A.length];
		HashMap<Integer, Integer> L2Map = new HashMap<Integer, Integer>();
		Stack<Integer> l2Stack = new Stack<Integer>();
		
		// 앞vs뒤 리더가 동일한 경우
		int equiLeaderCnt = 0; 
		
		for(int i=0;i<A.length;i++){
			
			//////////////////////////////////////////
			// 앞쪽 리더 구하기
			//////////////////////////////////////////
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
				
				// 과반이상 개수가 있는경우 리더로 선정
				L1[i] = A[i];
				l1Stack.push(A[i]);
				
			}else{
				
				// 이전 리더가 유효한지 확인
				int prevLeader = l1Stack.peek();
				int prevLeaderCnt = L1Map.get(prevLeader);
				
				if( prevLeaderCnt > (i+1)/2 ){
					L1[i] = prevLeader;
				}else{
					L1[i] = Integer.MIN_VALUE;	
				}
				
			}
			
			//////////////////////////////////////////
			// 뒤쪽 리더 구하기
			//////////////////////////////////////////
			int j = A.length-i-1; 
			
			if(j==A.length-1){
				L2[j] = Integer.MIN_VALUE;	
			}else{
				int lCnt2 = 0;
				int prevL2 = 0;
				
				// 리더  후보 갯수 증가
				if(L2Map.get(A[j+1])==null){
					lCnt2 = 1;
				}else{
					lCnt2 = L2Map.get(A[j+1])+1;
				}
				
				L2Map.put(A[j+1], lCnt2);
				
				if(lCnt2 > ((A.length-j-1)/2)){
					
					// 과반이상 개수가 있는경우 리더로 선정
					L2[j] = A[j+1];
					l2Stack.push(A[j+1]);
					
				}else{
					
					// 이전 리더가 유효한지 확인
					int prevLeader = l2Stack.peek();
					int prevLeaderCnt = L2Map.get(prevLeader);
					
					if( prevLeaderCnt > ((A.length-j-1)/2) ){
						L2[j] = prevLeader;
					}else{
						L2[j] = Integer.MIN_VALUE;	
					}
					
				}
			}
			
			
		} 
		
		//////////////////////////////////////////
		// 앞vs뒤 리더가 동일한 경우 계산
		//////////////////////////////////////////
		for(int i=0;i<A.length;i++){
			
			if(L1[i]==L2[i]){
				if(L1[i]!=Integer.MIN_VALUE){
					equiLeaderCnt++;
				}
			}
		}
		
		return equiLeaderCnt;
		
	}
	
}
