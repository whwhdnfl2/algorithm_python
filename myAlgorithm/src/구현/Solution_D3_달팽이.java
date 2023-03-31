package 구현;

import java.util.Scanner;

public class Solution_D3_달팽이 {
	
	public static int[][] snail;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
			

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		snail = new int[N][N];
		int law = 0;
		int x = 0;
		int y = -1;
		
		for(int i = 1; i < N * N + 1; i++) {
			x = x + dx[law];
			y = y + dy[law];
			if(law == 0){
				if(y >= N) {
					law += 1;
					y--;
					i--;
					continue;
				}else if(snail[x][y] != 0) {
					law += 1;
					y--;
					i--;
					continue;
				}
				else {
					snail[x][y] = i;
				}
			}
			if(law == 1){
				if(x >= N) {
					law += 1;
					x--;
					i--;
					continue;
				}else if(snail[x][y] != 0) {
					law += 1;
					x--;
					i--;
					continue;
				}
				else {
					snail[x][y] = i;
				}
			}
			if(law == 2){
				if(y < 0) {
					law += 1;
					y++;
					i--;
					continue;
				}else if( snail[x][y] != 0) {
					law += 1;
					y++;
					i--;
					continue;
				}
				else {
					snail[x][y] = i;
				}
			}
			if(law == 3){
				if(x < 0) {
					law = 0;
					x++;
					i--;
					continue;
				}else if(snail[x][y] != 0) {
					law = 0;
					x++;
					i--;
					continue;
				}
				else {
					snail[x][y] = i;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
}
