package 구현;
//boj 15650

import java.util.Scanner;

public class Solution_S3_N과M2 {

	public static int N;
	public static int M;
	public static int[] numbers;
	
	public static void combination(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println("");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		combination(0, 1);
	}
}
