//이코테 dfs, bfs

package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_이코테_미로탈출 {
	
	static int[][] miro;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int M;
	
	public static void bfs(int x, int y) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {x, y});
		int [] temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(miro[nx][ny] == 1) {
						miro[nx][ny] = miro[temp[0]][temp[1]] + 1;
						q.add(new int []{nx, ny});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		N = str.charAt(0) - '0';
		M = str.charAt(2) - '0';
		miro = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = in.readLine();
			for(int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(miro[N-1][M-1]);
	}
}
