package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_사직연산유효성검사 {
	//0, 1, 2, 3,  4,  5,  6,   7
	//1, 3, 7, 15, 31, 63, 127, 255
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			System.out.println(Arrays.toString(str));
			if(str.length == 4) {
				if(str[1].equals("*") || str[1].equals("-") || str[1].equals("+") || str[1].equals("/")) {
					continue;
				}
				else {
					flag = true;
				}
			}
			else if(str.length == 3) {
				flag = true;
			}
			else {
				if(str[1].equals("*") || str[1].equals("-") || str[1].equals("+") || str[1].equals("/")) {
					flag = true;
				}
			}
		}
		if(flag) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}
	}
}
