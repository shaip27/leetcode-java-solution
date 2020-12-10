package com.shaip27.algo.array.twopointer;

public class RemoveDuplicatesFromSortedArray {
	
	
	 public int removeDuplicates(int[] nums) {
		 
		int i = 0;
		for(int j=1;j<nums.length;j++) {
			 if(nums[i]!=nums[j]) {
				 nums[i+1] = nums[j];
				 i++;
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
		RemoveDuplicatesFromSortedArray duplicate = new RemoveDuplicatesFromSortedArray();
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		// int[] arr = {1,1,2};
		
		System.out.println("Unique Array Length:" + duplicate.removeDuplicates(arr));
		
	}

}
