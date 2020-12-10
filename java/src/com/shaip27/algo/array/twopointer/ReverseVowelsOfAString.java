package com.shaip27.algo.array.twopointer;
/**
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".
 * 
 * */
public class ReverseVowelsOfAString {
	
	public String reverseVowels(String s) {
		
		char[] arr = s.toCharArray();
		int front = 0;
		int back=s.length()-1;
		
		while(front <= back) {
			char c = arr[front];
			if(isVowel(c)) {
				char b = arr[back];
				if(isVowel(b) && front != back){
					char tmp = arr[front];
					arr[front] = arr[back];
					arr[back] = tmp;
					front++;
					back--;
				}else {
					back--;
				}
			}else {
				front++;
			}
		}
		return new String(arr);
        
    }
	
	public boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
			c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		ReverseVowelsOfAString reverse = new ReverseVowelsOfAString();
		System.out.println("Reverse vowels of a string:" + reverse.reverseVowels("leetcode"));
	}

}
