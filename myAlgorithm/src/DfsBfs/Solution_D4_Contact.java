package DfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_D4_Contact {
	
	static boolean visited[];
	static int[][] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		for(int test_case = 0; test_case <= t; test_case++) 
		{
			graph = new int[101][101];
			String[] str = in.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int start = Integer.parseInt(str[1]);
			str = in.readLine().split(" ");
			for(int i = 0; i < str.length; i += 2) {
				int x = 0;
				int y = 0;
				x = Integer.parseInt(str[i]);
				y = Integer.parseInt(str[i + 1]);
				graph[x][y] = 1;
			}
			visited = new boolean[101];
			System.out.println(bfs(start));
		}
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		visited[start] = true;
		int count = 1;
		int max = 0;
		while(!queue.isEmpty()) {
			count = queue.size();
			int max1 = 0;
			while(count > 0) {
				int now = queue.poll();
				max1 = Math.max(now, max1);
				count--;
				for(int i = 0; i < 101; i++) {
					if(graph[now][i] == 1 && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
			}
			max = max1;
		}
		return max;
	}
}
