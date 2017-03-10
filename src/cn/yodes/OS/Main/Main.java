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
		System.out.println("【1】请选择您所要演示的页面置换算法：");
		System.out.println("\t 1.FIFO（先入先出） \t  2.LRU（最久未使用）  \t 3.OPT（最佳置换）");
		this.no_algorithm = sc.nextInt();
		System.out.println("\n【2】请输入内存块总数：");
		this.sum_block	 = sc.nextInt();
		System.out.println("\n【3】请输入所有的页码：");
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
