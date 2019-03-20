package com.andy.algorithm;

public class NumberUtil {
	
	public static void printIntArr(int[] ar) {
		for(int i=0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}
	
	/*
	 * Generate an array of sorted integer, increased by @Param maxStep
	 * */
	public static void initIntArr(int[] ar, int maxStep) {
		for(int i=0;i < ar.length;i++) {
			int j = i>0? i-1:i;
			ar[i] = ar[j] + (int)(Math.random() * maxStep);
		}
	}	

}
