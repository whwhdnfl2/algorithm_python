package 구현;
import java.util.Arrays;
import java.util.Scanner;

//class point{
//	int x;
//	int y;
//	
//	public point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//}

public class Solution_D5_최적경로 {
	
	static int N;
	static boolean[] isSelected;
	static point[] pointArray;
	static int[] numbers;
	static int companyx;
	static int companyy;
	static int homex;
	static int homey;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			pointArray = new point[N];
			isSelected = new boolean[N];
			numbers = new int[N];
			companyx = sc.nextInt();
			companyy = sc.nextInt();
			homex = sc.nextInt();
			homey = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				//System.out.println(x + " " + y);
				pointArray[i] = new point(x, y);
			}
			permutation(0, 0);
			System.out.println("#" + test_case + " "  + ans);
			ans = Integer.MAX_VALUE;
		}
		
	}
	
	public static void permutation(int cnt, int dist) {
		if(dist > ans) {
			return;
		}
		if(cnt == N) {
			dist += Math.abs(homex - pointArray[numbers[N - 1]].x) + Math.abs(homey - pointArray[numbers[N - 1]].y);
			ans = Math.min(ans, dist);
			return;
		}
		if(cnt == 0) {
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				numbers[cnt] = i;
				permutation(cnt + 1, 0);
				isSelected[i] = false;
			}
		}
		else if(cnt == 1) {
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				numbers[cnt] = i;
				permutation(cnt + 1, dist + Math.abs(companyx - pointArray[numbers[0]].x) + Math.abs(companyy - pointArray[numbers[0]].y));
				isSelected[i] = false;
			}
		}else {
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				numbers[cnt] = i;
				permutation(cnt + 1, dist + Math.abs(pointArray[numbers[cnt - 1]].x - pointArray[numbers[cnt - 2]].x) + Math.abs(pointArray[numbers[cnt - 1]].y - pointArray[numbers[cnt - 2]].y));
				isSelected[i] = false;
			}
		}
	}
}
