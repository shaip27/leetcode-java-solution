package com.shaip27.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.

*/
public class WordPattern {
	
	public boolean wordPattern(String pattern, String s) {
		
		Map<Character,String> map = new HashMap<>();
		String[] values = s.split(" ");
		
		if(values.length != pattern.length()) {
			return false;
		}
		
		for(int i=0;i<values.length;i++) {
			if(!map.containsKey(pattern.charAt(i))) {
				if(!map.containsValue(values[i])) {
					map.put(pattern.charAt(i),values[i]);
				}else {
					return false;
				}
			}else {
				if (!(values[i].equalsIgnoreCase(map.get(pattern.charAt(i))))) {
					return false;
				}
			}
		}
		return true;
		
		/*
		 * 
		Map<String,Character> map = new HashMap<>();
		String[] values = s.split(" ");
		
		for(int i=0;i<values.length;i++) {
			
			if(!map.containsKey(values[i])) {
				map.put(values[i], pattern.charAt(i));
			}else {
				if (pattern.charAt(i)!=map.get(values[i])) {
					return false;
				}
			}
		}
		return true; 
		 * */
    }

	public static void main(String[] args) {
		
		WordPattern wp = new WordPattern();
		
		String pattern = "abba";
		String s = "dog cat cat dog";
		// String s = "dog cat cat fish";
		// String s = "dog dog dog dog";
		
		
		
		System.out.println("Word Paten matched:" + wp.wordPattern(pattern, s));

	}

}
