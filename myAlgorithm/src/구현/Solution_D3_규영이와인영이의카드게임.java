package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_규영이와인영이의카드게임 {
	
	static int[] numbers;
	static int[] isSelected;
	static int win;
	static int lose;
	
	static int[] gyu;
	static int[] in;
	
	static int[] check_int;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= t; test_case++)
		{
			numbers = new int[9];
			isSelected = new int[10];
			
			gyu = new int[9];
			in = new int[9];
			check_int = new int[19];
			
			String[] str = sc.nextLine().split(" ");
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(str[i]);
				check_int[Integer.parseInt(str[i])] = 1;
			}
			int j = 0;
			for(int i = 1; i < 19; i++) {
				if(check_int[i] == 0) {
					in[j] = i;
					j++;
				}
			}
			
			permutation(0);
			System.out.println("#" + test_case + " " + win + " " + lose);
			win = 0;
			lose = 0;
		}

	}
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			int one = 0;
			int two = 0;
			
			for(int i = 0; i < 9; i++) {
				if(gyu[i] > in[numbers[i]]) one += gyu[i] + in[numbers[i]];
				else two += gyu[i] + in[numbers[i]];
			}
			
			if(one > two) win++;
			else if(one < two) lose++;
			
			return;
		}else {
			for(int i = 0; i <= 8; i++) {
				if(isSelected[i] == 1) {
					continue;
				}
				numbers[cnt] = i;
				isSelected[i] = 1;
				permutation(cnt + 1);
				isSelected[i] = 0;
			}


		}
		
	}
}
