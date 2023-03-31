package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 걸리는 시간을 가중치로 하는 그래프 문제로 보면 된다.
 * 음의 간선이 존재하지 않기 때문에 다익스트라 알고리즘으로 구해낼 수 있다.
 * 근데 bfs로도 풀 수 있는 것 같다.(내가 예전에 그렇게 풂)
 * comparable, comparator를 ide 없이 구현할 수 있도록 연습하자.
 */



public class Solution_D4_1249_보급로 {
	
	static int N;
	static int[][] map;
	static int[][] time;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			N = Integer.parseInt(in.readLine());
			String[] str;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				str = in.readLine().split("");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			time = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					time[i][j] = Integer.MAX_VALUE;
				}
			}
			time[0][0] = 0;
			
			sb.append("#" + test_case + " " + dijkstra() + "\n");
		}
		System.out.println(sb);
	}

	private static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		//pq에 0,0 좌표를 넣는다. 이 때 시간은 0이다.
		pq.offer(new int[]{0, 0, 0});
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			//도착지점에 도착하면 리턴하면 된다.
			if(now[0] == N - 1 && now[1] == N - 1) {
				return time[now[0]][now[1]];
			}
			//4방 탐색
			for(int i = 0; i < 4; i++){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				//배열 넘어가면 continue
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				//현재 time[nx][ny]에 들어가 있는 값보다 pq에서 뽑은 노드를 통해서 time[nx][ny]로 가는 시간이 짧다면 
				if(map[nx][ny] + now[2] < time[nx][ny] && !visited[nx][ny]) {
					time[nx][ny] = map[nx][ny] + now[2];
					visited[nx][ny] = true;
					pq.offer(new int[] {nx, ny, time[nx][ny]});
				}
			}
		}
		return -1;
	}
}
