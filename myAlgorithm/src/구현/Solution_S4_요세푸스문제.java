package 구현;

import java.util.Scanner;

public class Solution_S4_요세푸스문제 {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 0;
		
		int temp_K = K;
		
		arr = new int[N + 1];
		int my_count = 0;
		System.out.print("<");
		while(true) {
			for(int i = 0; i < N; i++) {
				if(arr[i] == 0) {
					my_count++;
				}
				if(my_count == K) {
					count++;
					if(count == 1) {
						System.out.print(i + 1);
					}else {
						System.out.print(", ");
						System.out.print(i + 1);
					}
					arr[i] = 1;
					my_count = 0;
				}
			}
			if(count == N) {
				break;
			}
		}
		System.out.println(">");
	}
}
