package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B2_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		
		long ans = 0;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] people = in.readLine().split(" ");
		String[] ab = in.readLine().split(" ");
		int B = Integer.parseInt(ab[0]);
		int C = Integer.parseInt(ab[1]);
		
		for(int i = 0; i < N; i++) {
			int person = Integer.parseInt(people[i]);
			if(person - B <= 0) {
				ans += 1;
			}else {
				ans += 1;
				person -= B;
				if(person % C == 0) {
					ans += person / C;
				}else {
					ans += (person / C) + 1;
				}
			}
		}
		System.out.println(ans);
		
	}
}
