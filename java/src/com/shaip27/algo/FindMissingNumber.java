package com.shaival.algo;
/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * Example 1: Input: [3,0,1] -> Output: 2
 * Example 2: Input: [9,6,4,2,3,5,7,0,1]  -> 8
 * */
public class FindMissingNumber {

	public int missingNumber(int[] nums) {		
		int sum = (nums.length * (nums.length +1))/2;
		for(int i=0; i < nums.length; i++) {
			sum = sum - nums[i];
			
		}
		return sum;
	}

	public static void main(String[] args) {
		
		FindMissingNumber ms = new FindMissingNumber();
		int[] nums = {9,6,4,2,3,5,7,0,1};
		int missedNumber = ms.missingNumber(nums);
		System.out.println("Missing number is:" + missedNumber);

	}

}
