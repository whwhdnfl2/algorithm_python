//BOJ 1475

package 구현;

import java.util.Scanner;

public class Solution_S5_방번호 {
	
	public static int[] arr = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] str = sc.nextLine().split("");
		for(int i = 0; i < str.length; i++) {
			if(Integer.parseInt(str[i]) == 6 || Integer.parseInt(str[i]) == 9) {
				arr[9]++;
				arr[6]++;
			}else {
				arr[Integer.parseInt(str[i])] += 1;
			}
		}
		arr[6] = arr[6] / 2 + arr[6] % 2;
		arr[9] = arr[9] / 2 + arr[9] % 2;
		int ans = 0;
		for(int i = 0; i < 10; i++) {
			if(ans < arr[i]) {
				ans = arr[i];
			}
		}
		System.out.println(ans);
	}
}
