package history;

import java.util.Scanner;

public class NQueen {
	public static int[] col;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int j = 0; j < numTestCase; j++) {
			System.out.println(">> input n (nXn size board)");
			int n = in.nextInt();
			col = new int[n];
			queen(0,n);
			for(int i = 0; i < n; i++) {
				System.out.print("row["+(i+1)+"]: ");
				System.out.print(col[i]+1 + "	");
			}
			System.out.println();
		}	
	}
	
	public static int queen(int n, int N) {
		if(n == N) {
			return 1;
		}
		for(int i = 0; i < N; i++) {
			col[n] = i;
			if(isPromising(n) == 1) {
				if(queen(n+1, N) == 1) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static int isPromising(int row) {
		for(int i = 0; i < row; i++) {
			if(col[i] == col[row] || Math.abs(col[i] - col[row]) == row-i) {
				return 0;
			}
		}
		return 1;
	}
}
