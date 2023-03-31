package DfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Solution_G5_적록색약 {
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static String[][] map;
	static int[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(sc.readLine());

		map = new String[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = sc.readLine().split("");
		}
		
		visited = new int[N][N];
		int ans1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					bfs_saeck(i, j);
					ans1++;
				}
			}
		}
		
		visited = new int[N][N];
		int ans2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					bfs_normal(i, j);
					ans2++;
				}
			}
		}
		sb.append(ans2);
		sb.append(" ");
		sb.append(ans1);
		System.out.println(sb);
	}

	private static void bfs_saeck(int x, int y) {
		String start = map[x][y];
		Queue<point> queue = new ArrayDeque<point>();
		queue.offer(new point(x, y));
		visited[x][y] = 1;
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(start.equals("B") && map[nx][ny].equals("B") && visited[nx][ny] == 0) {
						queue.offer(new point(nx, ny));
						visited[nx][ny] = 1;
					}
					if((start.equals("R") || start.equals("G")) && (map[nx][ny].equals("R") || map[nx][ny].equals("G")) && visited[nx][ny] == 0) {
						queue.offer(new point(nx, ny));
						visited[nx][ny] = 1;
					}
				}
			}
			
		}		
	}

	private static void bfs_normal(int x, int y) {
		String start = map[x][y];
		Queue<point> queue = new ArrayDeque<point>();
		queue.offer(new point(x, y));
		visited[x][y] = 1;
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(start.equals("B") && map[nx][ny].equals("B") && visited[nx][ny] == 0) {
						queue.offer(new point(nx, ny));
						visited[nx][ny] = 1;
					}
					if(start.equals("G") && map[nx][ny].equals("G") && visited[nx][ny] == 0) {
						queue.offer(new point(nx, ny));
						visited[nx][ny] = 1;
					}
					if(start.equals("R") && map[nx][ny].equals("R") && visited[nx][ny] == 0) {
						queue.offer(new point(nx, ny));
						visited[nx][ny] = 1;
					}
				}
			}
			
		}
	}
	
	
}
