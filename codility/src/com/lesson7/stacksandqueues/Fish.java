package com.lesson7.stacksandqueues;

import java.util.*;

import org.junit.Test;

public class Fish {

	
	@Test
	public void Correctness(){

		int [][][] AB = {{
					 {4,3,2,1,5},{0,1,0,0,0} // 2
		}};
		
		
		for(int idx=0 ; idx<AB.length ; idx++){
			int remainCnt = new Fish().solution(AB[idx][0], AB[idx][1]);
			System.out.println("remainCnt = "+remainCnt);
		}
	}
	
	public int solution(int [] A, int [] B){
		
		int remainCnt = 0;
		
		
		
		
		return remainCnt;
	}
	
	
}