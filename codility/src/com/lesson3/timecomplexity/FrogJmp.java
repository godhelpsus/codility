package com.lesson3.timecomplexity;


public class FrogJmp {

	public static void main(String [] args){
		
		int X = 10;
		int Y = 85;
		int D = 30;
		
		System.out.println( new FrogJmp().solution(X, Y, D) );
	}
	
	public int solution(int X, int Y, int D){
		return (Y-X)/D + ((Y-X)%D==0?0:1);
	}
	
}
