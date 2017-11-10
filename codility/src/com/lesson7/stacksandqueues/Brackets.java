package com.lesson7.stacksandqueues;

import java.util.HashMap;

import org.junit.Test;

public class Brackets {

	@Test
	public void Correctness2(){

		String [] S = {
			     "{[()()]}" // 1
			    ,"([)()]" // 0
			    ,"[[[[]]]][][]" // 0
//			    ,"" // 1
//			    ,"[" // 0
//			    ,"{{" // 0
//			    ,"}" // 0
//			    ,"))}{" // 0
//			    ,"}{" // 0
//			    ,"{}{}" // 1
//			    ,"[}{]" // 0
//			    ,"[()()}{]" // 0
//			    ,"[()()}]" // 0
//			    ,"{[()()}]" // 0
//			    ,"{[()]()}" // 1
//			    ,"{[()()]}" // 1
//			    ,"({{({}[]{})}}[]{})" // 1
		};
		
		for(int idx=0 ; idx<S.length ; idx++){
			System.out.println(S[idx] +" = "+ new Brackets().solution(S[idx]) );
		}
	}
	
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			int NN = (int)Math.pow(10, N)*2;
			String s = "";
			for(int i=0;i<NN;i++){
				
//				int div = ((int)(Math.random()*100))%6;
//				if(div==1) s+="{";
//				else if(div==2) s+="}";
//				else if(div==3) s+="(";
//				else if(div==4) s+=")";
//				else if(div==5) s+="[";
//				else s+="]";
				
				if(i<NN/2){
					s+="[";	
				}else{
					s+="]";
				}
				
			}
			
			long sTime = System.currentTimeMillis();
			int c = new Brackets().solution(s);
			System.out.println("s = "+s.length()+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
		}
		
		
	}
	
	
	public int solution (String s){
		
		for(int i=0;i<s.length()-1;i++){
			
			char a = s.charAt(i);
			char p = getPair(a);
					
			int skipCnt = 0;
			
			for(int j=i+1;j<s.length();j++){
			
				char b = s.charAt(j);
				
				if(a==b)skipCnt++;
				
				if(p==b){
					if(skipCnt>0){
						skipCnt--;
					}else if(skipCnt==0){
						//System.out.println("pair = "+i+"-"+j);
						break;
					}
				}
			}
		}
		
		return 0;
	}
	
	
	public int solution_old2 (String s){
		
		while(s!=null&&s.length()>0){
			s = removeBrackets(s);
		}
		
		return s==null?0:1;
	}

	public String removeBrackets(String s){

		int a = s.length();
		
//		System.out.print(s);
		s = s.replaceAll("\\{\\}", "");
		s = s.replaceAll("\\(\\)", "");
		s = s.replaceAll("\\[\\]", "");
//		System.out.print("->"+s);
//		System.out.println();
		
		int b = s.length();
		
		if(a==b){
			return null;
		}else{
			return s;
		}
		
	}	
	
	
	public int solution_old (String S){
		
		int result 		= 1;
		int maxNestIdx 	= S.length();
		HashMap<Integer, String> pairMap = new HashMap<Integer, String>();
		
		for(int i=0;i<S.length();i++){
			
			if(pairMap.get(i)==null){
				
				char pairChar 	= getPair(S.charAt(i));
				int nextPairIdx = S.indexOf(pairChar, i+1);
				
				if(nextPairIdx>i&&nextPairIdx<maxNestIdx){
					maxNestIdx = nextPairIdx;
					pairMap.put(nextPairIdx, "");
				}else{
					result = 0;
					break;
				}
			}else{
				maxNestIdx 	= S.length();
			}
		}
		
		return result;
	}
	
	public char getPair(char c){
		     if(c=='(') return ')';
		//else if(c==')')	return '(';
		else if(c=='{') return '}';
		//else if(c=='}') return '{';
		else if(c=='[')	return ']';
		//else if(c==']')	return '[';
		else return 0;
		
	}
	
}
