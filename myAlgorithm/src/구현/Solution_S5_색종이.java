package 구현;

import java.util.Scanner;

public class Solution_S5_색종이 {

	public static void main(String[] args) {
		int dohwa[][] = new int [100][100];
		int ans = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					dohwa[j + x][k + y] = 1;
				}
			}
		}
		
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(dohwa[j][k] == 1) {
					ans ++;
				}
			}
		}
		System.out.println(ans);
	}
}
