package com.shaip27.algo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Given a string s, find the length of the longest substring without repeating characters.
<p>Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0
 

<p>Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		int j = 0;
		int max = 0;
		
		Set<Character> window = new HashSet<>();
		while(j<s.length()) {
			
			if(!window.contains(s.charAt(j))) {
				window.add(s.charAt(j));
				j++;
				max = Math.max(window.size(), max);
			}else {
				window.remove(s.charAt(i));
				i++;
			}
		}
		return max;   
	}
	
	
	public  int optimisedSolution(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
		
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters st = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println("Longest Substring Without Repeating Characters :" + st.lengthOfLongestSubstring("pwwpkew"));

	}

}
