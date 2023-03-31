package 구현;

import java.util.Scanner;

public class Solution_S3_1로만들기 {
	public static int[] arr = new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int i = 4; i < 1000001; i++) {
			arr[i] = 1000000000;
		}
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4; i < 1000001; i++) {
			if(i % 3 == 0) {
				if(arr[i / 3] + 1 < arr[i])
					arr[i] = arr[i / 3] + 1;
			}
			if(i % 2 == 0) {
				if(arr[i / 2] + 1 < arr[i])
					arr[i] = arr[i / 2] + 1;
			}
			if(arr[i - 1] + 1 < arr[i])
				arr[i] = arr[i - 1] + 1;
		}
		System.out.println(arr[sc.nextInt()]);

	}
}
