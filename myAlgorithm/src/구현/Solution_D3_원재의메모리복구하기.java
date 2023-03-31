//swea 1289번

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			String[] memo = in.readLine().split("");
			int ans = 0;
			String first = "0";
			for(int i = 0; i < memo.length; i++) {
				if(!first.equals(memo[i])) {
					ans += 1;
					first = memo[i];
				}
			}
			System.out.println(ans);
		}
	}
}
