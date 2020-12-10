package com.shaip27.algo.array.twopointer;

public class ReverseString {
	
	public void reverseString(char[] s) {
		
		int first=0;
		int last=s.length-1;
		
		for(;first<=last;first++,last--) {
			char tmp = s[first];
			s[first] = s[last];
			s[last] = tmp;
		}
		
		System.out.println("Revers String:" +new String(s) );
        
    }

	public static void main(String[] args) {
		
		ReverseString rt = new ReverseString();
		
		char[] s = {'h','e','l','l','o'};
		rt.reverseString(s);
				
	}

}
