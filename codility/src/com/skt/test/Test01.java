package com.skt.test;

import org.junit.Test;

public class Test01 {

	@Test
	public void Correctness(){
		
		
		String [] S = {
				"We test coders. Give us a try?" // 4
			   ,"Forget  CVs..Save time . x x" // 4
				
		} 
		;
		
		for(String s : S){
			System.out.println(new Test01().solution(s));
		}
		
	}
	

	public int solution(String S){
		
		int maxWordCnt = 0;
		int sentenceSplitIdx = 0;
		
		for(int i=0;i<S.length();i++){
			char c = S.charAt(i);
			if(c=='.' || c=='?' || c=='!' ){
				
				String sentence = S.substring(sentenceSplitIdx, i);
				sentenceSplitIdx = i+1;
				
				String[] words = sentence.split(" ");
				int wordCnt = 0;
				for(String w : words){
					if(!w.equals("")){
						wordCnt++;	
					}
				}
				
				if(wordCnt > maxWordCnt)
					maxWordCnt = wordCnt;
			}
		}
		return maxWordCnt;
	} 
	
	
	
	
	
}
