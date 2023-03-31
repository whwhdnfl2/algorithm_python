package 구현;
import java.util.Scanner;

public class Solution_G5_제곱수찾기 {
	
	static int N, M;
	static int ans = - 1;
	static String map[][];
	static boolean flag = false;

	public static void main(String[] args) {
		//입력 및 초기화
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new String[N][M];
		for(int i = 0; i < N; i++) {
			String str[] = sc.nextLine().split("");
			map[i] = str;
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int cnt1 = 0; cnt1 < N; cnt1++) {
					for(int cnt2 = 0; cnt2 < M; cnt2++) {
						if(cnt1 == 0 && cnt2 == 0) {
							continue;
						}
						check_daegak(cnt1, cnt2, i, j);
						check_daegak(-cnt1, cnt2, i, j);
						check_daegak(cnt1, -cnt2, i, j);
						check_daegak(-cnt1, -cnt2, i, j);
					}
				}
			}
		}
		if(!flag) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].equals("0") || map[i][j].equals("1")|| map[i][j].equals("4") || map[i][j].equals("9")) {
						ans = Math.max(Integer.parseInt(map[i][j]), ans);
					}
				}
			}
		}

		System.out.println(ans);
	}
	
	static void check_daegak(int cnt1, int cnt2, int r, int c) { // cnt1는 M-1, cnt2는 N-1까지 진행한다. cnt는 0부터 한다. 0, 0은 안함
		String str = map[r][c];
		while(r + cnt1 >= 0 && r + cnt1 < N && c + cnt2 < M && c + cnt2 >= 0) {
			r = r + cnt1;
			c = c + cnt2;
			str = str + map[r][c];
			int now = Integer.parseInt(str);
			double check = Math.sqrt(now);
			int check2 = (int)check;
			if(check - check2 == 0 && ans < now) {
				flag = true;
				ans = now;
			}
		}

	}
}