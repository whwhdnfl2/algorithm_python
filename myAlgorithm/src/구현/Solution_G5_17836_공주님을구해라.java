package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_G5_17836_공주님을구해라 {
	
	static class point{
		int x;
		int y;
		int depth;
		public point(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		
	}
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int N, M, T;
	
	static int isSuccess = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited = new boolean[N][M];
		without_bfs();
		if(isSuccess == Integer.MAX_VALUE) {
			System.out.println("Fail");
		}
		else {
			System.out.println(isSuccess);
		}
	}


	private static void without_bfs() {
		Queue<point> queue = new ArrayDeque<>();
		queue.offer(new point(0, 0, 0));
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			if(temp.depth > T) {
				break;
			}
			if(temp.x == N - 1 && temp.y == M - 1) {
				isSuccess = Math.min(isSuccess, temp.depth);
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] != 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new point(nx, ny, temp.depth + 1));
						if(map[nx][ny] == 2) {
							int distance = temp.depth + 1 + ((N - 1) - nx) + ((M - 1) - ny);
							if(distance <= T) {
								isSuccess = distance;
							}
						}
					}
				}
			}
		}
	}
}
