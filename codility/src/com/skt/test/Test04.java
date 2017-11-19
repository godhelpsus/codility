package com.skt.test;

import org.junit.Test;

public class Test04 {

	@Test
	public void Correctness(){
		
		int [] A1	= {2,8,4,3,2};
		int X 		= 7;
		int Y 		= 11;
		int Z 		= 3;
		System.out.println( new Test04().solution(A1, X, Y, Z)); // 8
		
		int [] A2	= {5};
		X 			= 4;
		Y 			= 0;
		Z 			= 3;
		System.out.println( new Test04().solution(A2, X, Y, Z)); // -1
		
		int [] A3	= {5,10,15,20};
		X 			= 100;
		Y 			= 0;
		Z 			= 20;
		System.out.println( new Test04().solution(A3, X, Y, Z)); // ??
		
	}
	
	
	// solution
	public int solution(int[] A, int X, int Y, int Z){
		
		int maxWaitSec = -1;
		
		int fillSecX = 0;
		int fillSecY = 0;
		int fillSecZ = 0;
		
		int waitSecX = 0;
		int waitSecY = 0;
		int waitSecZ = 0;
		
		for(int i=0;i<A.length;i++){
			
			int needLiter = A[i];
			
			// find waiting time of place separately (X, Y, Z)
			int [] minWaitSec 	= new int[3];
			minWaitSec[0] 	= Integer.MAX_VALUE;
			minWaitSec[1] 	= Integer.MAX_VALUE;
			minWaitSec[2] 	= Integer.MAX_VALUE;
			
			if(needLiter<=X){
				minWaitSec[0] = fillSecX;
			}
			if(needLiter<=Y){
				minWaitSec[1] = fillSecY;
			}
			if(needLiter<=Z){
				minWaitSec[2] = fillSecZ; 
			}

			// find minimum waiting time place
			int tempMin = Integer.MAX_VALUE;
			int tempIdx = -1;
			for(int t=0;t<3;t++){
				int temp = minWaitSec[t];
				if(temp!=Integer.MAX_VALUE){
					if(t<tempMin){
						tempMin = temp;
						tempIdx = t;
					}
				}
			}
			
			if(tempIdx==0){
				
				X = X-needLiter;
				waitSecX = fillSecX; 
				fillSecX += needLiter;
				
			}else if(tempIdx==1){
				
				Y = Y-needLiter;
				waitSecY = fillSecY;
				fillSecY += needLiter;
				
			}else if(tempIdx==2){
				
				Z = Z-needLiter;
				waitSecZ = fillSecZ;
				fillSecZ += needLiter;
			}else{
				return -1;
			}
		}
		
		// find maximum wait seconds
		maxWaitSec = Math.max(waitSecX, waitSecY);
		maxWaitSec = Math.max(maxWaitSec, waitSecZ);
		
		return maxWaitSec;
		
	}
	
	
}
