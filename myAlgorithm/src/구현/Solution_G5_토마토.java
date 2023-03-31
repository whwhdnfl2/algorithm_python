package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point1{
	int x;
	int y;
	int z;
	int cnt;
	public point1(int z, int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.cnt = cnt;
	}
	
}

public class Solution_G5_토마토 {
	static int ans;
	
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 0, 0, -1, 1};
	static int[] dz = {0, 0, -1, 1, 0, 0};
	
	static int N, M, H;
	
	static int map[][][];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		String str[] = sc.readLine().split(" ");
		M = Integer.parseInt(str[0]); // 가로
		N = Integer.parseInt(str[1]);; // 세로
		H = Integer.parseInt(str[2]);// 높이
		
		map = new int[H][N][M];
		
		Queue<point1> queue = new LinkedList<point1>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				str = sc.readLine().split(" ");
				for(int k = 0; k < M; k++) {
					if(str[k].equals("1")) queue.offer(new point1(i, j, k, 0));
					map[i][j][k] = Integer.parseInt(str[k]);
				}
			}
		}
		
		
		
		//bfs 실행
		while(!queue.isEmpty()) {
			point1 temp = queue.poll();
			ans = Math.max(ans, temp.cnt);
			for(int i = 0; i < 6; i++) {
				int nz = temp.z + dz[i];
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if(map[nz][nx][ny]== 0) {
						map[nz][nx][ny] = 1;
						queue.offer(new point1(nz, nx, ny, temp.cnt + 1));
					}
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
