package history;

import java.util.Scanner;

public class DFA {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int i = 0; i < numTestCase; i++) {
			System.out.println(">> input pattern");
			String patternS = in.next();
			System.out.println(">> input string");
			String str = in.next();
			char[] pattern = new char[patternS.length()];
			for(int j = 0; j < patternS.length(); j++) {
				pattern[j] = patternS.charAt(j);
			}
			int[][] DFA = constructDFA(pattern);
			System.out.print("number of matching pattern: ");
			System.out.println(matchingDFA(DFA, str, pattern.length-1));
		}
	}
	
	public static int matchingDFA(int[][] listDFA, String str, int n) {
		int i = 0;
		int state = 0;
		int count = 0;
		while(i < str.length()) {
			char[] list = {'A', 'B', 'C'};
			int j = 0;
			while(str.charAt(i) != list[j]) {
				j += 1;
			}
			state = listDFA[state][j];
			if(state == n+1) {
				count += 1;
			}
			i += 1;
		}
		return count;
	}
	
	public static int[][] constructDFA(char[] pattern) {
		int len = pattern.length;
		int x = 0;
		int[][] DFA = new int[len+1][3];
		char[] list = {'A', 'B', 'C'};
		
		for(int i = 0; i < 3; i++) {
			if(pattern[0] == list[i]) {
				DFA[0][i] = 1;
			}
		}
		for(int i = 1; i < len; i++) {
			for(int p = 0; p < 3; p++) {
				DFA[i][p] = DFA[x][p];
			}
			int j = 0;
			while(pattern[i] != list[j]) {
				j += 1;
			}
			DFA[i][j] = i+1;
			x = DFA[x][j];
		}
		DFA[len] = DFA[x];
		
		return DFA;
	}
}
