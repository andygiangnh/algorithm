package com.andy.algorithm;

public class FindMostOccuranceChar {
	
	public static void main(String[] args) {
		FindMostOccuranceChar fmo = new FindMostOccuranceChar("acabfcdkcffca");
		System.out.println(fmo.findBestChar());
	}
	
	private String s = "";
	
	public FindMostOccuranceChar(String s) {
		this.s = s;
	}
	
	public char findBestChar() {
		int[] occurance = new int[26];
		
		for(char c : s.toCharArray()) {
			occurance[c-'a']++;
		}
		
		char bestChar = 'a';
		int mostOccurance = 0;
		
		for(int i=0; i < 26; i++) {
			if(occurance[i] > mostOccurance) {
				mostOccurance = occurance[i];
				bestChar = (char)('a' + i);
			}
		}
		
		return bestChar;
	}
}
