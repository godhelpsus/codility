package com.lesson3.timecomplexity;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

	public static void main(String [] args){
		
		int [] A = {2,3,1,5};
		
		System.out.println( new PermMissingElem().solution(A) );
	}

	
	public int solution(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=1;i<=A.length+1;i++){
			set.add(i);
		}
		
		for(int i:A){
			if(set.contains(i)){
				set.remove(i);
			}
		}
		
    	return set.iterator().next();
    	
	}
    
}
