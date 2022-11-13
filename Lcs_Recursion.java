package history;

import java.util.Scanner;

public class Lcs_Recursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int i = 0; i < numTestCase; i++) {
			System.out.println(">> input ex) abcd bcda");
			String a = in.next();
			String b = in.next();
			int m = a.length()-1;
			char[] s = new char[a.length()];
			for(int j = 0; j < a.length(); j++) {
				s[j] = a.charAt(j);
			}
			int n = b.length()-1;
			char[] t = new char[b.length()];
			for(int j = 0; j < b.length(); j++) {
				t[j] = b.charAt(j);
			}
			System.out.println("length of longest common subsequence");
			System.out.println(lcs(s,t,m,n));
		}
	}
	
	public static int lcs(char s[], char t[], int m, int n) {
		if(m<0 || n<0) {
			return 0;
		}
		if(s[m] == t[n]) {
			return lcs(s, t, m-1, n-1) + 1;
		} else {
			return Math.max(lcs(s, t, m, n-1), lcs(s, t, m-1, n));
		}
	}
}