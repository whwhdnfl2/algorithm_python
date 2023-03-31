package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_S3_예산 {
	
	static int[] needMoney;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		needMoney = new int[N];
		
		sc.nextLine();
		String[] str = sc.nextLine().split(" ");
		int sum = 0;
		for(int i = 0; i < N; i++) {
			needMoney[i] = Integer.parseInt(str[i]);
			sum += needMoney[i];
		}
		M = sc.nextInt();
		
		Arrays.sort(needMoney);
		
		if(sum <= M) {
			System.out.println(needMoney[N - 1]);
			return;
		}
		
		int leftCount = N;
		
		for(int i = 0; i < N; i++) {
			
			int div = M / leftCount;
			
			if(div < needMoney[i]) {
				System.out.println(div);
				return;
			}
			
			M = M - needMoney[i];
			leftCount--;
		}
	}
}
