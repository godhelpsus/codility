package com.lesson2.array;

public class CyclicRotation {

	public static void main(String [] args){
		
		int [] A = {1,2,3,4,5,6,7,8,9};
		int K	 = 3;
		
		A = new CyclicRotation().solution(A, K);
		for(int i:A){
			System.out.println(i);
		}
		
	}

	
	public int[] solution(int[] A, int K) {
		
		int loopCnt = 0;
		if(A.length>0){
			loopCnt = K%A.length;
		}
		for(int i=0;i<loopCnt;i++){
			int jumpVal = 0;
			for(int j=A.length-1;j>0;j--){
				if(j==A.length-1){
					jumpVal = A[j];
				}
				A[j] = A[j-1];
			}
			A[0] = jumpVal;
		}
		return A;
	}
	
}


