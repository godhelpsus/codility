package com.lesson4.countingelements;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MissingInteger {

	public static void main(String [] args){
		
		int [] A = {1,2};
		
		System.out.println( new MissingInteger().solution(A) );
	}
	
	public int solution(int[] A){
		
		Set<Integer> set = new HashSet<Integer>(); 
		int minInt = 999999;
		
		for(int i=0;i<A.length+1;i++){
			set.add(i+1);
		}

		for(int i:A){
			set.remove(i);
		}
		
		Iterator<Integer> ita = set.iterator(); 
		while(ita.hasNext()){
			int n = ita.next();
			if(n<minInt)
				minInt = n;
		}
		
		return minInt;
	}
}
