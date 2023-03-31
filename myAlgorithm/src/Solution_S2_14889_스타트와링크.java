import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S2_14889_스타트와링크 {

	static boolean[] split;
	
	static int power[][];
	
	static int N;
	
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		String[] str;
		power = new int[N][N];
		split = new boolean[N];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(str[j]);
			}
		}
		combination(0, 0);
		System.out.println(answer);
	}
	private static void combination(int cnt, int trueCount) {
		if(cnt == N) {
			if(trueCount == N / 2) {
				int team1 = 0;
				int team2 = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(split[i] && split[j]) {
							team1 += power[i][j];
						}
						if(!split[i] && !split[j]) {
							team2 += power[i][j];
						}
					}
				}
				answer = Math.min(answer, Math.abs(team1 - team2));
			}
			return;
		}
		if(trueCount < 10) {
			split[cnt] = true;
			combination(cnt + 1, trueCount + 1);
		}
		split[cnt] = false;
		combination(cnt + 1, trueCount);
	}
}
