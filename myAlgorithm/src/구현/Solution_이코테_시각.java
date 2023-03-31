//이코테 구현

package 구현;

import java.util.Scanner;

public class Solution_이코테_시각 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 0;
		for(int i = 0; i <= N; i++) {
			String temp = Integer.toString(i);
			if(temp.length() == 1) {
				if(temp.charAt(0) == '3') {
					count += 3600;
					continue;
				}
			}else {
				if(temp.charAt(0) == '3' || temp.charAt(1) == '3') {
					count += 3600;
					continue;
				}
			}
			for(int j = 0; j < 60; j++) {
				temp = Integer.toString(j);
				if(temp.length() == 1) {
					if(temp.charAt(0) == '3') {
						count += 60;
						continue;
					}
				}else {
					if(temp.charAt(0) == '3'|| temp.charAt(1) == '3') {
						count += 60;
						continue;
					}
				}
				for(int k = 0; k < 60; k++) {
					temp = Integer.toString(k);
					if(temp.length() == 1) {
						if(temp.charAt(0) == '3') {
							count ++;
							continue;
						}
					}else {
						if(temp.charAt(0) == '3'|| temp.charAt(1) == '3') {
							count ++;
							continue;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
