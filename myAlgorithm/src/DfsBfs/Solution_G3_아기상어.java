package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution_G3_아기상어 {
	static class point implements Comparable<point>{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(point o) {
			if(this.x != o.x) return this.x - o.x;
			else return this.y - o.y;
		}
	}
	
	static int[][] map;
	static int sharkX, sharkY; // 상어 위치
	static int answer;
	
	static boolean[][] visited; // 시뮬레이트 돌릴 때 마다 초기화 해야 함.
	
	static int N; // 맵 크기
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int sharkSize = 2; // 상어 크기
	static int eat; // 현재 먹은 물고기 양(상어크기만큼 도달하면 0으로 바뀌며 상어 크기가 1 늘어난다.)
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str[] = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				
				if(Integer.parseInt(str[j]) == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}else {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
		}

		while(simulate()) {
		}
		System.out.println(answer);
	}

	private static boolean simulate() {
		visited = new boolean[N][N];
		Queue<point> queue = new ArrayDeque<point>();
		queue.offer(new point(sharkX, sharkY));
		visited[sharkX][sharkY] = true;
		PriorityQueue<point> pq = new PriorityQueue<>();
		int depth = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			depth++;
			while(count != 0) {
				point temp1 = queue.poll();
				count--;
				for(int i = 0; i < 4; i++) {
					int nx = temp1.x + dx[i];
					int ny = temp1.y + dy[i];
					if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if(!visited[nx][ny] && map[nx][ny] < sharkSize && map[nx][ny] > 0) {
							pq.offer(new point(nx, ny));
							visited[nx][ny] = true;
						}
						else if(!visited[nx][ny] && (map[nx][ny] == sharkSize || map[nx][ny] == 0)) {
							queue.offer(new point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			if(pq.size() > 0) {
				point temp = pq.poll();
				answer += depth;
				sharkX = temp.x;
				sharkY = temp.y;
				map[sharkX][sharkY] = 0;
				eat++;
				if(eat == sharkSize) {
					sharkSize++;
					eat = 0;
				}
				return true;
			}
		}
		return false;
	}
}