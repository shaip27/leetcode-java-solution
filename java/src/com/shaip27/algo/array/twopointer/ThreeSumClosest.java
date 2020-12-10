package com.shaip27.algo.array.twopointer;

import java.util.Arrays;
/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*
*<p> 1. Initialize the minimum difference diff with a large value.
<p> 2. Sort the input array nums.
<p> 3. Iterate through the array:
		For the current position i, set lo to i + 1, and hi to the last index.
		While the lo pointer is smaller than hi:
			Set sum to nums[i] + nums[lo] + nums[hi].
			If the absolute difference between sum and target is smaller than the absolute value of diff:
				Set diff to target - sum.
		If sum is less than target, increment lo.
		Else, decrement hi.
	If diff is zero, break from the loop.
<p> 4. Return the value of the closest triplet, which is target - diff.
*
*
*/
public class ThreeSumClosest {
	
	 public int threeSumClosest(int[] nums, int target) {
		 
		 Arrays.sort(nums);
		 int diff = Integer.MAX_VALUE;
		 
		 for(int i=0;i<nums.length;i++) {
			 int low = i+1;
			 int high = nums.length -1;
			 
			 while(low<high) {
				 int sum = nums[i] + nums[low] +nums[high];
				 
				 if(Math.abs(target-sum) < Math.abs(diff)) {
					 diff = target - sum;
				 }
				 
				 if(sum < target) {
					 ++low;
				 }else {
					 --high;
				 }
			 }
		 }
		 
		 return (target-diff);
		 
	 }

	public static void main(String[] args) {
		
		ThreeSumClosest tsc = new ThreeSumClosest();
		// int[] nums = {-1,2,1,-4}; //target 1 answer is 2
		int[] nums = {1,2,4,8,16,32,64,128}; // target 82 answer is 82
		System.out.println("Three sum closest:" + tsc.threeSumClosest(nums, 82));
		

	}

}
