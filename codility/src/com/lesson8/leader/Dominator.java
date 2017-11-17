package com.lesson8.leader;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class Dominator {

	@Test
	public void Correctness(){
		
		int [][] AA = {
				{3,4,3,2,3,-1,3,3} // 0,2,4,6,7
			,   {3,3,3,3,1,1} // 0,1,2,3
			,   {0,0,0,1,1,1,2,2} // -1
			,   {} // -1
			,   {-2147483648, -2147483648, -2147483648, -2147483648} // 0 1 2 3
			,   {-2147483648, 2147483647, 2147483647, -2147483648} // -1
			,   {2147483647, -2147483648, 2147483647, 2147483647, -2147483648} // 3
		};
		
		for(int []A : AA){
			System.out.println(new Dominator().solution(A));
		}
		
	}
	
	public int solution(int [] A){
		
		long [] L1 = new long[A.length];
		HashMap<Integer, Integer> L1Map = new HashMap<Integer, Integer>();
		HashMap<Long, Integer> dominatorMap = new HashMap<Long,Integer>();
		Stack<Integer> l1Stack = new Stack<Integer>();
		int dominator = -1;
		
		for(int i=0;i<A.length;i++){
			
			int lCnt = 0;
			
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
					L1[i] = Long.MIN_VALUE;	
				}
				
			}
			
			if(A[i]==L1[i]){
				dominatorMap.put((long)A[i], i);
			}
			
		}
		
		if(A.length >0 && L1[A.length-1]>Long.MIN_VALUE){
			long key =  L1[A.length-1];
			return dominatorMap.get(key);
		}else{
			return -1;
		}
	}
	
	
}
