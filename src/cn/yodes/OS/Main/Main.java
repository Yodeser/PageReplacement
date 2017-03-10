package cn.yodes.OS.Main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

import cn.yodes.OS.Algorithm.*;

public class Main {
	Scanner sc = new Scanner(new BufferedInputStream(System.in));
	int no_algorithm = -1;
	int sum_block	 =  0;
	int[] block		  	 ;
	int[] array_page = null;
	
	public void getData(){
		System.out.println("��1����ѡ������Ҫ��ʾ��ҳ���û��㷨��");
		System.out.println("\t 1.FIFO�������ȳ��� \t  2.LRU�����δʹ�ã�  \t 3.OPT������û���");
		this.no_algorithm = sc.nextInt();
		System.out.println("\n��2���������ڴ��������");
		this.sum_block	 = sc.nextInt();
		System.out.println("\n��3�����������е�ҳ�룺");
		System.out.println(sc.nextLine());
//		initIntArray( sc.nextLine().split(" ") );
	}
	
	public void initIntArray(String[] arr_s){
		int i = 0;
		for(String s : arr_s){
			this.array_page[i++] = Integer.parseInt(s);
		}
		this.block = new int[sum_block];
	}
	
	public void display(){
		getData();
		switch(no_algorithm){
			case 1 :	new FIFO().start(array_page, block);	break;
			case 2 :	new LRU().start(array_page, block);		break;
			case 3 :	new Optimal().start(array_page, block); break;
			case -1:	System.out.println("Sorry,You must choose one of these algorithms");
			default:	System.out.println("\t Thanks Your Using!\t");
		}
	}
	public static void main(String[] args) throws IOException {
		new Main().display();
	}
}
