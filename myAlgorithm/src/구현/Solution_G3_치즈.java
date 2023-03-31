package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class point{
	int x;
	int y;
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution_G3_치즈 {
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static int N, M;
	static String[][] map;
	static int cheeseCount;
	static int ans;

	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new String[N][M];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				if(str[j].equals("1")) cheeseCount++;
			}
			map[i] = str;
		}
		
//		decideOutSide();
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		//cheeseCount가 0이 될 때 까지 while문을 돈다. 한 번 돌때마다 ans++
		while(cheeseCount > 0) {
			
			decideOutSide(); // 외부 공기 정함
			
			deleteCheese(); // 치즈 제거
			
			initialize(); // 2를 다시 0으로 원상 복구
			
			ans++;
		}
		
		// 답 출력
		System.out.println(ans);

	}

	private static void decideOutSide() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 || i == N - 1|| j == 0 || j == M - 1) {
					bfs(i, j);
				}
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<point> queue = new ArrayDeque<point>();
		map[x][y] = "2";
		queue.offer(new point(x, y));
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny].equals("0")) { // 0이면 내부라는 뜻
						map[nx][ny] = "2"; // 2이면 외부 공기 닿은거
						queue.offer(new point(nx, ny));
					}
				}
			}
		}
	}
	
	private static void deleteCheese() {
		
		List<point> deleteList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j].equals("1")) {
					int cnt = 0;
					for(int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if(ni == -1 || ni == N || nj == -1 || nj == M) {
							cnt++;
						}
						else {
							if(map[ni][nj].equals("2")) cnt++;
						}
					}
					if(cnt >= 2) {
						deleteList.add(new point(i, j));
						cheeseCount--;
					}
				}
			}
		}
		
		for(int i = 0; i < deleteList.size(); i++) {
			point temp = deleteList.get(i);
			map[temp.x][temp.y] = "0";
		}
	}

	
	private static void initialize() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j].equals("2")) map[i][j] = "0";
			}
		}
	}
	
	
}
