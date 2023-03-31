package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_G4_20056_마법사상어와파이어볼 {
	
	static class fireball{
		int x;
		int y;
		int m;//질량
		int s;//방향
		int d;//속력
		public fireball(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int[][] map;
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);
		map = new int[N + 1][N + 1];
		
		List<fireball> fireList = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			str = in.readLine().split(" ");
			fireList.add(new fireball(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4])));
		}
		
		for(int a = 0; a < K; a++) {
			for(int i = 0; i < N + 1; i++) {
				for(int j = 0; j < N + 1; j++) {
					map[i][j] = 0;
				}
			}
//			map = new int[N + 1][N + 1];
			for(int i = 0; i < fireList.size(); i++) {
				fireball nowfire = fireList.get(i);
				
				int after_x = nowfire.x + dx[nowfire.d] * nowfire.s;
				int after_y = nowfire.y + dy[nowfire.d] * nowfire.s;
				
				if(after_x < 0) {
					after_x += N * 300;
				}
				if(after_y < 0) {
					after_y += N * 300;
				}
				
				after_x %= N;
				after_y %= N;
				
				if(after_x == 0) {
					after_x = N;
				}
				if(after_y == 0) {
					after_y = N;
				}
				map[after_x][after_y] ++; // 해당 좌표 + 1
				nowfire.x = after_x;
				nowfire.y = after_y;
			}
			
			
			for(int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if(map[i][j] >= 2) {
						int odd = 0;
						int even = 0;
						int mass = 0;
						int speed = 0;
						for(int k = 0; k < fireList.size(); k++) {
							fireball nowfire = fireList.get(k);
							if(nowfire.x == i && nowfire.y == j) {
								mass += nowfire.m;
								speed += nowfire.s;
								if(nowfire.d % 2 == 0) {
									even++;
								}
								else {
									odd++;
								}
								fireList.remove(k);
								k--;
							}

						}
						if(mass / 5 != 0) {
							if(odd > 0 && even > 0) {
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 1));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 3));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 5));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 7));
							}else {
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 0));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 2));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 4));
								fireList.add(new fireball(i, j, mass / 5, speed / map[i][j], 6));
							}
						}
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < fireList.size(); i++) {
			ans += fireList.get(i).m;
		}
		System.out.println(ans);
	}
}
