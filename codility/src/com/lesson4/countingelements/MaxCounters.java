package com.lesson4.countingelements;


public class MaxCounters {

	public static void main(String [] args){
		
		int N	 = 100000;
		int [] A = new int[N];		
		
		for(int a=0;a<N;a++){
			if(a==0){
				A[a] = 1;
			}else{
				A[a] = N+1;	
			}
			 
		}
		System.out.println("--");
		long st = System.currentTimeMillis();
		
		int [] B =  new MaxCounters().solution(N, A) ;
		
		for(int a:B){
			System.out.print(a+",");
		}
		
		long en = System.currentTimeMillis();
		System.out.println("\n"+(en-st)+"msec");
	}

	
	public int[] solution(int N, int[] A){
		
		int [] res = new int[N];
		int max	   = 0;
		
		for(int k=0;k<A.length;k++){
			if(A[k]==(N+1)){
				for(int a=0;a<N;a++){
					res[a] = max; 
				}
			}else{
				res[A[k]-1] = res[A[k]-1] + 1;
				if(res[A[k]-1]>max){
					max = res[A[k]-1]; 
				}
			}
		}
		return res;
	}

	public int[] solution_comment(int N, int[] A) {
		
		int applied = 0;
		int max = 0;
		int[] result = new int[N];
		
		for(int x : A){
			if(x > N){
				applied = max;
			}else{
				if( result[x - 1] < applied)
						result[x - 1] = applied + 1; 
				else
					result[x - 1] += 1;
	
				if(max < result[x - 1]) max++;
			}
		}

		for(int i = 0; i < N; i++){
			if(applied > result[i]){
				result[i] = applied;
			} 
		}

		return result; 
	}


	
	public int[] solution_old(int N, int[] A){
		
		int [] res = new int[N];
		int max	   = 0;
		
		for(int i=0;i<A.length;i++){
			
			for(int n=0;n<res.length;n++){
				
				if((n+1)==A[i]){
					res[n] = res[n]+1; 
					if(res[n]>max){
						max = res[n]; 
					}
				}else if((N+1)==A[i]){
					res[n] = max;
				}
			}
		}
		return res;
	}
	
	
}
