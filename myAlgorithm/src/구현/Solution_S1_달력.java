package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_S1_달력 {
	
	static int[] arr = new int[366];
	
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sc.readLine());
		for(int i = 0; i < N; i++) {
			String str[] = sc.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			for(int j = a; j <= b; j++) {
				arr[j] += 1;
			}
		}
		for(int i = 0; i < 366; i++) {
			if(arr[i] != 0) {
				int start = i;
				int length = 1;
				int height = arr[start];
				while(++start <= 365 && arr[start] != 0) {
					length++;
					if(arr[start] > height) {
						height = arr[start];
					}
				}
				ans += length * height;
				i = start;
			}
		}
		System.out.println(ans);
	}
}
