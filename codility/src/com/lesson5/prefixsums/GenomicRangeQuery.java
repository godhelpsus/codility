package com.lesson5.prefixsums;

import org.junit.Test;

public class GenomicRangeQuery {

//	@Test
	public void testIndexOf(){
		
		String s = getSampleStr(100000) ;
		String x = "A";
		
		long sTime = System.currentTimeMillis();
		for(int i=0;i<50000;i++){
			s.indexOf(x);	
		}
		System.out.println("time = "+(System.currentTimeMillis()-sTime)+" msec");
	}
	
	
	
	@Test
	public void Correctness(){

		String[] S 	= {"CAGCCTA"};
		
		int[][] P 	= {{2,5,0}};
		
		int[][] Q 	= {{4,5,6}};
		
		
		for(int idx=0 ; idx<S.length ; idx++){
			int[] result = new GenomicRangeQuery().solution(S[idx], P[idx], Q[idx]);
			String str = "answer = ";
			for(int r : result){
				str += r+", ";
			}
			str = str.substring(0,str.length()-2);
			System.out.println(str);
		}
		
	}
	
	@Test
	public void Performance(){
//		int[] N 	= {1, 10, 100, 1000, 10000, 100000};  		// S문자열 길이
//		int[] M 	= {50000, 50000, 50000, 50000, 50000, 50000};	// M쿼리의 갯수
		
		int[] N 	= {10, 100, 1000, 10000, 100000};  				// S문자열 길이
		int[] M 	= {10000, 20000, 30000, 40000, 50000};			// M쿼리의 갯수
		
//		String temp = getSampleStr(100000) ;
		
		String[] S 	= new String[N.length];
		int[][] P 	= new int[N.length][];
		int[][] Q 	= new int[N.length][];

		for(int n=0;n<N.length;n++){
			S[n] = getSampleStr(N[n]) ;
			//S[n] = temp;
			
			for(int m=0;m<M[n];m++){
				
				if(m==0){
					P[n] = new int[M[n]];
					Q[n] = new int[M[n]];						
				}
				
				P[n][m] = 1;
				Q[n][m] = N[n]-1;
			}
			
			
			long sTime = System.currentTimeMillis();
			int[] result = new GenomicRangeQuery().solution(S[n], P[n], Q[n]);
			System.out.print("N = "+N[n]+"\t");	
			System.out.print("M = "+M[n]+"\t");
			System.out.print("time = "+(System.currentTimeMillis()-sTime)+" msec");
			System.out.println();
		}
		
		
	}
	
	public String getSampleStr(int n){
		String[] arr = {"A","C","G","T"};
		String s = "";
		for(int i=0;i<n-2;i++){
			//s += arr[(int)(Math.random()*10%4)];
			s += arr[3];
		}
		s += arr[0];
		s += arr[0];
		return s;
	}
	
	// C A G C C T A
	public int[] solution(String S, int[] P, int[] Q){
		
		int N = S.length();
		int[][] prefix = new int[3][N];
		int lastA = -1, lastC = -1, lastG = -1;
		for(int i=0;i<N;i++){
			
			char c = S.charAt(i);
			if('A' == c ){
				lastA = i;
			}else if('C' == c ){
				lastC = i;
			}else if('G' == c ){
				lastG = i;
			}
			
			prefix[0][i] = prefix[0][i] + lastA;
			prefix[1][i] = prefix[1][i] + lastC;
			prefix[2][i] = prefix[2][i] + lastG;
		}
		
		int querySize = P.length;
		int[] result = new int[querySize];
		
		for(int m=0;m<querySize;m++){
			for(int i=0;i<3;i++){
				int lastIdx = -1;
				lastIdx = prefix[i][Q[m]];
				result[m] = 4;
				if(lastIdx>=P[m] &&lastIdx <= Q[m]){
					result[m] = i+1;
					break;
				}
			}
		}
		return result;
	}
	
	public int getInt(char c){
		switch(c){
			case 'A' : return 1; 
			case 'C' : return 2; 
			case 'G' : return 3; 
			case 'T' : return 4; 
			default :  return 0;
		}
	}
	
	// 정확도 = 100%
	public int[] solution_old(String S, int[] P, int[] Q){
		int querySize = P.length;
		char[] arr = {'A','C','G','T'};
		int[] result = new int[querySize];
		for(int m=0;m<querySize;m++){
			String subStr = S.substring(P[m],Q[m]+1);
			
			int cSize = arr.length;
			for(int cIdx=0;cIdx<cSize;cIdx++){
				if(subStr.indexOf(arr[cIdx])>=0){
					result[m]=cIdx+1; 
					break;
				}
			}
			
		}
		return result;
	}
	
}
