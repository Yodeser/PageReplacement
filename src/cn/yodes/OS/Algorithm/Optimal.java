package cn.yodes.OS.Algorithm;

public class Optimal {
	
	public void start(int[] page , int[] block){
		int[] temp = new int[block.length];
		int current = 0;
		boolean flag = false;
		for(int i = 0; i < block.length; i++){
			block[i] = -1;
		}
		for(int i = 0; i < page.length; i++){
			flag = false;
			for(int j : block){	
				if(j == page[i])	{	flag = true;			}
			}
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
//					System.out.print("m:");
//					for(int m : temp){
//						System.out.print(m + "\t");
//					}
					block[current] = page[i];
				}
			}
//			for(int l : block){
//				System.out.print(l + "\t");
//			}
			System.out.println();
		}
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
	public static void main(String[] args) {
		Optimal Test = new Optimal();
		int sum_page = 20;
		int []page = new int[sum_page];
		
		int sum_block = 5;
		int[] block = new int[sum_block];
		for(int i = 0; i < page.length; i++){
			page[i] = (int) (Math.random()*10);
			System.out.print(page[i] + "  ");
		}
		System.out.println();
		Test.start(page, block);
	}
}
