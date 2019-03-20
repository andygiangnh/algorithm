package com.andy.algorithm;

public class FindPair {
	
	public static void main(String[] args) {
		int[] ar = new int[10];
		NumberUtil.initIntArr(ar, 4);
		NumberUtil.printIntArr(ar);
		
		int[] resInt = findPair(ar, 12);
		System.out.println("Found i=" + resInt[0] + ",j=" + resInt[1]);
		System.out.println("Found Ar[i]=" + ar[resInt[0]] + ",Ar[j]=" + ar[resInt[1]]);
	}
	
	private static int[] findPair(int[] ar, int sum) {
		int i=0, j = ar.length-1;
		int[] resIntAr = new int[2];
		resIntAr[0] = -1;
		resIntAr[1] = -1;
		
		while(i<j) {
			System.out.println("i=" + i + ",j=" + j);
			if(ar[i] + ar[j] > sum) {
				j--;
			} else if (ar[i] + ar[j] < sum) {
				i++;
			} else {
				resIntAr[0] = i;
				resIntAr[1] = j;
				break;
			}
		}
		
		return resIntAr;
	}
}
