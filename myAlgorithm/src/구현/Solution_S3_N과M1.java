package 구현;

import java.util.Scanner;

public class Solution_S3_N과M1 {

	
	public static int numbers[];
	public static int selected[];
	public static int N;
	public static int M;
	
	public static void permutation(int cnt){
		
		if(cnt == M) {
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}
		else {
			for(int i = 1; i < N + 1; i++) {
				if(selected[i] == 1) {
					continue;
				}
				numbers[cnt] = i;
				selected[i] = 1;
				permutation(cnt + 1);
				selected[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		selected = new int[N + 1];
		
		permutation(0);
	}
}
