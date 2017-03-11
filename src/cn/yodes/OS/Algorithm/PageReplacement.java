package cn.yodes.OS.Algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PageReplacement {
	Scanner sc = new Scanner(new BufferedInputStream(System.in));
	
	public static void main(String[] args) {
		new PageReplacement().display();
	}
	
	public void display(){
		PageReplacement test = new PageReplacement();
		int sum_page = 20;
		boolean show;
		int []page = new int[sum_page];
		
		int sum_block = 5;
		int[] block = new int[sum_block];
		
		System.out.println("请选择是否展示所有的演示过程：");
		System.out.println("1.Yes\t\t\t2.No");
		if(sc.nextInt() == 1){
			show = true;
		}else{
			show = false;
		}
		System.out.print("[内存块数]: " + sum_block + "\n");
		System.out.print("[页码集合]: \n");
		for(int i = 0; i < page.length; i++){
			page[i] = (int) (Math.random()*10);
			System.out.print(page[i] + "  ");
		}
		System.out.println("\n");
		System.out.println("******************************************************************");
		test.FIFO(page, block, show);
		test.LRU(page, block, show);
		test.OPT(page, block , show);
	}
	
	public void FIFO(int []page , int []block , boolean show){
		int index_old = 0 , pre = 0 , current = -1 , temp_c = -2;
		double time = 0;
		double ratio ; 
		boolean flag = false;
		
		System.out.println("[------------------------------- FIFO算法演示现场 -------------------------------]\n");
		
		for(int i = 0; i < block.length; i++){
			block[i] = -1;
		}
		for(int i = 0; i < page.length; i++){
			flag    = false;
			temp_c = current;
			current = -1;
			for(int j : block){
				if(page[i] == j)	{flag = true;	break;}
			}
			if(!flag){
				if(pre < block.length){
					current = pre++;
				}else{
					current = index_old++ % block.length;
				}
				block[current] = page[i];
			}
//			for(int k = 0; k < block.length; k++){
//				if(k == current){
//					System.err.print("[" + block[k] + "]\t");
//				}else{
//					System.out.print("[" + block[k] + "]\t");
//				}
//			}
			
			if(temp_c != current){
				time++ ;
			}
			
			if(show){
				System.out.print("-回合" + i + "-\t\t\t");
				for(int k : block){
					if(k == -1)	{
						System.out.print("[ ]\t");
					}else{
						System.out.print("[" + k + "]\t");
					}
				}
				if(temp_c != current){
					System.out.print("+");
				}
				
				System.out.println();
			}
		}
		ratio = new Double(( (page.length - time) / page.length) * 100);
		System.out.printf("FIFO算法的访问命中率为：    \t %.2f " , ratio);
		System.out.println("%\n");
	}
	
	public void LRU(int[] page , int[] block , boolean show){
		 int[] temp = new int[block.length];
		 int temp_c = -2;
		 double time = 0 , ratio;
		 int current = 0;
		 boolean flag = false;
		 
		 System.out.println("[------------------------------- LRU算法演示现场 -------------------------------]\n");
		 
		 for(int i = 0; i < temp.length; i++){
			 temp[i] = i;
			 block[i] = -1;
		 }
		 
		 for(int i = 0; i < page.length; i++){
			 flag = false;
			 temp_c = current;
			 for(int j = 0; j < block.length; j++){
				 if(page[i] == block[j]){ flag = true;  current = j; 	break;}
			 }
			 
			 if(!flag){
				 for(int j = 0; j < temp.length; j++){
					 if( temp[j] == 0 )	{	current = j; 	break;}
				 }
				 block[current] = page[i];
			 
				 for(int j = 0; j < temp.length; j++){
					 if(temp[j] > temp[current])	{ temp[j] = (temp[j] - 1) % 4;}
				 }
				 temp[current] = temp.length - 1;
			 }
			 
			 if(temp_c != current){
					time++ ;
				}
				if(show){
					System.out.print("-回合" + i + "-\t\t\t");
					for(int k : block){
						if(k == -1)	{
							System.out.print("[ ]\t");
						}else{
							System.out.print("[" + k + "]\t");
						}
					}
					if(temp_c != current){
						System.out.print("+");
					}
					
					System.out.println();
				}
			}
			ratio = new Double(( (page.length - time) / page.length) * 100);
			System.out.printf("LRU算法的访问命中率为：     \t %.2f " , ratio);
			System.out.println("%\n");
	 }
	
	public void OPT(int[] page , int[] block , boolean show){
		int[] temp = new int[block.length];
		int temp_c = -2;
		double time = 0, ratio = 0;
		int current = 0;
		boolean flag = false;
		
		System.out.println("[------------------------------- OPT算法演示现场 -------------------------------]\n");
		
		for(int i = 0; i < block.length; i++){
			block[i] = -1;
		}
		for(int i = 0; i < page.length; i++){
			flag = false;
			for(int j : block){	
				if(j == page[i])	{	flag = true;			}
			}
			temp_c = current;
			if(!flag){
				if(current < block.length){
					block[current++] = page[i];
				}else{
					temp = new int[block.length];
					for(int k = 0; k < temp.length; k++)
						for(int j = i; j < page.length ; j++)
							if(page[j] != block[k])	{	
								temp[k]++;
							} else{
								break;
							}
					current = getIndexOfMaxVal(temp);
					block[current] = page[i];
				}
			}
			if(temp_c != current){
				time++ ;
			}
			
			if(show){
				System.out.print("-回合" + i + "-\t\t\t");
				for(int k : block){
					if(k == -1)	{
						System.out.print("[ ]\t");
					}else{
						System.out.print("[" + k + "]\t");
					}
				}
				if(temp_c != current){
					System.out.print("+");
				}
				
				System.out.println();
			}
		}
		ratio = new Double(( (page.length - time) / page.length) * 100);
		System.out.printf("Optimal算法的访问命中率为：\t %.2f " , ratio);
		System.out.println("%\n");
	}
	
	public int getIndexOfMaxVal(int[] data){
		int maxVal = data[0];
		int maxInd = 0;
		for(int i = 1; i < data.length; i++){
			if(data[i] > maxVal){
				maxVal = data[i];
				maxInd = i;
			}
		}
//		System.out.println("maxInd=" + maxInd);
		return maxInd;
	}
	
}
