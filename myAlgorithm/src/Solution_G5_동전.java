import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_G5_동전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) 
		{
			int N = sc.nextInt();
			int moneyArr[] = new int[N];
			for(int i = 0; i < N; i++) {
				moneyArr[i] = sc.nextInt(); // 가짓수 
			}
			
			Arrays.sort(moneyArr);
			
			int money = sc.nextInt(); //구할 액수 
			
			int ans[] = new int[money + 1]; // dp 배열 
			
			
			for(int i = 0; i < N; i++) {
				ans[moneyArr[i]] = 1;
			}

			
			for(int i = moneyArr[N - 1] + 1; i <= money; i++) {
				for(int j = 0; j < N; j++) {
					if(i - moneyArr[j] > 0) {
						if(ans[i - moneyArr[j]] == 0) {
							continue;
						}else {
							ans[i] += ans[i - moneyArr[j]] - ans[i - moneyArr[j]];
						}
					}
				}
			}
			System.out.println(Arrays.toString(ans));
			System.out.println(ans[money]);
		}
	}
}
