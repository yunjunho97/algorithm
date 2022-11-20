package history;

import java.util.Scanner;

public class HeapSort {
	static int count;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(">> input how many test");
		int numTestCase = in.nextInt();
		for(int j = 0; j < numTestCase; j++) {
			System.out.println(">> input number of elements ex) 4");
			int n = in.nextInt();
			int[] list = new int[n+1];
			list[0] = 0;
			System.out.println(">> input elements ex) 1 2 3 4");
			for(int k = 1; k <= n; k++) {
				list[k] = in.nextInt();
			}
			heapSort(list, n);
			for(int l = 1; l <= n; l++) {
				System.out.print(list[l] + " ");
			}
			System.out.println();
			System.out.println("basic operations: " + count);
			count = 0;
		}
	}
	
	public static void heapSort(int[] list, int n) {
		for(int i = n/2; i >= 1; i--) {
			fixHeap(i, list, n);
		}
		for(int heapsize = n; heapsize >= 2; heapsize--) {
			int max = list[1];
			list[1] = list[heapsize];
			list[heapsize] = max;
			fixHeap(1, list, heapsize-1);
		}
		
	}
	
	public static void fixHeap(int root, int[] list, int n) {
		int vacant = root;
		int largerChild;
		while(vacant <= n/2) {
			if(vacant*2 + 1 <= n) {
				if(list[vacant*2] > list[vacant*2+1]) {
					largerChild = vacant*2;
					count += 1;
				} else {
					largerChild = vacant*2 + 1;
					count += 1;
				
				}
			} else {
				largerChild = vacant*2;
			}
			if(list[vacant] < list[largerChild]) {
				count += 1;
				int temp = list[vacant];
				list[vacant] = list[largerChild];
				list[largerChild] = temp;
				vacant = largerChild;
			} else {
				count += 1;
				break;
			}
		}
		
	}
}
