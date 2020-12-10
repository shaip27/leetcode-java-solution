package com.shaip27.algo.array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 * 
 * */
public class ThreeSum {
	
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		
		//Step2: loop over all elemnts
        //nums.length -2 as we require 2 numbers
		for(int i=0;i<nums.length-2;i++) {
			
			if(i==0 || (i >0 && nums[i] != nums[i-1])) {
				int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                
                //step4: two pointer loop to get the next 2 nos
                while(low < high){
                    //step5: check for confition on which side to move the high and low pointer
                    if(nums[low] + nums[high] == sum){
                    	result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //check that next elements are not same
                        while(low < high && nums[low] == nums[low + 1])low++;
                        while(low < high && nums[high] == nums[high - 1])high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum)
                        high--;
                    else
                        low++;
                }
			}
		}
		return result;
	}
	
	
	public List<List<Integer>> threeSums(int[] nums) {
		
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);

		for(int i=0;i<nums.length-2;i++) {	
			
			int low = i + 1;
            int high = nums.length - 1;
            
            while(low < high) {
            	int sum = nums[i]+nums[low]+nums[high];
            	
            	if(sum==0) {
            		result.add(Arrays.asList(nums[i],nums[low],nums[high]));
            		low++;
            		high--;
            	}else if (sum > 0) {
            		high--;
            	}else if (sum < 0) {
            		low++;
            	}
            }
		}
		return new ArrayList<>(result);
		 
	}

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] arr = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> result = ts.threeSum(arr);
		System.out.println("Results:" + result);
		
		List<List<Integer>> result1 = ts.threeSums(arr);
		System.out.println("Results With Set:" + result1);

	}

}
