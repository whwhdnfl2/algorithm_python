package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1_배열돌리기1 {
	static int N, M, R;
	static String[][] array;
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		sc.nextLine();
		array = new String[N][];
		for(int i = 0; i < N; i++) {
			array[i] = sc.nextLine().split(" ");
		}
		int count = Math.min(N, M) / 2; // 한 번 돌릴때 돌리는 횟수
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < count; j++) {
				spin(j);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}


	private static void spin(int count) {
		String start = array[count][count]; // count = 0일때 0, 0좌표를 받아온다. 돌릴 때 저장해야한다.
		for(int j = 0 + count; j < M - count - 1; j++) { //위
			array[count][j] = array[count][j + 1];
		}
		for(int i = 0 + count; i < N - count - 1; i++) { // 오른
			array[i][M - 1 - count] = array[i + 1][M - 1 - count];
		}
		for(int j = M - 1 - count; j > 0 + count; j--) { // 아래
			array[N - 1 - count][j] = array[N - 1 - count][j - 1];
		}
		for(int i = N - 1 - count; i > 0 + count; i--) { // 왼
			if(i == 1 + count) {
				array[i][0 + count] = start;
				continue;
			}
			array[i][0 + count] = array[i - 1][0 + count];
		}
	}
}
