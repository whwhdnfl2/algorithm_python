package 구현;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1_쿼드트리 {
	
	static int N;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		sc.nextLine();
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		split(0, 0, N);
	}
	
	public static void split(int x, int y, int size) {
		int checked = check(x, y, size);
		if(checked == -1) {
			System.out.print("(");
			int half = size / 2;
			split(x, y, half);
			split(x, y + half, half);
			split(x + half, y, half);
			split(x + half, y + half, half);
			System.out.print(")");
		}
		else if(checked == 0) {
			System.out.print("0");
		}
		else {
			System.out.print("1");
		}
	}
	
	public static int check(int x, int y, int size) {
		//System.out.println(x + size);
		int first = map[x][y];
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(first != map[i][j]) {
					return -1;
				}
			}
		}
		return first;
	}
	
}
