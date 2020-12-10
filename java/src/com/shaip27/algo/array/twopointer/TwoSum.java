package com.shaip27.algo.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

<p>Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

<p>Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
		 
		int[] resultIndex = new int[2];
		Map<Integer,Integer> numMap = new HashMap<>(); 
		for(int n=0;n < nums.length ; n++) {
			 if(!numMap.containsKey(nums[n])) {
				 numMap.put(target-nums[n], n);
			 }else {
				 resultIndex[0] = numMap.get(nums[n]);
				 resultIndex[1] = n;
				 break;
			 }
		 }
		 return resultIndex;
	 }

	public static void main(String[] args) {
		
		TwoSum ts = new TwoSum();
		
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] answer = ts.twoSum(nums, 9);
		
		System.out.println("output index is: ["+ answer[0]+"],["+ answer[1] +"]");
		System.out.println("Target number is:"+ target + "=" + nums[answer[0]] + "+" +nums[answer[1]]);
		
	}

}
