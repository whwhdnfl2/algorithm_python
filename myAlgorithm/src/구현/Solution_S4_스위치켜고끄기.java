package 구현;

import java.util.Scanner;

public class Solution_S4_스위치켜고끄기 {

	public static int N;
	public static int[] witch;
	public static int person;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		witch = new int[N];
		String[] str = sc.nextLine().split(" ");
		for(int i = 0; i < N; i++) {
			witch[i] = Integer.parseInt(str[i]);
		}
		person = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < person; i++) {
			str = sc.nextLine().split(" ");
			int gender = Integer.parseInt(str[0]);
			int number = Integer.parseInt(str[1]) - 1;
			if(gender == 1) {
				for(int j = number; j < N; j += (number + 1)) {
					witch[j] = witch[j] == 1 ? 0 : 1; 
				}
			}
			else if (gender == 2) {
				witch[number] = witch[number] == 1 ?  0 :  1;
				int plus = 1;
				while(number + plus < N && number - plus >= 0 && (witch[number + plus] == witch[number - plus])) {
					witch[number + plus] = witch[number + plus] == 1 ? 0 : 1; 
					witch[number - plus] = witch[number - plus] == 1 ? 0 : 1; 
					plus++;
				}
			}
		}
		boolean flag = false;
		int temp_N = 0;
		for(int i = 0; i < 5; i++) {
			if(flag) {
				break;
			}
			if(i != 0) System.out.println("");
			for(int j = 0; j < 20; j++) {
				System.out.print(witch[j + i * 20] + " ");
				temp_N++;
				if(N == temp_N) {
					flag= true;
					break;
				}
			}
		}
	}
}
