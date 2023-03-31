package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_S3_14501_퇴사 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> list = new ArrayList<>();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] max = new int[2001];
		
		for(int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(str[0]), Integer.parseInt(str[1])});
		}
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i)[0] + i <= N) {
				max[i] = Math.max(max[i + 1], (list.get(i)[1] + max[i + list.get(i)[0]]));
			}
			else {
				max[i] = max[i + 1];
			}
		}
		System.out.println(max[0]);
	}
}
