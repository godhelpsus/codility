package com.lesson1.iteration;


public class BinaryGap {

	public static void main(String [] args){
		
		System.out.println( new BinaryGap().solution(1051) );
		
	}

	
	public int solution(int N) {
        
        String 	strN 		= Integer.toBinaryString(N);
        char 	preC 		= '1';
		boolean gapFlag 	= false;
		int 	maxGapSize 	= 0;
		int 	gapSize 	= 0; 
		
		for(int i=0;i<strN.length();i++){
			
			boolean changeGap 	= false;
			char 	c 			= (char)strN.charAt(i);
			
			if(i>0){
				if(c=='0'){
					if(preC=='1'){
						gapFlag = true;
						gapSize = 0;
					}else if(gapFlag){
						gapFlag = true;
					}else{
						gapFlag = false;
					}
				}else{
					gapFlag = false;
					changeGap = true;
				}
				if(gapFlag){
					gapSize++;
				}
				if(changeGap || (i==strN.length()-1 && c=='1')){
					if(maxGapSize < gapSize){
						maxGapSize = gapSize;
					}
				}
			}
			preC = c;
		}
		
        return maxGapSize;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
