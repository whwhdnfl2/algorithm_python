//백준 1012번

package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_S2_유기농배추 {
	
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int [][] map;
	public static int [][] visited;
	public static int M;
	public static int N;
	public static int K;
	public static int ans = 0;
	
	public static void bfs(int a, int b) {
		ans++;
		Queue<int []> q = new LinkedList<int []>();
		q.offer(new int[] {a, b});
		visited[a][b] = 1;
		while(!q.isEmpty()) {
			int [] asd = q.poll();
			int x = asd[0];
			int y = asd[1];
			for(int i = 0; i < 4; i++) {
				int t_x = x + dx[i];
				int t_y = y + dy[i];
				if(t_x < N && t_x >= 0 && t_y < M && t_y >= 0) {
					if(map[t_x][t_y] == 1 && visited[t_x][t_y] == 0) {
						visited[t_x][t_y] = 1;
						q.offer(new int[] {t_x, t_y});
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case = 0; test_case < t; test_case++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			for(int i = 0; i < K; i++) {
				
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			visited = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] == 0 && map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
			ans = 0;
		}
 	}
	
}
