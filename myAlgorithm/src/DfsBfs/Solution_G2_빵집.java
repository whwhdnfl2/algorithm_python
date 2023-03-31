package DfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_G2_빵집 {
	
	static String[][] map;
	static int[][] visited;
	
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static int ans = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new String[N][];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = in.readLine().split("");
		}
		for(int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		System.out.println(ans);
	}

	private static boolean dfs(int x, int y) {
		if(y == M - 1) {
			ans++;
			return true;
		}
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(visited[nx][ny] == 0 && map[nx][ny].equals(".")) {
					visited[nx][ny] = 1;
					if(dfs(nx, ny)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
