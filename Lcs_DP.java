package history;

import java.util.Scanner;

public class Lcs_DP {
	static int[][] S;
	static int[][] T;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int i = 0; i < numTestCase; i++) {
			System.out.println(">> input ex) abcd bcda");
			String a = in.next();
			String b = in.next();
			int m = a.length();
			char[] s = new char[a.length()];
			for(int j = 0; j < a.length(); j++) {
				s[j] = a.charAt(j);
			}
			int n = b.length();
			char[] t = new char[b.length()];
			for(int j = 0; j < b.length(); j++) {
				t[j] = b.charAt(j);
			}
			S = new int[m+1][n+1];
			T = new int[m+1][n+1];
			for(int j = 0; j < m+1; j++) {
				for(int k = 0; k < n+1; k++) {
					S[j][k] = 0;
				}
			}
			System.out.println("length of longest common subsequence");
			System.out.print(lcs(s,t,m,n) + " ");
			System.out.println();
			System.out.println("longest common subsequence");
			printLCS(s, t, m, n);
			System.out.println();
		}
	}
	
	public static int lcs(char s[], char t[], int m, int n) {
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s[i-1] == t[j-1]) {
					S[i][j] = S[i-1][j-1] + 1;
					T[i][j] = 0;
				} else {
					if(S[i-1][j] >= S[i][j-1]) {
						S[i][j] = S[i-1][j];
						T[i][j] = 1;
					} else {
						S[i][j] = S[i][j-1];
						T[i][j] = 2;
					}
				}
			}
		}
		return S[m][n];
	}
	
	public static void printLCS(char[] s, char[] t, int m, int n) {
		if(m == 0 || n == 0) {
			return ;
		}
		if(T[m][n] == 0) {
			printLCS(s, t, m-1, n-1);
			System.out.print(s[m-1]);
		} else if(T[m][n] == 1) {
			printLCS(s, t, m-1, n);
		} else if(T[m][n] == 2) {
			printLCS(s, t, m, n-1);
		}
	}
}
