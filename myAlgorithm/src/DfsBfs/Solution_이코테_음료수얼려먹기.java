package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_이코테_음료수얼려먹기 {
	
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N;
	public static int M;
	
	public static void dfs(int x, int y) {
		map[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int t_x = x + dx[i];
			int t_y = y + dy[i];
			if(t_x < N && t_x >= 0 && t_y < M && t_y >= 0) {
				if(map[t_x][t_y] == 0) {
					dfs(t_x, t_y);
				}
			}
		}
	}

	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		int ans = 0;
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					dfs(i, j);
					ans ++;
				}
			}
		}
		System.out.println(ans);
	}
}
