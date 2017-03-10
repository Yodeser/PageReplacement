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
		System.out.println("*********************ҳ���û��㷨��ʾϵͳ*********************");
		System.out.println("��1����ѡ������Ҫ��ʾ��ҳ���û��㷨��");
		System.out.println("\t 1.FIFO�������ȳ��� \t  2.LRU�����δʹ�ã�  \t 3.OPT������û���");
		sc.reset();
		
		this.no_algorithm = sc.nextInt();
		System.out.println("\n��2���������ڴ��������");
		this.sum_block	 = sc.nextInt();
		System.out.println("\n��3�����������е�ҳ�룺");
		sc = new Scanner(new BufferedInputStream(System.in));
		initIntArray( sc.nextLine().split(" ") );
		System.out.println("***********************��ʼ��ʾ*****************************");
		System.out.print("[�㷨]: " + getAlgorithmName(no_algorithm) + "\t\t");
		System.out.print("[�ڴ����]: " + sum_block + "\n");
		System.out.print("[ҳ�뼯��]: \n");
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
			case 1 :  return "FIFO(�����ȳ�)";
			case 2 :  return "LRU(���δʹ��)";
			case 3 :  return "OPT(����û�)";
			default:  return "δ֪�㷨����������";
		}
	}
	public void display(){
		PageReplacement pr = new PageReplacement();
		System.out.println("��ѡ��");
		System.out.println("1.�Զ���ʾ\t\t\t2.�ֶ���ʾ");
		
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
