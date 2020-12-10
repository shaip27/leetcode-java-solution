package com.shaip27.algo.array.oneD;

import java.util.Scanner;

public class PrintArrayReverse {

	public static void main(String[] args) {
		
		
		System.out.println("Hello World");
//		
//		int[] inputArray = {5,4,12,7,15,9};
//		
//		System.out.println("Length:" + inputArray.length);
//
//        for (int i=(inputArray.length-1);i>=0;i--){
//            System.out.println (inputArray[i]);
//        }
		
		
		Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int[] arr = new int[s];
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=sc.nextInt();
        }
        
        for (int i=(arr.length-1);i>=0;i--){
            System.out.println (arr[i]);
        }
        

	}

}
