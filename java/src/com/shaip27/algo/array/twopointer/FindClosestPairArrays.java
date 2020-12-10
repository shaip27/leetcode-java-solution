package com.shaip27.algo.array.twopointer;

import java.util.Arrays;

public class FindClosestPairArrays {
	
	
	public int[] findClosestPairTwoSortedArray(int[] nums1, int[] nums2, int target) {
		
		int left = 0;
		int right = nums2.length -1;
		int ls = nums1.length;
		int[] result = {-1,-1};
		int diff = Integer.MAX_VALUE;

		while(left < ls && right >= 0) {
			
			int sum = nums1[left] + nums2[right];
			
			if(Math.abs(sum - target) < diff) {
				diff = Math.abs(sum - target);
				result[0] = left;
				result[1] = right;
			}
			if(sum >= target) {
				right --;
			}else {
				left ++;
			}
		}
		return result;
	}
	
	
	public int[] findClosestPairArray(int[] nums, int target) {
		
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length-1;
		int[] result = {-1,-1};
		int diff = Integer.MAX_VALUE;
		
		while ( left < right ) {
			int sum = nums[left] + nums[right];
			if(Math.abs(sum - target) < diff) {
				diff = Math.abs(sum - target);
				result[0] = left;
				result[1] = right;
			}
			if(sum > target) {
				right --;
			}else {
				left ++;
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		FindClosestPairArrays find = new FindClosestPairArrays();
		
		int[] nums = {1,2,3,4,5};
		int target = 10;
		int[] result = find.findClosestPairArray(nums, target);
		System.out.println("Closest Pair is: [" + nums[result[0]] + "," + nums[result[1]] + "] for a target: " + target);
		
		int[] nums1 = {1, 4, 5, 7};
		int[] nums2 = {10, 20, 30, 40};
		int targetNo = 32;
		
		int[] ans = find.findClosestPairTwoSortedArray(nums1, nums2,targetNo);
		System.out.println("Closest Pair is: [" + nums1[ans[0]] + "," + nums2[ans[1]] + "] for a target: " + targetNo);
		
	}

}
