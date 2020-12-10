package com.shaip27.algo.string;

import java.util.Stack;

/***
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

<p>An input string is valid if:
<p>Open brackets must be closed by the same type of brackets.
<p>Open brackets must be closed in the correct order.	
	
	<p>Example 1:
	Input: "()"
	Output: True
	
	Example 2:
	Input: s = "()[]{}"
	Output: True
	
	Example 3:
	Input: s = "(]"
	Output: False
	
	Example 4:
	Input: s = "([)]"
	Output: False
	
	Example 5:
	Input: s = "{[]}"
	Output: True
	
	Note:
	The string size will be in the range [1, 100].
 * 
 * */
public class ValidParenthesesNextLevel {
	
	
	public boolean isValid(String s) {
		
		Stack<Character> brackets = new Stack<>();
		for(char c : s.toCharArray()) {
			
			if (c == '(' || c=='[' || c=='{') {
				brackets.push(c);
			}
			else if (c==')' && !brackets.isEmpty() && brackets.peek()=='(') {
				brackets.pop();
			}
			else if (c==']' && !brackets.isEmpty() && brackets.peek()=='[') {
				brackets.pop();
			}
			else if (c=='}' && !brackets.isEmpty() && brackets.peek()=='{') {
				brackets.pop();
			}else {
				return false;
			}
		}
		System.out.println();
		return brackets.isEmpty();
	}

	public static void main(String[] args) {
		
		ValidParenthesesNextLevel vp = new ValidParenthesesNextLevel();
		// System.out.println(vp.isValid("([{}])[())]"));
		System.out.println(vp.isValid("((([)))"));
		
	}

}


