package 구현;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1_봄버맨 {

	//입력
	static int R;
	static int C;
	static int N;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int[][] map;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		
		sc.nextLine();
		String[][] firstMap = new String[R][C]; //처음 폭탄 배치
		String[][] bombMap = new String[R][C]; // 전체가 폭탄
		
		for(int i = 0; i < R; i++) { // 처음 폭탄 배치 입력
			firstMap[i] = sc.nextLine().split("");
		}
		
		for(int i = 0; i < R; i++) { // 전체 폭탄으로 채워진 경우
			for(int j = 0; j < C; j++) {
				bombMap[i][j] = "O";
			}
		}
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) { 
			for(int j = 0; j < C; j++) {
				if(firstMap[i][j].equals("O")) map[i][j] = 1; // 해당 값이 3이 되면 폭발
				else  map[i][j] = -1; // 폭탄이 없는 곳은 -1이다.
			}
		}
		
		if(N%2 == 0) { // N이 짝수면 무조건 폭탄이 다 차있음.
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					System.out.print(bombMap[i][j]);
				}
				System.out.println();
			}
			return;
		}else {
			for(int i = 0; i < N; i++) {
				if(i%2==0) {
					fillBomb();
				}else {
					boom();
				}
			}
		}
		
		// 답 출력
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != 0) {
					System.out.print("O");
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	
	private static void boom() {
		int[][] temp_map = new int[R][C];
		for(int i = 0; i < R; i++) { 
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					map[i][j]++;
				}
				temp_map[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(temp_map[i][j] == 3) {
					map[i][j] = -1;
					for(int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if(ni >= 0 && ni < R && nj >= 0 && nj < C) {
							map[ni][nj] = -1;
						}
					}
				}
			}
		}
	}


	private static void fillBomb() {
		for(int i = 0; i < R; i++) { 
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) {
					map[i][j] = 0;
				}else {
					map[i][j]++;
				}
			}
		}
	}
}

