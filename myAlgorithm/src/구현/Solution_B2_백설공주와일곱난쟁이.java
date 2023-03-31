package 구현;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_B2_백설공주와일곱난쟁이 {

	static int[] nan = new int[9];
	static boolean[] isSelected = new boolean[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			nan[i] = sc.nextInt();
		}
		combination(0, 0, 0);
	}
	
	public static void combination(int cnt, int start, int sum) {
		if(cnt == 7) {
			
			if(sum == 100) {
				for(int i = 0; i < 9; i++) {
					if(isSelected[i]) System.out.println(nan[i]);
				}
			}
			return;
		}
		else {
			for(int i = start; i < 9; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				combination(cnt + 1, i, sum + nan[i]);
				isSelected[i] = false;
			}
		}
	}
}
