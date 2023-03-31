package dp;
import java.util.Scanner;

public class Solution_S4_설탕배달 {
	
	static int[] ans = new int[5001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ans[3] = 1;
		ans[5] = 1;
		
		for(int i = 6; i < 5001; i++) {
			if(ans[i-3] == 0 && ans[i - 5] == 0) {
				continue;
			}
			else if(ans[i-3] == 0) {
				ans[i] = ans[i-5] + 1;
			}
			else if(ans[i - 5] == 0) {
				ans[i] = ans[i-3] + 1;
			}
			else if(ans[i-3] != 0 && ans[i - 5] != 0) {
				ans[i] = Math.min(ans[i-3] + 1, ans[i-5] + 1);
			}

			
		}
		
		if(ans[N] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(ans[N]);
		}
	}
}
