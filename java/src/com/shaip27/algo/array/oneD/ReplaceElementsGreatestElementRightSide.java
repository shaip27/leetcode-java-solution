package com.shaip27.algo.array.oneD;

public class ReplaceElementsGreatestElementRightSide {
	
	 public int[] replaceElements(int[] arr) {
		 
		 int max = -1;
		 for(int i=arr.length-1 ; i>=0 ;i--) {
			 int val = arr[i];
			 arr[i] = max;
			 max = Math.max(max, val);
		 }
		 return arr;
	        
	 }

	public static void main(String[] args) {
		
		ReplaceElementsGreatestElementRightSide replace = new ReplaceElementsGreatestElementRightSide();
		
		int[] arr = {17,18,5,4,6,1};
		
		System.out.print("Intput is [");
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("]");
		System.out.println();
		
		int[] output = replace.replaceElements(arr);
		
		System.out.print("Output is [");
		for (int i=0;i<output.length;i++) {
			System.out.print(output[i]+",");
		}
		System.out.println("]");
		System.out.println();
		

	}

}
