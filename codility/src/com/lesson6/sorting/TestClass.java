package com.lesson6.sorting;

import org.junit.Test;

public class TestClass {

	
	@Test
	public void test(){
		
		long sTime = System.currentTimeMillis();
		int c = 1000000000;
		for(int i=0;i<10000000;i++){
			if(i%2==0)
			c++;
		}
		System.out.println("time = "+(System.currentTimeMillis()-sTime));	
		System.out.println(c);
		
		
	}
	
	
}
