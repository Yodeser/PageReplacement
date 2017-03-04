package cn.yodes.OS.Algorithm;

public class FIFO {
	
	public void start(int []page , int []block){
		int index_old = 0 , pre = 0 , current = 0;
		boolean flag = false;
		
		for(int i = 0; i < block.length; i++){
			block[i] = -1;
		}
		for(int i = 0; i < page.length; i++){
			flag = false;
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
			for(int k : block){
				System.out.print(k + "\t");
			}
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		FIFO test = new FIFO();
		int sum_page = 20;
		int []page = new int[sum_page];
		
		int sum_block = 5;
		int[] block = new int[sum_block];
		for(int i = 0; i < page.length; i++){
			page[i] = (int) (Math.random()*10);
			System.out.print(page[i] + "  ");
		}
		System.out.println();
//		test.addEle(page, block);
		test.start(page, block);
	}
}
