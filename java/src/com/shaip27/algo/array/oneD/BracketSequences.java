package com.shaip27.algo.array.oneD;

import java.util.Scanner;

public class BracketSequences {

	public static void main(String[] args) {
		
		
		System.out.println("Hello World");

		
		
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr = new String[s.length()];
        
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=sc.nextLine();
        }
        
        System.err.println(arr);
        
        for (int i=(arr.length-1);i>=0;i--){
            System.out.println (arr[i]);
        }
        

	}

}
