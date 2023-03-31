package DfsBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_G5_18405_경쟁적전염 {
	
	static int N;
	
	static int map[][];
	
	static int visited[][];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		map = new int[N][N];
		visited = new int[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] != 0) {
					queue.offer(new int[] {i, j, map[i][j]});
					visited[i][j] = 1;
				}
			}
		}
		str = in.readLine().split(" ");
		int S = Integer.parseInt(str[0]);
		int X = Integer.parseInt(str[1]);
		int Y = Integer.parseInt(str[2]);
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[2] > map[temp[0]][temp[1]]) continue; // 갱신됐으므로 continue 
			if(visited[temp[0]][temp[1]] == S + 1) break;
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny] == visited[temp[0]][temp[1]] + 1 && map[nx][ny] > map[temp[0]][temp[1]]) {
					map[nx][ny] = map[temp[0]][temp[1]];
					queue.offer(new int[] {nx, ny, map[nx][ny]});
				}
				if(visited[nx][ny] == 0 && map[nx][ny] == 0) {
					map[nx][ny] = map[temp[0]][temp[1]];
					visited[nx][ny] = visited[temp[0]][temp[1]] + 1;
					queue.offer(new int[] {nx, ny, map[nx][ny]});
				}
			}
		}
		System.out.println(map[X - 1][Y - 1]);
	}
}
