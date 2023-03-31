package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_G3_17142_연구소3 {
	
	static int[][] map;
	
	static int binCount = 0;
	
	static List<int[]> viruslist;
	
	static int N, M;
	
	static int[] number;
	
	static int ans = Integer.MAX_VALUE;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		number = new int[M];
		viruslist = new ArrayList<>();
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(str[j]);
				if(temp == 0) {
					binCount++;
				}
				if(temp == 2) {
					viruslist.add(new int[] {i, j});
				}
				map[i][j] = temp;
			}
		}
		
		combination(0, 0);
		
		if(binCount != 0) {
			if(ans == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(ans + 1);
			}
		}else {
			System.out.println(0);
		}


		
	}

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			
			ans = Math.min(ans, bfs());
			
			return;
		}
		for(int i = start; i < viruslist.size(); i++) {
			number[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	private static int bfs() {
		int tempBinCount = binCount;
		boolean[][] visited = new boolean[N][N];
		
		//bfs
		Queue<int[]> queue = new ArrayDeque<int[]>();
		for(int i = 0; i < M; i++) {
			queue.offer(new int[] {viruslist.get(number[i])[0], viruslist.get(number[i])[1], 0});
			visited[viruslist.get(number[i])[0]][viruslist.get(number[i])[1]] = true;
		}
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(!visited[nx][ny] && map[nx][ny] != 1) {
					if(map[nx][ny] == 0) {
						if(--tempBinCount == 0) {
							return temp[2];
						}
					}
					queue.offer(new int[] {nx, ny, temp[2] + 1});
					visited[nx][ny] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
