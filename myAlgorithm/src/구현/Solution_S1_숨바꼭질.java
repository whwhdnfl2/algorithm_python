package 구현;


import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1_숨바꼭질 {
	
	public static int[] array = new int[101];
	static int N, K;
	
	public static void find(int num, int count) {
		if(num == K) {
			System.out.println(array[K]);
			return;
		}
		if(num > 100 || num < 0 ) {
			return;
		}
		else {
			if(array[num] == 0) {
				array[num] = count;
				return;
			}
			find(num*2, count + 1);
			find(num + 1, count + 1);
			find(num - 1, count + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		array[N] = 1;
		find(N, 0);
		System.out.println(Arrays.toString(array));
	}
}
