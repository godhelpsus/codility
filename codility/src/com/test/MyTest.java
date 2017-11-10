package com.test;

import org.junit.Test;

import com.lesson7.stacksandqueues.Brackets;

public class MyTest {

//	@Test
	public void test02(){
		String s = "[[[[]]]][][]";
		s = s.replaceAll("\\[]", "");
		System.out.println(s);
	}
	
	
	@Test
	public void test01(){
		
		int NN = (int)Math.pow(10, 5);
		String s = "";
		for(int i=0;i<NN;i++){
			
			int div = ((int)(Math.random()*100))%6;
			if(div==1) s+="{";
			else if(div==2) s+="}";
			else if(div==3) s+="(";
			else if(div==4) s+=")";
			else if(div==5) s+="[";
			else s+="]";
			
//			s+="[";
		}
		
		System.out.println("end make sample...");
		
		long sTime = System.currentTimeMillis();
		int c = 0;
		
//		s = s.replace("{}", "");
//		s = s.replace("()", "");
//		s = s.replace("[]", "");
		
		c = new Brackets().solution(s);
		
		System.out.println("s = "+s.length()+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
		
		
	}
	
}
