package com.lesson4.countingelements;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String [] args){
		
		int X	 = 5;
		int [] A = {1,3,1,4,2,3,5,4};
		
		System.out.println( new FrogRiverOne().solution(X, A) );
		
	}
	
	public int solution(int X, int[] A){
		
		int minSec 			= -1;
		Set<Integer> set 	= new HashSet<Integer>(); 
		
		for(int i=0;i<X;i++){
			set.add(i+1);
		}
		
		for(int sec=0;sec<A.length;sec++){
			set.remove(A[sec]);
			if(set.isEmpty()){
				minSec = sec;
				break;
			}
		}
		return minSec;
	}

}
