package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_G5_21610_마법사상어와비바라기 {

	static int map[][];
	
	static int N, M;
	
	static List<int[]> cloud;
	
	static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" " );
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		cloud = new ArrayList<>();
		int firstx = N - 2;
		int firsty = 0;
		cloud.add(new int[] {firstx, firsty});
		cloud.add(new int[] {firstx + 1, firsty});
		cloud.add(new int[] {firstx, firsty + 1});
		cloud.add(new int[] {firstx + 1, firsty + 1});
		
		for(int a = 0; a < M; a++) {
			str = in.readLine().split(" ");
			int d = Integer.parseInt(str[0]) - 1;
			int s = Integer.parseInt(str[1]);
			moveCloud(d, s);
		}
		int water = countWater();
		System.out.println(water);
		
	}

	private static void moveCloud(int d, int s) {
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < cloud.size(); i++) {
			int x = cloud.get(i)[0];
			int y = cloud.get(i)[1];
			x += dx[d] * s;
			y += dy[d] * s;
			x = convert(x);
			y = convert(y);
			visited[x][y] = true;
			map[x][y] ++;
			cloud.get(i)[0] = x;
			cloud.get(i)[1] = y;
		}
		for(int i = 0; i < cloud.size(); i++) {
			plusOne(cloud.get(i)[0], cloud.get(i)[1]);
		}
		
		cloud.clear();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] >= 2) {
					map[i][j] -= 2;
					cloud.add(new int[] {i, j});
				}
			}
		}
	}
	
	private static int convert(int firstx) {
		if(firstx < 0) {
			firstx += N * 51;
			firstx %= N;

		}
		if(firstx % N == 0) {
			firstx = 0;
		}
		if(firstx >= N) {
			firstx %= N;
		}
		return firstx;
	}
	
	private static void plusOne(int secondx, int secondy) {
		
		int dx2[] = {1, 1, -1, -1};
		int dy2[] = {1, -1, 1, -1};
		
		for(int i = 0; i < 4; i++) {
			int nx = secondx + dx2[i];
			int ny = secondy + dy2[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(map[nx][ny] >= 1) map[secondx][secondy] ++;
		}
		
		
	}


	
	private static int countWater() {
		int a = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				a += map[i][j];
			}
		}
		return a;
	}
	
	
}
