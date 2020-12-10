package com.shaip27.algo.array.twopointer;

/**
 * https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46
 * @author shaival_parekh
 *
 *
<p>Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

<p>Follow up: The overall run time complexity should be O(log (m+n)).

 

<li>Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.</li>

<li>Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.</li>

<li>Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000</li>

<li>Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000</li>

<li>Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000</li>


<p>Constraints:
<li>nums1.length == m</li>
<li>nums2.length == n</li>
<li>0 <= m <= 1000</li>
<li>0 <= n <= 1000</li>
<li>1 <= m + n <= 2000</li>
<li>-106 <= nums1[i], nums2[i] <= 106</li>
 */

public class MedianOfTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int medianIndex = (int)Math.ceil((nums1.length+nums2.length)/2.0)-1;
		int needAverage = (nums1.length+nums2.length)%2;
		int[] arr = merge(nums1, nums2);
		if (needAverage == 0) {
            return (arr[medianIndex]+arr[medianIndex+1])/2.0;
        }
        return arr[medianIndex];
    }

	private int[] merge(int[] nums1, int[] nums2) {
		
		int i=0, j=0;
		int mergedArray[] = new int [nums1.length+nums2.length];
		int medianIndex = (int)Math.ceil((nums1.length+nums2.length)/2.0);
		int high = medianIndex+1;
		
		while(i+j < mergedArray.length) {
			if(i == nums1.length) {
				mergedArray[i+j] = nums2[j++];
			}
			else if(j== nums2.length) {
				mergedArray[i+j] = nums1[i++];
			}
			else if(nums1[i] < nums2[j]) {
				mergedArray[i+j] = nums1[i++];
			}
			else  {
				mergedArray[i+j] = nums2[j++];
			}
			
			if (i + j == high) {
				break;
			}
		}
		
		return mergedArray;
	}

	
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		
		int num1Index = 0;
        int num2Index = 0;
        int merged = (nums1.length+nums2.length);
        int medianIndex = merged/2 + 1;
        double previousValue = 0;
        double currentValue = 0;
        
        for (int i=0; i< medianIndex;i++) {
            previousValue = currentValue;
            
            if (num1Index>= nums1.length) {
                currentValue = nums2[num2Index++];
                
            } else if (num2Index>= nums2.length) {
                currentValue = nums1[num1Index++];
               
            } else if (nums1[num1Index]<nums2[num2Index]) {
                currentValue = nums1[num1Index++];
               
            } else {
                currentValue = nums2[num2Index++];
                
            }
        }
        if (merged%2 == 0) {
            currentValue = (previousValue + currentValue)/2;
        }
        return currentValue;
		
	}
	
	
public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		
		int nums1Index = 0;
		int nums2Index = 0;
		int merged = (nums1.length + nums2.length);
		int medianIndex = merged/2 + 1;
		double value = 0, previousValue = 0;
		
		for(int i=0; i< medianIndex; i++) {
			previousValue = value;
			
			if(nums1Index >= nums1.length) {
				value = nums2[nums2Index++];
				
			}else if(nums2Index >= nums2.length) {
				value = nums1[nums1Index++];
				
			}else if (nums1[nums1Index] < nums2[nums2Index]) {
				value = nums1[nums1Index++];
				
			}else {
				value = nums2[nums2Index++];
			}
		}
		if(merged%2 == 0) {
			value = (previousValue + value  )/2;
		}		
		return value;
		
	}
	
	public static void main(String[] args) {
		
		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
//		int[] nums1 = {4,20,32,50,55,61};
//		int[] nums2 = {1,15,22,30,70};
		
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		System.out.println("Median point is:" + median.findMedianSortedArrays3(nums1, nums2));

	}

}
