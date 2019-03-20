package com.andy.algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	public static void main(String[] args) {
		StringPermutation p = new StringPermutation("abcdef");
		p.permutation();
		System.out.println("Total number of permutation: " + p.permutations.size());
		p.print();
	}
	
	private String str = "";
	private List<String> permutations = new ArrayList<>();
	
	public StringPermutation(String s) {
		str = s;
	}
	
	public void print() {
		permutations.forEach(p->System.out.println(p));
	}

	public void permutation() { 
	    permutation("", str); 
	}

	private void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) permutations.add(prefix);
	    else {
	        for (int i = 0; i < n; i++) {
	            String nextPrefix = prefix + str.charAt(i);
	            String nextStr = str.substring(0, i) + str.substring(i+1, n);
	        	permutation(nextPrefix, nextStr);
	        }
	    }
	}
}