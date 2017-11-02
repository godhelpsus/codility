package com.lesson2.array;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String [] args){
		
		int N = 10000003;
		int [] arr = new int[N];
		for(int i=0;i<N;i++){
			if(i==N-1){
				arr[i] = 7;
			}else{
				arr[i] = 1;
			}
		}
		
		System.out.println( new OddOccurrencesInArray().solution(arr) );
		
	}
	
	
	public int solution(int[] A){
		Set<Integer> set = new HashSet<Integer>();
		for(int i:A){
			
			if(set.contains(i)){
				set.remove(i);
			}else{
				set.add(i);
			}
		}
		return set.iterator().next();
	}
	
}
