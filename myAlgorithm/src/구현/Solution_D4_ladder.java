package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

//class point{
//	int x;
//	int y;
//	public point() {
//		super();
//	}
//	public point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//}

public class Solution_D4_ladder {
	
	static int [] move_y = {-1, 1, 0};
	static int [] move_x = {0, 0, -1};
	
	static int [][] ladder = new int [100][100];
	static int [][] visited = new int [100][100];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 100; i++) {
			String[] str = in.readLine().split(" ");
			for(int j = 0; j < 100; j++) {
				ladder[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		
		point start = new point();
		for(int i = 0; i < 100; i++) {
			if(ladder[99][i] == 2) {
				start.x = 99;
				start.y = i;
				break;
			}
		}
		int ans = -1;

		
		Queue<point> queue = new ArrayDeque<point>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			point temp_point = queue.poll();
			int now_x = temp_point.x;
			int now_y = temp_point.y;
			visited[now_x][now_y] = 8;
			for(int i = 0; i < 3; i++) {
				int new_x = now_x + move_x[i];
				int new_y = now_y + move_y[i];
				if(new_y >= 0 && new_y < 100) {
					if(new_x == 0) {
						ans = new_y;
						break;
					}
					else if(ladder[new_x][new_y] == 1 && visited[new_x][new_y] == 0) {
						queue.offer(new point(new_x, new_y));
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
