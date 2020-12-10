package com.shaip27.algo.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and number K, write a program to find the number of pairs which has sum equal to K.
 * 

int input [] = {6, 3, 2, 9, 2, 2, 2, 1}
int K = 4
Output: 7

int input [] = {5, 5, 5, 5}
int K = 10
Output: 6

int input [] = {1, 2, 3, 4}
int K = 5
Output: 2
*/

public class CountPairInGivenSum {
	
	private int findPairs(int[] nums, int target) {
		
		Map<Integer,Integer> pairMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(!pairMap.containsKey(nums[i])) {
				pairMap.put(nums[i],0);				
			}
			pairMap.put(nums[i],(pairMap.get(nums[i])+1));
		}
		
		int twiceCount = 0; 
		
		for(int i=0;i<nums.length;i++) {
			
			if(pairMap.get(target - nums[i])!=null) {
				twiceCount += pairMap.get(target - nums[i]);
			}
			
			if (target-nums[i] == nums[i]) {
				twiceCount --;
			}
		}
		
		return twiceCount/2;
	}

	public static void main(String[] args) {
		
		CountPairInGivenSum pair = new CountPairInGivenSum();
		// int[] nums = {1,1,2,45,46,46}; // target 47
		// System.out.println("Number of pairs count:" + pair.findUniquePairs(nums, 47));
		
		// int[] nums = {5,5,5,5}; //Target 10
		int[] nums = {6, 3, 2, 9, 2, 2, 2, 1}; //Target 4
		System.out.println("Number of pairs count:" + pair.findPairs(nums, 4));

		

	}

}
