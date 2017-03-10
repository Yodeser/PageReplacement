package cn.yodes.OS.Main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

import cn.yodes.OS.Algorithm.PageReplacement;

public class Main {
	Scanner sc = new Scanner(new BufferedInputStream(System.in));
	int no_algorithm = -1;
	int sum_block	 =  0;
	int[] block		  	 ;
	int[] array_page;
	
	public void getData(){
		System.out.println("*********************页面置换算法演示系统*********************");
		System.out.println("【1】请选择您所要演示的页面置换算法：");
		System.out.println("\t 1.FIFO（先入先出） \t  2.LRU（最久未使用）  \t 3.OPT（最佳置换）");
		sc.reset();
		
		this.no_algorithm = sc.nextInt();
		System.out.println("\n【2】请输入内存块总数：");
		this.sum_block	 = sc.nextInt();
		System.out.println("\n【3】请输入所有的页码：");
		sc = new Scanner(new BufferedInputStream(System.in));
		initIntArray( sc.nextLine().split(" ") );
		System.out.println("***********************开始演示*****************************");
		System.out.print("[算法]: " + getAlgorithmName(no_algorithm) + "\t\t");
		System.out.print("[内存块数]: " + sum_block + "\n");
		System.out.print("[页码集合]: \n");
		printArray(array_page);
		System.out.println();
	}
	
	public void initIntArray(String[] arr_s){
		int i = 0;
		array_page = new int[arr_s.length];
		for(String s : arr_s){
			this.array_page[i++] = Integer.parseInt(s);
		}
		this.block = new int[sum_block];
	}
	
	public void printArray(int[] data){
		for(int i : data){
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public String getAlgorithmName(int number){
		switch(number){
			case 1 :  return "FIFO(先入先出)";
			case 2 :  return "LRU(最久未使用)";
			case 3 :  return "OPT(最佳置换)";
			default:  return "未知算法，输入有误";
		}
	}
	public void display(){
		PageReplacement pr = new PageReplacement();
		System.out.println("请选择：");
		System.out.println("1.自动演示\t\t\t2.手动演示");
		
		if(sc.nextInt() == 1){
			pr.display();
		}else{
			getData();
			
			switch(no_algorithm){
				case 1 :	pr.FIFO(array_page, block , true);		break;
				case 2 :	pr.LRU(array_page, block , true);		break;
				case 3 :	pr.OPT(array_page, block , true); 		break;
				case -1:	System.out.println("Sorry,You must choose one of these algorithms");
				default:	System.out.println("\t Thanks Your Using!\t");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new Main().display();
	}
}
