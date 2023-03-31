import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_G4_14502_연구소 {

	static int[][] map;
	static int N, M;
	
	static int[] selected;
	
	static int answer;
	
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[3];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" " );
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		combination(0, 0);
		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int tempans = 0;
			boolean canWall = false;
			for(int i = 0; i < 3 ;i++) {
				int num = selected[i];
				if(map[num / M][num % M] == 1 || map[num / M][num % M] == 2) { // 하나라도 벽이나 바이러스면
					canWall = true;
					break;
				}
			}
			if(!canWall) { // 벽 세개 다 설치 가능
				int[][] tempMap = makeMap(selected[0], selected[1], selected[2]);
				visited = new boolean[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(tempMap[i][j] == 2 && !visited[i][j]) {
							bfs(tempMap, i, j);
						}
					}
				}
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(tempMap[i][j] == 0) {
							tempans++;
						}
					}
				}
				if(tempans > answer) {
					answer = tempans;
				}
			}
			return;
		}
		for(int i = start; i < N * M; i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	private static void bfs(int[][] tempMap, int x, int y) {
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(tempMap[nx][ny] == 0 && !visited[nx][ny]) {
					tempMap[nx][ny] = 2;
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static int[][] makeMap(int a, int b, int c) {
		int[][] tempMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			tempMap[i] = map[i].clone();
		}
		tempMap[a / M][a % M] = 1;
		tempMap[b / M][b % M] = 1;
		tempMap[c / M][c % M] = 1;
		
		return tempMap;
	}
	
	
}
