package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_G2_12100_2048easy {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N;
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[][][] map = new int[N][N][2];
		String[] str;
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(str[j]);
				map[i][j][1] = 0; // 0이면 안바뀐거임
			}
		}
		answer = check(map);
		dfs(map, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int[][][] map, int depth) {
		if(depth > 4) {
			return;
		}
		for(int i = 0; i < 4; i++) {
			game(copyMap(map), i, depth);
		}
	}

	private static void game(int[][][] map, int a, int depth) {
		//a == 2일때
		if(a == 2) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j][0] != 0) move(i, j, a, map);
				}
			}
		}
		//a == 1일때
		if(a == 1) {
			for(int j = N - 1 ; j >= 0; j--) {
				for(int i = 0; i < N; i++) {
					if(map[i][j][0] != 0) move(i, j, a, map);
				}
			}
		}
		//a == 0일때
		if(a == 0) {
			for(int i = N - 1 ; i >= 0; i--) {
				for(int j = 0; j < N; j++) {
					if(map[i][j][0] != 0) move(i, j, a, map);
				}
			}
		}
		//a == 3일때
		if(a == 3) {
			for(int j = 0; j < N; j++) {
				for(int i = 0; i < N; i++) {
					if(map[i][j][0] != 0) move(i, j, a, map);
				}
			}
		}
		dfs(copyMap(map), depth + 1);
	}

	private static void move(int x, int y, int a, int[][][] map) {
		int b_x = x;
		int b_y = y;
		while(true) {
			int nx = b_x + dx[a];
			int ny = b_y + dy[a];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
			if(map[nx][ny][0] == 0) {
				map[nx][ny][0] = map[b_x][b_y][0];
				map[b_x][b_y][0] = 0;
				b_x = nx;
				b_y = ny;
				continue;
			}else {
				if(map[b_x][b_y][0] == map[nx][ny][0]) {
					if(map[nx][ny][1] == 0) { // 한번도 안 합쳐진 블록이면
						map[nx][ny][0] = map[nx][ny][0] * 2;
						if(map[nx][ny][0] > answer) answer = map[nx][ny][0];
						map[b_x][b_y][0] = 0;
						map[nx][ny][1] = 1;
						break;
					}
					else { // 이미 합쳐진 블록이면
						break;
					}
				}
				else {
					break;
				}
			}
		}
	}

	private static int check(int[][][] map) { // depth가 5 넘으면 가장 큰 블록 체크
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j][0] > ans) {
					ans = map[i][j][0];
				}
			}
		}
		return ans;
	}

	public static int[][][] copyMap(int[][][] map){
		int newMap[][][] = new int[N][N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				newMap[i][j][0] = map[i][j][0];
				newMap[i][j][1] = 0;
			}
		}
		return newMap;
	}
}