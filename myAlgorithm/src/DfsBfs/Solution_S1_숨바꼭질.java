package DfsBfs;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class now{
	int n;
	int cnt;
	public now(int n, int cnt) {
		super();
		this.n = n;
		this.cnt = cnt;
	}
}

public class Solution_S1_숨바꼭질 {
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		visited = new boolean[1000000];
		
		bfs(N, K, 0);
		System.out.println(ans);
	}
	private static void bfs(int n, int k, int count) {
		Queue<now> queue = new ArrayDeque<now>();
		queue.offer(new now(n, 0));
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			now temp = queue.poll();
			
			if(temp.n == k) {
				ans = Math.min(ans, temp.cnt);
				break;
			}
			if(temp.n <= 100000 && temp.n >= 0) {
				if(!visited[2 * temp.n]) {
					queue.offer(new now(temp.n * 2, temp.cnt + 1));
					visited[2 *temp.n] = true;
				}
				if(!visited[temp.n + 1]) {
					queue.offer(new now(temp.n + 1, temp.cnt + 1));
					visited[temp.n + 1] = true;
				}
				if(n >= 1 && !visited[temp.n - 1]) {
					queue.offer(new now(temp.n - 1, temp.cnt + 1));
					visited[temp.n - 1] = true;
				}
			}
		}
	}
}

