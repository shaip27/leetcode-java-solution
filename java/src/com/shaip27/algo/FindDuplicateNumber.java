package com.shaip27.algo;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1: Input: [1,3,4,2,2] -> Output: 2 
 * Example 2: Input: [3,1,3,4,2] -> Output: 3
 */
public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		
		int fast=2;
		for (int slow =0; slow < nums.length; slow++, fast++) {
			if(fast >= nums.length) {
				fast = 0;
			}	
			if(fast == slow) {
				return nums[slow];
			}
		}
		return 0;

	}

	public static void main(String[] args) {

		FindDuplicateNumber duplicateFinder = new FindDuplicateNumber();
		int[] nums = { 3,1,3,4,2 };
		// int[] nums = {1,3,4,2,2};
		int missedNumber = duplicateFinder.findDuplicate(nums);
		System.out.println("Duplicate number is:" + missedNumber);

	}

}
