package 구현;
import java.util.Scanner;

public class Solution_D3_햄버거다이어트 {
	
	static int N, L;
	static int tastes[];
	static int calories[];
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			tastes = new int[N];
			calories = new int[N];
			for(int i = 0; i < N; i++) {
				tastes[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			compute(0, 0, 0);
			System.out.println("#" + test_case + " " + ans);
			ans = 0;
		}
	}
	
	private static void compute(int cnt, int calory, int taste) {
		if(calory > L) {
			return;
		}
		if(cnt == N) {
			if(taste > ans) {
				ans = taste;
			}
			return;
		}
		compute(cnt + 1, calory + calories[cnt], taste + tastes[cnt]);
		compute(cnt + 1, calory, taste);
	}
}
