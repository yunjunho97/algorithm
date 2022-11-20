package history;

import java.util.Scanner;

public class sudoku {
	static int[][] board;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int k = 0; k < numTestCase; k++) {
			board = new int[4][4];
			System.out.println(">> input initial value");
			System.out.println("ex)");
			System.out.println("1 2 0 0");
			System.out.println("0 0 1 2");
			System.out.println("2 1 0 0");
			System.out.println("4 3 0 0");
			for(int l = 0; l < 4; l++) {
				for(int ll = 0; ll < 4; ll++) {
					board[l][ll] = in.nextInt();
				}
			}
			solution(0, 0);
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}
	
	public static int solution(int a, int b) {
		if(a == 4) {
			return 1;
		}
		int nextA = a;
		int nextB = b+1;
		if(b == 3) {
			nextA = a + 1;
			nextB = 0;
		}
		if(board[a][b] != 0) {
			return solution(nextA, nextB);
		}
		for(int i = 1; i <= 4; i++) {
			if(check(a, b, i) == 1) {
				board[a][b] = i;
				if(solution(nextA, nextB) == 1) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static int check(int a, int b, int n) {
		for(int i = 0; i < 4; i++) {
			if(board[a][i] == n || board[i][b] == n) {
				return 0;
			}
		}
		int k;
		int j;
		if(a <= 1) {
			k = 0;
		} else {
			k = 2;
		}
		if(b <= 1) {
			j = 0;
		} else {
			j = 2;
		}
		for(int l = 0; l < 2; l++) {
			for(int ll = 0; ll < 2; ll++) {
				if(board[k+l][j+ll] == n) {
					return 0;
				}
			}
		}
		return 1;
	}
}