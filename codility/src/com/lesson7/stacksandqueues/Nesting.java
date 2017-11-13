package com.lesson7.stacksandqueues;

import java.util.Stack;

import org.junit.Test;

public class Nesting {

	@Test
	public void Correctness2(){

		String [] S = {
			     "(()(())())" 	// 1
			   , "())" 			// 0
		};
		
		for(int idx=0 ; idx<S.length ; idx++){
			System.out.println(S[idx] +" = "+ new Nesting().solution(S[idx]) );
		}
	}
	
	
	public int solution(String s){
		
		Stack<Character> stack = new Stack<Character>();
		int result = 1;
		for(int i=0;i<s.length();i++){
			
			char c = s.charAt(i);
			
			if(c=='{'||c=='('||c=='['){
				
				result = 0;
				stack.push(c);
				
			}else if(c=='}'||c==')'||c==']'){
				
				if(stack.size()>0 && getPair(stack.pop())==c){
					result = 1;
				}else{
					result = 0;
					break;
				}
				
			}else{
				result = 0;
				break;
			}
		}
		
		if(stack.size()>0)
			result = 0;
		
		return result;
	}

	public char getPair(char c){
		    if(c=='(') return ')';
		else if(c=='{') return '}';
		else if(c=='[')	return ']';
		else return 0;
	}
}
