package DfsBfs;

import java.util.Scanner;

public class Solution_D4_정사각형방 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int ans = 0;
	static boolean flag = false;
	static int point = 0;

	static int N;
	static int [][] room;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		room = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			for(int j = 0; j < str.length; j++) {
				room[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dfs(i, j, 1, i, j);
				if(flag) {
					point = room[i][j];
					flag = false;
				}
			}
		}
		System.out.println(point + " " + ans);
	}

	private static void dfs(int a, int b, int count, int first_x, int first_y) {
		if(count > ans) {
			ans = count;
			point = room[first_x][first_y];
		}else if(count == ans && point > room[first_x][first_y]) {
			point = room[first_x][first_y];
		}
		for(int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			if(nx < N && nx >= 0 && ny < N && ny >= 0) {
				if(room[a][b] + 1 == room[nx][ny]) {
					dfs(nx, ny, count + 1, first_x, first_y);
				}
			}
		}
	}
}
