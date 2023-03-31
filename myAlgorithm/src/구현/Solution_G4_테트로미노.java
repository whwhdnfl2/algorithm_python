package 구현;
import java.util.Scanner;

public class Solution_G4_테트로미노 {
	
	static int N, M;
	static int ans;
	static int[] dxx = {-1, 1, 0, 0};
	static int[] dyy = {0, 0, 1, -1};

	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited = new int[N][M];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = 1;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = 0;
			}
		}
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			ans = Math.max(sum, ans);
			visited[x][y] = 0;
			return;
		}
		for(int i = 0; i < 3; i++) {
			int nx = x + dxx[i];
			int ny = y + dyy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(visited[nx][ny] == 0) {
					if(count == 2) {
						visited[nx][ny] = 1;
						dfs(x, y, sum+map[nx][ny], count + 1);
						visited[nx][ny] = 0;
					}
					
					visited[nx][ny] = 1;
					dfs(nx, ny, sum+map[nx][ny], count + 1);
					visited[nx][ny] = 0;
				}
			}
		}
	}
	
}
