package cn.yodes.OS.Algorithm;

public class LRU {
	 
	 public void start(int[] page , int[] block){
		 int[] temp = new int[block.length];
		 int current = 0;
		 boolean flag = false;
		 for(int i = 0; i < temp.length; i++){
			 temp[i] = i;
			 block[i] = -1;
		 }
		 
		 for(int i = 0; i < page.length; i++){
			 flag = false;
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
			 for(int k : block)
				 System.out.print(k + "\t");
			 System.out.println();
		 }
	 }
	 
	 public static void main(String[] args) {
		LRU test = new LRU();
		int sum_page = 20;
		int []page = new int[sum_page];
		
		int sum_block = 5;
		int[] block = new int[sum_block];
		for(int i = 0; i < page.length; i++){
			page[i] = (int) (Math.random()*10);
			System.out.print(page[i] + "  ");
		}
		System.out.println();
		
		test.start(page, block);
	}
}
