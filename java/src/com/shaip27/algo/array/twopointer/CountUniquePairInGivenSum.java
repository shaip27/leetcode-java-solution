package com.shaip27.algo.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
Example 2:

Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2
Example 3:

Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
Related problems:

https://leetcode.com/problems/two-sum
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
*/

public class CountUniquePairInGivenSum {
	
	private int findUniquePairs(int[] nums, int target) {
		
		Map<Integer,Integer> pairMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(!pairMap.containsKey(target - nums[i])) {
				if(!pairMap.containsValue(target - nums[i]))
				{
					pairMap.put(target - nums[i], nums[i]);
				}
			}
		}
		return pairMap.size();
	}

	public static void main(String[] args) {
		
		CountUniquePairInGivenSum pair = new CountUniquePairInGivenSum();
		// int[] nums = {1,1,2,45,46,46}; // target 47
		// System.out.println("Number of pairs count:" + pair.findUniquePairs(nums, 47));
		
		int[] nums = {1,5,1,5};
		System.out.println("Number of pairs count:" + pair.findUniquePairs(nums, 6));

		

	}

}
