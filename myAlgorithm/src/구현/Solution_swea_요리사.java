package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution_swea_요리사 {
	
	static int N;
	static int[] numbers;
	static int[][] sinergy;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(sc.readLine());
		for(int test_case = 1; test_case <= T; test_case++) 
		{
			N = Integer.parseInt(sc.readLine());
			numbers = new int[N];
			sinergy = new int[N][N];
			
			
			
			for(int i = 0; i < N; i++) {
				String[] str = sc.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					sinergy[i][j] = Integer.parseInt(str[j]);
				}
			}
			splitFood(0,  0);
			
			System.out.println("#" + test_case + " " + ans);
			
			
			
			
			ans = Integer.MAX_VALUE;
		}
	}
	
	public static void splitFood(int oneCount, int cnt) {
		if(oneCount == N / 2) {
			List<Integer> food1 = new LinkedList<>();
			List<Integer> food2 = new LinkedList<>();

			for(int i = 0; i < N; i++) {
				if(numbers[i] == 1) food1.add(i);
				else food2.add(i);
			}
			int food1sum = 0;
			int food2sum = 0;
			for(int i = 0; i < food1.size(); i++) {
				for(int j = 0; j < food1.size(); j++) {
					if(i == j) {
						continue;
					}
					food1sum += sinergy[food1.get(i)][food1.get(j)];
				}
			}
			for(int i = 0; i < food2.size(); i++) {
				for(int j = 0; j < food2.size(); j++) {
					if(i == j) {
						continue;
					}
					food2sum += sinergy[food2.get(i)][food2.get(j)];
				}
			}
			if(Math.abs(food1sum - food2sum) < ans) {
				ans = Math.abs(food1sum - food2sum);
			}
			return;
		}
		if(cnt == N) {
			return;
		}
		else {
			numbers[cnt] = 1;
			splitFood(oneCount + 1, cnt + 1);
			numbers[cnt] = 0;
			splitFood(oneCount, cnt + 1);
		}
	}
}
