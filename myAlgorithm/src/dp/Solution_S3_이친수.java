package dp;

import java.util.Scanner;

public class Solution_S3_이친수 {
	
	static long arr[][] = new long[91][2];
	static int N;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[2][0] = 1;
		arr[2][1] = 0;
		
		for(int i = 3; i < 91; i++) {
			arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
			arr[i][1] = arr[i - 1][0];
		}
		System.out.println(arr[N][0] + arr[N][1]);
	}
	
	private static void pinaryNumber(int len, int pre) {
		if(len == N) {
			return;
		}
		else {
			if(pre == 0) {
				
			}
		}
	}
}