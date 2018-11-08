
public class BinSearch {
	
	public static void main(String[] args) {
		int[] a = new int[10];
		NumberUtil.initIntArr(a, 10);
		
		NumberUtil.printIntArr(a);
		System.out.println("========x=30========");
		System.out.println(binSearch(a, 30, 0, a.length-1));
		NumberUtil.printIntArr(a);
		System.out.println("========x=31========");
		System.out.println(binSearch(a, 31, 0, a.length-1));
		NumberUtil.printIntArr(a);
		System.out.println("========x=32========");
		System.out.println(binSearch(a, 32, 0, a.length-1));
		NumberUtil.printIntArr(a);
		System.out.println("========x=33========");
		System.out.println(binSearch(a, 33, 0, a.length-1));
	}
	
	private static int binSearch(int[] ar, int val, int s, int e) {
		int m = (s+e)/2;
		System.out.println("s=" + s + ",e=" + e + ",m=" + m );
		System.out.println("A[m]=" + ar[m]);
		if(s == e && val == ar[s])
			return s;
		if(s < e) {		
			if(val < ar[m])
				return binSearch(ar, val,s,m-1);
			else if(val > ar[m])
				return binSearch(ar, val, m+1, e);
			else if(val == ar[m])
				return m;
		} 
		return -1;
	}

}
