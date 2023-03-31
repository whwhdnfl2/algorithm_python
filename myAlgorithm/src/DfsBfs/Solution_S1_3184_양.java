package DfsBfs;

/*
 * 실수했는데 문제를 맞혔다.
 * 처음 bfs를 돌입할 때 늑대, 양인지 여부 확인해서 +1 해주는 작업이 필요하다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_S1_3184_양 {

	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int N, M;
	
	static int wolfCount, sheepCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'v') {
					wolfCount++;
				}
				if(map[i][j] == 'o') {
					sheepCount++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && !(map[i][j] == '#')) {
					bfs(i, j);
				}
			}
		}
		System.out.println(sheepCount + " " + wolfCount);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int sheep = 0;
		int wolf = 0;
		if(map[x][y] == 'v') wolf++;
		if(map[x][y] == 'o') sheep++;
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(!visited[nx][ny] && !(map[nx][ny] == '#')) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					if(map[nx][ny]== 'v') {
						wolf++;
					}
					else if(map[nx][ny] == 'o') {
						sheep++;
					}
				}
			}
		}
		if(sheep > wolf) {
			wolfCount -= wolf;
		}else {
			sheepCount -= sheep;
		}
	}
}
