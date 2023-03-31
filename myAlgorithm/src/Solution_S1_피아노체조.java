import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_S1_피아노체조 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] str = in.readLine().split(" ");
		
		int[] difficult = new int[N];
		
		for(int i = 0; i < N; i++) {
			difficult[i] = Integer.parseInt(str[i]);
		}
		
		
		int[] sum = new int[N];
		
		if(N > 1) {
			if(difficult[0] > difficult[1]) {
				sum[0] = 1;
			}else {
				sum[0] = 0;
			}
		}
		
		for(int i = 1; i < N - 1; i++) {
			if(difficult[i] > difficult[i + 1]) {
				sum[i] = sum[i - 1] + 1;
			}
			else {
				sum[i] = sum[i - 1];
			}
		}
		StringBuffer sb = new StringBuffer();
		int Q = Integer.parseInt(in.readLine());
		for(int a = 0; a < Q; a++) 
		{
			

			str = in.readLine().split(" ");
			int x = Integer.parseInt(str[0])-1;
			int y = Integer.parseInt(str[1])-1;
			if(N == 1) {
				sb.append(0);
				sb.append("\n");
				continue;
			}
			
			if(x == 0) {
				if (y == 0) sb.append(0);
				else {
					sb.append(sum[y-1]);
				}
			}
			else {
				sb.append(sum[y-1] - sum[x-1]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
