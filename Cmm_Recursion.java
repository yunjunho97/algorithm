package history;

import java.util.Scanner;

public class Cmm_Recursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int i = 0; i < numTestCase; i++) {
			System.out.println(">> input how many Matrix");
			int n = in.nextInt();
			System.out.println(">> ex) M1 = 20 X 2, M2 = 2 X 10 ==input==> 20 2 10");
			int[] list = new int[n+1];
			for(int j = 0; j < n+1; j++) {
				list[j] = in.nextInt();
			}
			System.out.println("minimum number of multiply");
			System.out.println(cmm(list, 1, n));
		}
	}
	
	public static int cmm(int[] list, int start, int end) {
		if(start == end) {
			return 0;
		}
		int[] list1 = new int[end-start];
		int k = 0;
		for(int i = start; i < end; i++) {
			list1[k] = cmm(list, start, i) + cmm(list, i+1, end) + list[start-1]*list[i]*list[end];
			k += 1;
		}
		int t = 0;
		for(int i = 0; i < end-start; i++) {
			if(list1[t] > list1[i]) {
				t = i;
			}
		}
		return list1[t];
		
	}
}
