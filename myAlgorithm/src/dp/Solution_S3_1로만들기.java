package dp;

import java.util.Scanner;

public class Solution_S3_1로만들기 {

	static int[] arr = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr[3] = 1;
		arr[2] = 1;
		arr[1] = 0;
		for(int i = 4; i < 1000001; i++) {
			if(i % 3 == 0 && i % 2 == 0) {
				arr[i] = Math.min(arr[i / 3] + 1, Math.min(arr[i / 2] + 1, arr[i - 1] + 1));
			}
			else if(i % 3 == 0) {
				arr[i] = Math.min(arr[i / 3] + 1, arr[i - 1] + 1);
			}
			else if(i % 2 == 0) {
				arr[i] = Math.min(arr[i / 2] + 1, arr[i - 1] + 1);
			}
			else {
				arr[i] = arr[i - 1] + 1;
			}
			
		}
		
		System.out.println(arr[N]);
	}
}
