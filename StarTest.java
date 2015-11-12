public class StarTest {
	public static void main(String[] args) {
		int M = 7;
		int N = M * 2;
		
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
}