package com.andy.algorithm;

public class ZipString {
	
	public static void main(String[] args) {
		ZipString zb = new ZipString(123456, 8943);
		System.out.println(zb.zip());
	}
	
	private String s1;
	private String s2;
	
	public ZipString(int n1, int n2) {
		this.s1 = "" + n1;
		this.s2 = "" + n2;
	}
	
	public String zip() {
		boolean isFirstLonger = s1.length() - s2.length() >= 0;
		int minLength = isFirstLonger? s2.length():s1.length();
		
		String postfix = isFirstLonger? s1.substring(minLength, s1.length()) : s2.substring(minLength, s2.length());
		
		StringBuilder zippedSb = new StringBuilder();
		for(int i = 0; i < minLength; i++) {
			zippedSb.append(s1.charAt(i));
			zippedSb.append(s2.charAt(i));
		}
		
		zippedSb.append(postfix);
		
		return zippedSb.toString();
	}

}
