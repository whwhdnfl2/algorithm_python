package 구현;

import java.util.Scanner;

public class Solution_D3_spotMart {
	static int N, M;
	static int[] snack;
	static int[] numbers;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		snack = new int[N];
		numbers = new int[2];
		String str[] = sc.nextLine().split(" ");
		for(int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(str[i]);
		}
		choice(0, 0, 0);
		System.out.println(max);
	}
	
	public static void choice(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(sum > max && sum <= M) {
				max = sum;
			}
			return;
		}else {
			for(int i = start; i < N; i++) {
				numbers[cnt] = i;
				choice(cnt + 1, i + 1, sum+snack[i]);
			}
		}
	}
}
