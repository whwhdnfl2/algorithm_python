package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class cell{
	int x;
	int y;
	int time; // 활성화 되는 시간
	int count; // 지난 시간
	int isAlive; // 0이면 사망, 1이면 비활성, 2이면 활성
	boolean nowForm; // 현 시간에 생성되면 true;
	
	public cell(int x, int y, int time, int count, int isAlive, boolean nowForm) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
		this.count = count;
		this.isAlive = isAlive;
		this.nowForm = nowForm;
	}
}

public class Solution_swea5653_줄기세포배양 {
	
	static int N, M, K; // K는 총 배양 시간
	
	static int newN, newM;
	
	static cell map[][];
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			String str[] = in.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);
			
			map = new cell[N + 2 * K + 2][M + 2 * K + 2];

			for(int i = 0; i < N; i++) {
				str = in.readLine().split(" ");
				for(int j = 0; j < M; j++) {
					if(Integer.parseInt(str[j]) != 0) {
						map[i + K][j + K] = new cell(i + K, j + K, Integer.parseInt(str[j]), 0, 1, false);
					}
				}
			}

			newN = N + 2 * K + 1;
			newM = M + 2 * K + 1;
		
			for(int a = 0; a < K; a++) {
				simulate();
			}
			
			int ans = 0;
			for(int i = 0; i < N + 2 * K + 1; i++) {
				for(int j = 0; j < M + 2 * K + 1; j++) {
					if(map[i][j] != null && map[i][j].isAlive != 0) {
						ans ++;
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
				
	}

	private static void simulate() {
		for(int i = 0; i < newN; i++) {
			for(int j = 0; j < newM; j++) {
				if(map[i][j] != null && map[i][j].nowForm) {
					continue;
				}
				if(map[i][j] != null && map[i][j].isAlive != 0) {
					map[i][j].count ++;
					if(map[i][j].count == map[i][j].time) { // 활성화 되는 시기
						map[i][j].isAlive = 2;
					}
					else if(map[i][j].count == map[i][j].time + 1 && map[i][j].isAlive == 2) { // 활성화 되고 1시간 지나서 상하좌우 배양함.
						for(int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(map[nx][ny] == null) {
								map[nx][ny] = new cell(nx, ny, map[i][j].time, 0, 1, true);
							}
							else if(map[nx][ny].isAlive == 0) continue;
							else if(map[nx][ny].nowForm && map[nx][ny].time < map[i][j].time) {
								map[nx][ny].time = map[i][j].time;
							}
						}
						if(map[i][j].time == 1) {
							map[i][j].isAlive = 0;
						}
					}
					else if(map[i][j].count == map[i][j].time * 2 &&  map[i][j].isAlive == 2) { // 죽는 시기
						map[i][j].isAlive = 0;
					}
				}
			}
		}
		for(int i = 0; i < newN; i++) {
			for(int j = 0; j < newM; j++) {
				if(map[i][j] != null && map[i][j].nowForm) {
					map[i][j].nowForm = false;
				}
			}
		}
	}
}
