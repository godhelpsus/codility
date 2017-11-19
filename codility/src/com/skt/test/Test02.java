package com.skt.test;

import org.junit.Test;

public class Test02 {

	@Test
	public void Correctness(){
		
		String [] S = {
				"123456" // 162534
			   ,"130"    // 103
			   ,"100000000"    // 100000000
			   ,"953568128"    // 985231586
			   ,"95356812"    //  92513856
				
		} 
		;
		
		for(String s : S){
			System.out.println(new Test02().solution(Integer.parseInt(s)));
			System.out.println("--");
		}
		
	}
	
	// solution
	public int solution(int A) {
		
		String strSrc = String.valueOf(A);
		String strDes = "";
		int strSrcLen = strSrc.length(); 
				
		for(int i=0;i<strSrcLen;i++){
			
			int fromIdx = i;
			int backIdx = (strSrcLen-i)-1;
			
			if(fromIdx<backIdx){
				strDes += String.valueOf(strSrc.charAt(fromIdx));
				strDes += String.valueOf(strSrc.charAt(backIdx));
			}else if(fromIdx==backIdx){
				strDes += String.valueOf(strSrc.charAt(fromIdx));
			}else{
				break;
			}
		}
		
		return Integer.parseInt(strDes); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
