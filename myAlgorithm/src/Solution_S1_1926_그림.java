import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_S1_1926_그림 {

	static int map[][];
	
	static boolean visited[][];
	
	static int N, M;
	
	static int pictureCount;
	
	static int maxPicture;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					maxPicture = Math.max(maxPicture, bfs(i, j));
					pictureCount++;
				}
			}
		}
		System.out.println(pictureCount);
		System.out.println(maxPicture);
	}

	private static int bfs(int x, int y) {
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		Queue<int[]> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		int count = 1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					count++;
				}
			}
		}
		return count;
	}
}
