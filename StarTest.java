public class StarTest {
	public static void main(String[] args) {
		printStar(2);
		printStar(3);
		printStar(4);

		printStarRec(6);
		printStarRec(6);
		printStarRec(8);
		printStarRec(20);
	}

	/*
	Print the dimond shape with X
	*/
	private static void printStar(int mid) {
		int N = mid * 2; // dimond shape need to have odd number of rows (rows = colums)
		// thus rows = N + 1 (2k+1 is odd)

		for (int j = 0; j <= N;j++) {
			for (int i = 0; i <= N; i++) {
				if (j <= N/2) { // 1st half
					if (i < N/2 - j)
						System.out.print(" ");
					else if (i <= N/2 + j) {
						if(i == j || (i + j)==N)
							System.out.print("+");
						else
							System.out.print("*");
					}
				}
				else { // 2nd half
					if (i < j - N/2)
						System.out.print(" ");
					else if (i <= N-(j-N/2))
						if(i == j || (i + j)==N)
							System.out.print("+");
						else
							System.out.print("*");
				}
			}				
			System.out.println();
		}
	}

	private static void printStarRec(int mid) {
		int N = mid * 2; // dimond shape need to have odd number of rows (rows = colums)
		// thus rows = N + 1 (2k+1 is odd)
		
		int k = N/2;
		if (k%2 == 0) // k has to be an odd number
			k++;

		System.out.println("k="+k);

		for (int j = 0; j <= N;j++) {
			for (int i = 0; i <= N; i++) {
				if (j <= N/2) { // 1st half
					if (i < N/2 - j)
						System.out.print(" ");
					else if (i <= N/2 + j) {
						if((i > (N-k)/2 && i <= (N+k)/2) && (j > (N-k)/2 && j <= (N+k)/2))
							System.out.print("-");
						else
							System.out.print("*");
					}
				}
				else { // 2nd half
					if (i < j - N/2)
						System.out.print(" ");
					else if (i <= N-(j-N/2)) {
						if((i > (N-k)/2 && i <= (N+k)/2) && (j > (N-k)/2 && j <= (N+k)/2))
							System.out.print("-");
						else
							System.out.print("*");
					}
				}
			}				
			System.out.println();
		}
	}
}