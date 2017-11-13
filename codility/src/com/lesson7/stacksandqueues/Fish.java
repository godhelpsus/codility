package com.lesson7.stacksandqueues;

import java.util.*;

import org.junit.Test;

public class Fish {

	
	@Test
	public void Correctness(){
		// 0 : left
		// 1 : right
		// 1 -> 0 : can eat
		int [][][] AB = {
					 {{4,3,2,1,5},{0,1,0,0,0}} // 2
	
					 , {{7,4,3,2,1,5},{0,1,0,1,0,1}} // 4
					 , {{7,4,2,1,5},{0,1,1,0,1}} // 4
					 , {{7,4,2,5},{0,1,1,1}} // 4
					 
				   , {{7,4,3,2,1,5},{0,1,1,1,1,0}} // 2
				   , {{4,3,2,1,5},{1,1,1,1,0}} // 1
				   , {{4,3,2,1,5},{0,0,0,1,1}} // 5
				   , {{4,3,2,1,5},{0,0,0,1,0}} // 4
				   , {{40,3,2,1,500},{1,0,0,0,0}} // 1
				   , {{10,20,30,40,25},{1,1,1,1,0}} // 4
				   , {{1,2,3,4,100,20,30,40,50,600},{1,1,1,0,1,1,1,1,1,0}} //2
		};
		
		
		for(int idx=0 ; idx<AB.length ; idx++){
			int remainCnt = new Fish().solution(AB[idx][0], AB[idx][1]);
			System.out.println("remainCnt = "+remainCnt);
		}
	}
	
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			int NN = (int)Math.pow(10, N);
			
			int A[] = new int[NN];
			int B[] = new int[NN];
			
			for(int i=0;i<NN;i++){
				A[i] = i;
				
				if(i==NN-1){
					B[i] = 0;
				}else{
					B[i] = 1;	
				}
				
			}
			
			long sTime = System.currentTimeMillis();
			int c = new Fish().solution(A, B);
			System.out.println("NN = "+NN+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
		}
		
		
	}
	
	
	public int solution(int [] A, int [] B){
		
		int sizeOfArray			= A.length;
		Stack<FishDto> stack 	= new Stack<FishDto>();

		if(sizeOfArray==0){
			return 0;
		}
		
		// 최초 물고기는 스택에 저장
		stack.push(new FishDto(A[0],B[0]));
		
		int maxSize = A[0]; // 같은 방향일때 최대값
		int grpStIdx = 0;
		
		for(int i=1;i<sizeOfArray;i++){
			
			FishDto fishPrev=  stack.peek();
			FishDto fish	= new FishDto(A[i],B[i]);
			
			// 서로 마주보는 방향인경우
			if( fishPrev.direction==1 && fish.direction==0 ){
				
				// System.out.println("i="+i+", maxSize = "+maxSize);

				// 오른쪽 방향의 물고기중 가장 큰 사이즈와 현재 물고기 비교
				// 지금 물고기가 더 큰 경우
				if(fish.size > maxSize){
					
					// 스택에서 grpStIdx 까지 모든 물고기를 꺼내 버림
					while(true){
						stack.pop();
						if(stack.size()==grpStIdx) {
							break;	
						}
						if(stack.size()==0) break;
					}
					
					// 지금 물고기를 스택에 넣는다
					stack.push(fish);
					
				// 이전 물고기중 더 큰값이 있는경우
				}else{
					
					// 스택에서 maxSize 까지 모든 물고기를 꺼내 버림
					while(true){
						FishDto f = stack.pop();
						if(f.size==maxSize || f.size>fish.size) {
							stack.push(f);
							break;	
						}
						if(stack.size()==0) break;
					}
					
				}
				
			
			// 서로 같은 방향
			}else if(fishPrev.direction == fish.direction){
				
				// 스택에 지금 물고기 넣기
				stack.push(fish);
				
				// 최대 사이즈 물고기 정보만 갱신
				if(maxSize < fish.size){
					maxSize = fish.size;
				}
				
			// 서로 반대 방향
			}else{
				
				// 최대 사이즈 물고기 정보 초기화 (다시 만날일 없으니...) 
				maxSize = fish.size;
				
				// 스택에 지금 물고기 넣기
				stack.push(fish);
				
				// 초기화된 시점의 스택 인덱스 저장
				grpStIdx = stack.size()-1;
			}
		}
		return stack.size();
	}
}

class FishDto {
	
	int size; // 물고기 사이즈
	int direction; // 이동방향
	
	public FishDto(int _size, int _direction){
		this.size = _size;
		this.direction = _direction;
	}
}