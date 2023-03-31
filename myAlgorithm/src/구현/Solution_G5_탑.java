package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_G5_탑 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] tower = sc.nextLine().split(" ");
		int[] real_tower = new int[N];
		int[] ans = new int[N];
		for(int i = 0; i < N; i++) {
			real_tower[i] = Integer.parseInt(tower[i]);
		}
		
		ans[0] = -1;
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		
		for(int i = 1; i < N; i++) {
			if(ans[i - 1] == -1) {
				if(real_tower[i] > real_tower[i - 1]) {
					ans[i] = -1;
				}else {
					ans[i] = i - 1;
				}
			}else {
				if(real_tower[i] <= real_tower[i - 1]) {
					ans[i] = i - 1;
				}
				else if(real_tower[i] > real_tower[i - 1]){
					int before = i - 1; 
					while(true) {
						if(ans[before] == -1) {
							if(real_tower[i] > real_tower[before]) {
								ans[i] = -1;
								break;
							}
							else {
								ans[i] = before;
								break;
							}
						}
						if(real_tower[i] <= real_tower[ans[before]]) {
							ans[i] = ans[before];
							break;
						}else {
							before = ans[before];
						}
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			if(ans[i] == -1) {
				System.out.print(0 + " ");
			}else {
				System.out.print(ans[i] + 1 + " ");
			}
			
		}
	}
}