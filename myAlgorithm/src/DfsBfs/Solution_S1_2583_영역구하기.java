package DfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
 * 좌표 입력할 때 제대로 확인하기
 * 
 */
public class Solution_S1_2583_영역구하기 {

	static boolean[][] map;
	
	static boolean visited[][];
	
	static int N, M, K;
	
	static int numbers;
	
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]); // 세로
		M = Integer.parseInt(str[1]); // 가로
		K = Integer.parseInt(str[2]);
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<Integer>();
		for(int a = 0; a < K; a++) {
			str = in.readLine().split(" ");
			int y1 = Integer.parseInt(str[0]);
			int x1 = Integer.parseInt(str[1]);
			int y2 = Integer.parseInt(str[2]);
			int x2 = Integer.parseInt(str[3]);
			
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && !map[i][j]) {
					list.add(bfs(i, j));
					numbers++;
				}
			}
		}
		sb.append(numbers + "\n");
		Collections.sort(list);
		for(int a = 0; a < list.size(); a++) {
			sb.append(list.get(a) + " ");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		int ans = 1;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(!visited[nx][ny] && !map[nx][ny]) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					ans++;
				}
			}
		}
		return ans;
	}
}
