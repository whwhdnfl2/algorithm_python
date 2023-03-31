package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1_배열돌리기 {
	
	static int N, M, R;
	static String [][] array;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		sc.nextLine();
		
		array = new String[N][];
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			array[i] = str;
		}
		
		
		String[] str = sc.nextLine().split(" ");
		for(int i = 0; i < R; i++) {
			int a = Integer.parseInt(str[i]);
			switch (a) {
			case 1:
				array = compute1();
				break;
			case 2:
				array = compute2();
				break;
			case 3:
				String [][] temp_array;
				temp_array = new String[M][N];
				temp_array = compute3();
				array = new String[M][N];
				array = temp_array;
				int temp = M;
				M = N;
				N = temp;
				break;
			case 4:
				String [][] temp_array2;
				temp_array2 = new String[M][N];
				temp_array2 = compute4();
				array = new String[M][N];
				array = temp_array2;
				int temp1 = M;
				M = N;
				N = temp1;
				break;
			case 5:
				array = compute5();
				break;
			case 6:
				array = compute6();
				break;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static String[][] compute1() {
		String[][] temp = new String[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = array[N - 1 - i][j];
			}
		}
		return temp;
	}
	
	public static String[][] compute2() {

		String[][] temp = new String[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = array[i][M - 1 - j];
			}
		}
		return temp;
	}
	
	public static String[][] compute3() {
		String[][] temp = new String[M][N];
		
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][j] = array[N - 1 - j][i];
			}
		}
		return temp;
	}
	
	public static String[][] compute4() {
		String[][] temp = new String[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][j] = array[j][M - 1 - i];
			}
		}
		return temp;
	}
	
	public static String[][] compute5() {
		String[][] temp = new String[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N / 2 && j < M / 2) {
					temp[i][j] = array[i + N / 2][j];
				}
				if(i < N / 2 && j >= M / 2) {
					temp[i][j] = array[i][j - M / 2];
				}
				if(i >= N / 2 && j < M / 2) {
					temp[i][j] = array[i][j + M / 2];
				}
				if(i >= N / 2 && j >= M / 2) {
					temp[i][j] = array[i - N / 2][j];
				}
			}
		}
		return temp;
	}
	
	public static String[][] compute6() {
		String[][] temp = new String[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N / 2 && j < M / 2) {
					temp[i][j] = array[i][j + M / 2];
				}
				if(i < N / 2 && j >= M / 2) {
					temp[i][j] = array[i + N / 2][j];
				}
				if(i >= N / 2 && j < M / 2) {
					temp[i][j] = array[i - N / 2][j];
				}
				if(i >= N / 2 && j >= M / 2) {
					temp[i][j] = array[i][j - M / 2];
				}
			}
		}
		return temp;
	}
	

	
}
