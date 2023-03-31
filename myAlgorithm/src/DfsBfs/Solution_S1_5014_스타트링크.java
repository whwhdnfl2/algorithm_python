package DfsBfs;
/*
 * 최소 횟수이므로 bfs를 써야한다!!
 * 처음에는 dfs를 써가지고 오답이 나왔다...
 * visited를 통해서 방문 여부를 확인하도록 하자.
 */


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_S1_5014_스타트링크 {
	
	static boolean[] visited;
	
	static int F, S, G, U, D;
	
	static int answer = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[F + 1];
		
		if(bfs(S)) {
			System.out.println(answer);
		}
		else {
			System.out.println("use the stairs");
		}
		
	}

	private static boolean bfs(int S) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {S, 0});
		visited[S] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0] == G) {
				answer = temp[1];
				return true;
			}
			int up = temp[0] + U;
			int down = temp[0] - D;
			if(up <= F && up >= 1 && !visited[up]) {
				visited[up] = true;
				queue.offer(new int[] {up, temp[1] + 1});
			}
			if(down <= F && down >= 1 && !visited[down]) {
				visited[down] = true;
				queue.offer(new int[] {down, temp[1] + 1});
			}
		}
		return false;
	}
}
