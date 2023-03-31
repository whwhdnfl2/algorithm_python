package 구현;

import java.util.Scanner;

public class Solution_D2_파리퇴치 {
	
	public static int N, M;
	public static int[][] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] temp = sc.nextLine().split(" ");
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}
		int ans = 0;
		int temp_ans = 0;
		for(int i = 0; i < N - M + 1; i++) {
			for(int j = 0; j < N - M + 1; j++) {
				if(temp_ans > ans) {
					ans = temp_ans;
				}
				temp_ans = 0;
				for(int k = 0; k < M; k++) {
					for(int l = 0; l < M; l++) {
						temp_ans += graph[i + k][j + l];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
