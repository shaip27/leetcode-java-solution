package com.shaip27.algo.array.twopointer;

/**
 * The volume of the container is computed as S(i,j)=(j−i)min(ai,aj). 
 * We put the left pointer at the first wall and put the right pointer at the last wall respectively. 
 * In each step, if the left wall is shorter than the right wall, 
 * we move the left pointer right by one, and similarly, 
 * if the right wall is shorter than the left wall,
 *  we move the right pointer left by one, until the left wall meets the right wall. 
 *  In each step, we also compute the volume of the container, 
 *  keep the maximum volume and optionally the corresponding container wall indices.
 *  
 *  <p>The gut feeling is that we are decreasing the value of (j−i) after each step, 
 *  using the above method would find larger min(ai,aj), 
 *  and therefore a possible candidate for maximum volume. 
 *  It would only need to compute the area at most n−1 times (you could do some simple wall height comparisons to avoid area computation sometimes if you want to further optimize the algorithm), 
 *  while the brute force combination needs to compute the area n(n−1)2 times. 
 *  Therefore, the asymptotic runtime complexity is O(n) and the space complexity is also O(1).
 *  */

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		
		int left=0;
		int right = height.length -1;
		int maxVolumn = -1;
		int volumn = 0;
		
		while(left < right) {
			
			if(height[left] < height[right]) {
				volumn = (right-left) * height[left];
				left++;
			}else {
				volumn = (right-left) * height[right];
				right--;
			}
			if(volumn > maxVolumn) 
				maxVolumn = volumn;
		}
		
		
		return maxVolumn;
    }

	public static void main(String[] args) {
		
		ContainerWithMostWater cwater = new ContainerWithMostWater();
		// int[] height = {1,8,6,2,5,4,8,3,7};
		int[] height = {4,3,2,1,4};
		
		System.out.println("Container With Most Water:" + cwater.maxArea(height));
		
		
	}

}
