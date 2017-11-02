package com.lesson4.countingelements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	public static void main(String [] args){
		
		int [] A = {4,1,3,2};
		
		System.out.println( new PermCheck().solution(A) );
	}

	public int solution(int[] A){
		Set<Integer> set = new HashSet<Integer>(); 
		for(int i=0;i<A.length;i++){
			set.add(i+1);
		}
		for(int i:A){
			set.remove(i);
		}
		return set.size()==0 ? 1 : 0;
	}
}
