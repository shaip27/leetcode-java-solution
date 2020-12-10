package com.shaip27.algo.array.twopointer;

public class RemoveDuplicatesFromArray {
	
	
	 public int removeDuplicates(int[] nums, int val) {
		 
		int i = 0;
		for(int j=0;j<nums.length;j++) {
			 if(nums[j]!= val) {
				 nums[i++] = nums[j];
			 } 
		}
		
		System.out.print("{");
		for(int a : nums) {
			System.out.print(a+",");
		}
		System.out.print("}");
		System.out.println();
		
		 return i+1;
	 }
	 
	public static void main(String[] args) {
		RemoveDuplicatesFromArray duplicate = new RemoveDuplicatesFromArray();
		int[] arr = {0,1,2,2,3,0,4,2};
		// int[] arr = {1,1,2};
		
		System.out.println("Unique Array Length:" + duplicate.removeDuplicates(arr,2));
		
	}

}
