import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class second {
	
	static int N;
	
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			visited = new boolean[N][N];
			int answer = 0;
			int pox = 0;
			int poy = 0;
			
			String str[];
			for(int i = 0; i < N; i++) {
				str = in.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if(map[i][j] == 2) {
						pox = i;
						poy = j;
					}
				}
			}
			map[pox][poy] = 0;
			dfs(pox, poy, 0, map);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) {
						answer++;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void dfs(int pox, int poy, int depth, int[][] map) {
		if(depth > 2) {
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = pox;
			int ny = poy;
			boolean flag = false;
			while(true) {
				nx += dx[i];
				ny += dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
				if(map[nx][ny] == 1) {
					flag = true;
					break;
				}
			}
			if(flag) {
				while(true) {
					nx += dx[i];
					ny += dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if(map[nx][ny] == 1) {
						visited[nx][ny] = true;
						dfs(nx, ny, depth + 1, make_map(map, nx, ny));
						break;
					}
					if(map[nx][ny] != 1) {
						dfs(nx, ny, depth + 1, make_map(map, nx, ny));
					}
				}
			}
		}
	}

	private static int[][] make_map(int[][] map, int nx, int ny) {
		int[][] newmap = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				newmap[i][j] = map[i][j];
			}
		}
		newmap[nx][ny] = 0;
		return newmap;
	}
	
	
}
