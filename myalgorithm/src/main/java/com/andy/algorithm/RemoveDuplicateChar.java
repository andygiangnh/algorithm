package com.andy.algorithm;
import java.util.Set;
import java.util.HashSet;
public class RemoveDuplicateChar {
	
	public static void main(String[] args) {
		String str = "abfabddacbf";
		
		Set<Character> allChars = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (allChars.contains(c)) {
				// remove at char at i
				str = str.substring(0,i) + str.substring(i+1, str.length());
				// place the cursor 1 step back as we have remove the duplicated char at index i
				i--;
			} else {
				allChars.add(c);
				
			}
		}

		System.out.println(str);
	}
}