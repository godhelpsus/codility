package com.skt.test;

import java.util.Stack;

import org.junit.Test;

public class Test03 {

	@Test
	public void Correctness(){
		
		
		String [] S = {
				"13 DUP 4 POP 5 DUP + DUP + -" // 7
			  , "5 6 + -" // -1
			  , "3 DUP 5 - -" // -1
			  , "" // -1
			  , "+" // -1
			  , "5 +" // -1
			  , "5 -1 +" // -1
		} 
		;
		
		for(String s : S){
			System.out.println(new Test03().solution(s));
		}
		
	}
	
	
	// solution
public int solution(String S){
		
		int topMostValue = -1; 		
		Stack<Integer> stack = new Stack<Integer>();
		
		try{
			
			String[] commandArr = S.split(" "); 
			
			for(String command : commandArr){
				
				if(command.equals("DUP")){
					
					int n1 = stack.peek();
					stack.push(n1);
					
				}else if(command.equals("POP")){
				    
					stack.pop();
					
				}else if(command.equals("+")){

					int n1 = stack.pop();
					int n2 = stack.pop();
					if(isVaild(n1+n2)){
						stack.push(n1+n2);	
					}else{
						throw new Exception("Addition Overflow");
					}
					
				}else if(command.equals("-")){
					
					int n1 = stack.pop();
					int n2 = stack.pop();
					if(isVaild(n1-n2)){
						stack.push(n1-n2);	
					}else{
						throw new Exception("Subtraction Negative Result");
					}
					
				}else{
					int n = Integer.parseInt(command);
					if(isVaild(n)){
						stack.push(n);	
					}else{
						throw new Exception("Overflow/Underflow Input Value");
					}
					
				}
				
			}
			
			// get top most value of stack
			topMostValue = stack.peek();
			
		}catch(Exception ex){
			// System.out.println(ex.toString());
		}
		
		return topMostValue;
	}
	
	public boolean isVaild(int n){
		return n>=0 && n<=Math.pow(2, 20)-1;
	}
	
}

