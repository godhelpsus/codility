package com.lesson7.stacksandqueues;

import java.util.*;

import org.junit.Test;

public class StoneWall {

//	@Test
	public void Correctness(){

		/*
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		Block block1 = new Block(0,2,0,8);
		Block block2 = new Block(2,4,0,5);
		Block block3 = new Block(3,4,5,7);
		Block block4 = new Block(4,5,0,9);
		
		blocks.add(block1);
		blocks.add(block2);
		blocks.add(block3);
		
		Result res = merge(blocks, block4);
		
		for(Block block : res.blocks){
			System.out.println("병합된 : "+block.getRectangle());
		}
		*/
		
		/*
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		Block block1 = new Block(0,2,0,8);
		Block block2 = new Block(2,6,0,5);
		Block block3 = new Block(3,6,5,7);
		Block block4 = new Block(4,5,7,9);
		Block block5 = new Block(5,6,7,8);
		
		blocks.add(block1);
		blocks.add(block2);
		blocks.add(block3);
		blocks.add(block4);
		blocks.add(block5);
		
		Result res = merge(blocks, new Block(6,7,0,7));
		
		for(Block block : res.blocks){
			System.out.println("병합된 : "+block.getRectangle());
		}
		*/
		
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		Block block1 = new Block(0,1,0,8);
		Block block2 = new Block(1,4,0,1);
		Block block3 = new Block(2,3,1,2);
		
		blocks.add(block1);
		blocks.add(block2);
		blocks.add(block3);
		
		ArrayList<Block> res = merge(blocks, new Block(4,5,0,8));
		
		
		
		for(Block block : res){
			System.out.println("병합된 : "+block.getRectangle());
		}
		
	}
	
//	@Test
	public void Correctness2(){

		int [][] A = {
			     {8,8,8,8,8} // 1
			   , {8,1,2,1,8} // 4
 			   , {8,1,2,9,8} // 5
 			   , {4,8,1,1,4} // 4
			   , {8,8,5,7,9,8,7,4,8} // 7
				
		};
		
		for(int idx=0 ; idx<A.length ; idx++){
			String str = "answer = "+new StoneWall().solution(A[idx]);
			System.out.println(str);
			System.out.println("##########################");
			System.out.println("");
		}
		
	}
	
	
	@Test
	public void Performance(){
		
		for(int N=0;N<=5;N++){
			int NN = (int)Math.pow(10, N);
			int [] A = new int[NN];
			for(int i=0;i<A.length;i++){
//				A[i] = ((int)(Math.random()*1000000000));
//				A[i] = 2147483647-i;
				if(i==0 || i==A.length-1){
					A[i] = NN;
				}else{
					A[i] = i;	
				}
				
//				if(i%2==0) A[i]=2;
			}
			
			long sTime = System.currentTimeMillis();
			int c = new StoneWall().solution(A);
			System.out.println("N = "+A.length+"\ttime = "+(System.currentTimeMillis()-sTime)+" msec\t"+"answer = "+c);	
		}
		
		
	}
	
	
	public int solution(int [] A){
		ArrayList<Block> result = null;
		
		for(int i=0;i<A.length;i++){
			Block blockB = new Block(i,i+1,0,A[i]);
			
			result = merge(result, blockB);
			/*
			System.out.println("==================");
			System.out.println("Target Block : "+blockB.getRectangle());
			
			for(Block block : result){
				System.out.println("Merged Block : "+block.getRectangle());
			}
			*/
			
		}
		
		return result.size();
		
	}
	
	/***
	 * Block 두개를 병합한다.
	 * @return
	 */
	public ArrayList<Block> merge(ArrayList<Block> blocks, Block blockB){

		if(blocks==null){
			
			blocks = new ArrayList<Block>();
			blocks.add(blockB);
			
		}else{
			
			int size = blocks.size();
			boolean isMerge = false;
			for(int i=size-1;i>=0;i--){
				
				Block blockA = blocks.get(i);
				
				// 인접한경우만
				if(blockA.endX == blockB.startX){
					
					// 병합 가능
					if(blockA.endY <= blockB.endY){
						
						// 병합은 한번만
						if(!isMerge){
							
							int newStartX 	= blockA.startX;
							int newEndX 	= blockB.endX;
							int newStartY 	= blockA.startY;
							int newEndY 	= blockA.endY;
							
							int leftStartX 	= blockB.startX;
							int leftEndX 	= blockB.endX;
							int leftStartY 	= blockA.endY;
							int leftEndY 	= blockB.endY;
							
							Block newBlock 	= new Block(newStartX, newEndX, newStartY, newEndY);
							Block leftBlock = new Block(leftStartX, leftEndX, leftStartY, leftEndY);
							
							// 병합 후 새로 생긴 블록은 교체
							blocks.set(i, newBlock);
							
							// 남는게 생기는 경우 
							if(leftEndY>leftStartY){
								blocks.add(leftBlock);
							}
							
							// 병합 FLAG 처리
							isMerge = true;
						}
						
						
					// 병합 불가
					}else{
						if(blockA.startY==0){
							blocks.add(blockB);
							break;	
						}
					}
						
					// 한번 병합 되었다면.. 아래쪽은 무조건 X축을 +1씩 전진(병합)시킨다.
					if(isMerge){
						int newStartX 	= blockA.startX;
						int newEndX 	= blockA.endX+1;
						int newStartY 	= blockA.startY;
						int newEndY 	= blockA.endY;
						Block newBlock 	= new Block(newStartX, newEndX, newStartY, newEndY);
						blocks.set(i, newBlock);
					}
					
					
				}else{
					
					// 인접하지 않으면 LOOP 종료
					if(blockA.startY==0){
						break;
					}
				} 
				
			} // end of loop
			
		}
		
		return blocks;
	}
	
	
	
	
	
	// 리스트 인덱스 앞에서 부터 탐색
	public int solution_1(int [] A){
		ArrayList<Block> result = null;
		
		for(int i=0;i<A.length;i++){
			Block blockB = new Block(i,i+1,0,A[i]);
			
			result = merge_1(result, blockB);
			
			System.out.println("==================");
			System.out.println("Target Block : "+blockB.getRectangle());
			
			for(Block block : result){
				System.out.println("Merged Block : "+block.getRectangle());
			}
			
		}
		
		return result.size();
		
	}
	
	
	
	/***
	 * Block 두개를 병합한다.
	 * @return
	 */
	public ArrayList<Block> merge_1(ArrayList<Block> blocks, Block blockB){

		if(blocks==null){
			
			blocks = new ArrayList<Block>();
			blocks.add(blockB);
			
		}else{
			
			for(int i=0;i<blocks.size();i++){
				
				Block blockA = blocks.get(i);
				
				// 인접한경우만
				if(blockA.endX == blockB.startX){
					
					
					// 병합 가능
					if(blockA.startY == blockB.startY && blockA.endY <= blockB.endY){
						
						int newStartX 	= blockA.startX;
						int newEndX 	= blockB.endX;
						int newStartY 	= blockA.startY;
						int newEndY 	= blockA.endY;
						
						int leftStartX 	= blockB.startX;
						int leftEndX 	= blockB.endX;
						int leftStartY 	= blockA.endY;
						int leftEndY 	= blockB.endY;
						
						Block newBlock 	= new Block(newStartX, newEndX, newStartY, newEndY);
						Block leftBlock = new Block(leftStartX, leftEndX, leftStartY, leftEndY);
						
						// 병합 후 새로 생긴 블록은 교체
						blocks.set(i, newBlock);
						
						// 남는게 생기는 경우 
						if(leftEndY>leftStartY){
							
							blockB = leftBlock;
							
							if(i==blocks.size()-1){
								blocks.add(leftBlock);
							}
						
						}else{
							break;
						}
						
					// 병합 불가
					}else{
						blocks.add(blockB);
						break;
						
					}
					
				// 인접 안하는 경우
				}else{
					
					
					
				}
			}
			
			
		}
		return blocks;
	}
}

class Block{
	
	int startX;
	int endX;
	int startY;
	int endY;
	
	public Block(int _startX, int _endX, int _startY, int _endY){
		this.startX 	= _startX;
		this.endX 		= _endX;
		this.startY 	= _startY;
		this.endY 		= _endY;
	}
	
	public String getRectangle(){
		return startX+","+endX+" "+startY+","+endY;
	}
	
}
