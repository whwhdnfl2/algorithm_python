package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S3_구간합구하기4 {
	
	public static int N;
	public static int M;
	public static int [] array;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		array = new int[N];
		str = in.readLine().split(" ");
		array[0] = Integer.parseInt(str[0]);
		for(int i = 1; i < N; i++) {
			array[i] = array[i - 1] + Integer.parseInt(str[i]);
		}
		
		for(int i = 0; i < M; i++) {
			str = in.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			if(a == 1) {
				System.out.println(array[b - 1]);
			}
			else {
				System.out.println(array[b - 1] - array[a - 2]);
			}
		}
	}
}
