package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S1_구간합구하기5 {
	public static int N;
	public static int M;

	public static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		graph = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			str = in.readLine().split(" ");
			for(int j = 1; j < N + 1; j++) {
				graph[i][j] = Integer.parseInt(str[j - 1]) + graph[i - 1][j] + graph[i][j - 1] - graph[i- 1][j - 1];
			}
		}
		
		for(int i = 0 ; i < M; i++) {
			str = in.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			System.out.println(graph[x2][y2] - graph[x1 - 1][y2] - graph[x2][y1 - 1] + graph[x1 - 1][y1 - 1]);
		}
	}
}
