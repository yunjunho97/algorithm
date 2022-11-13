package history;

import java.util.Scanner;

public class Cmm_DP {
	static int[][] M;
	static int[][] S;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int i = 0; i < numTestCase; i++) {
			System.out.println(">> input how many Matrix");
			int n = in.nextInt();
			int[] list = new int[n+1];
			System.out.println(">> ex) M1 = 20 X 2, M2 = 2 X 10 ==input==> 20 2 10");
			M = new int[n][n];
			S = new int[n][n];
			for(int j = 0; j < n+1; j++) {
				list[j] = in.nextInt();
			}
			cmm(list, 0, n);
			System.out.println("optimal order of multiply matrix");
			printCMM(list, 0, n-1);
			System.out.println();
			System.out.println("minimum number of multiply");
			System.out.println(M[0][n-1]);
		}
	}
	
	public static void cmm(int[] list, int start, int end) {
		for(int i = 0; i < end; i++) {
			for(int j = i; j >= 0; j--) {
				if(i == j) {
					M[j][i] = 0;
				} else {
					for(int k = j; k < i; k++) {
						int temp = M[j][k] + M[k+1][i] + list[j]*list[k+1]*list[i+1];
						if(M[j][i] == 0 || M[j][i] > temp) {
							M[j][i] = temp;
							S[j][i] = k;
						}
					}
				}
			}
		}
	}
	
	public static void printCMM(int[] list, int start, int end) {
		int k = S[start][end];
		if(start == end) {
			System.out.print("M"+(start+1));
			return ;
		}
		System.out.print("(");
		printCMM(list, start, k);
		printCMM(list, k+1, end);
		System.out.print(")");
	}
}
