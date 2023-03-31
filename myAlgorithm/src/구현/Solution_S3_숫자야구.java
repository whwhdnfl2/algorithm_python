package 구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_S3_숫자야구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> arr = new LinkedList<>();
		String num = "";
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(i == j) continue;
				for(int k = 1; k < 10; k++) {
					if(i == k) continue;
					if(j == k) continue;
					num += Integer.toString(i);
					num += Integer.toString(j);
					num += Integer.toString(k);
					arr.add(num);
					num = "";
				}
			}
		}
		sc.nextLine();
		
		for(int i = 0; i < N; i++) {
			int strike = 0;
			int ball = 0;
			String[] str = sc.nextLine().split(" ");
			strike = Integer.parseInt(str[1]);
			ball = Integer.parseInt(str[2]);
			String now_ball = str[0];
			for(int j = 0; j < arr.size(); j++) {
				int my_strike = 0;
				int my_ball = 0;
				for(int k = 0; k < 3; k++) {
					if(now_ball.charAt(k) == arr.get(j).charAt(k)) {
						my_strike += 1;
					}
					else {
						if(k == 0) {
							if(now_ball.charAt(k) == arr.get(j).charAt(1) || now_ball.charAt(k) == arr.get(j).charAt(2)) {
								my_ball+=1;
							}
						}
						if(k == 1) {
							if(now_ball.charAt(k) == arr.get(j).charAt(0) || now_ball.charAt(k) == arr.get(j).charAt(2)) {
								my_ball+=1;
							}
						}
						if(k == 2) {
							if(now_ball.charAt(k) == arr.get(j).charAt(0) || now_ball.charAt(k) == arr.get(j).charAt(1)) {
								my_ball+=1;
							}
						}
					}
				}
				if(strike != my_strike || ball != my_ball) {
					arr.remove(j);
					j--;
				}
			}
		}
		System.out.println(arr.size());
	}
}
