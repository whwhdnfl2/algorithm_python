package 구현;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_G3_괄호추가하기 {
	
	public static int numOfCalculator;
	public static int[] order;
	public static String str;
	public static int ans;

	public static List<Character> calculator = new ArrayList<Character>();
	public static List<Integer> numbers = new ArrayList<>();

	public static int calc(String test) {
		if(test.charAt(1) == '*') {
			return (test.charAt(0) - '0') * (test.charAt(2) - '0');
		}
		if(test.charAt(1) == '+') {
			return (test.charAt(0) - '0') + (test.charAt(2) - '0');
		}
		if(test.charAt(1) == '-') {
			return (test.charAt(0) - '0') - (test.charAt(2) - '0');
		}
		return 1;
	}
	
	public static int calc2(List<Character> temp_calculator, List<Integer> temp_numbers) {
		int now = temp_numbers.get(0);
		for(int i = 0; i < temp_calculator.size(); i++) {
			if(temp_calculator.get(i) == '*') {
				now *= temp_numbers.get(i + 1);
			}
			if(temp_calculator.get(i) == '+') {
				now += temp_numbers.get(i + 1);
			}
			if(temp_calculator.get(i) == '-') {
				now -= temp_numbers.get(i + 1);
			}
		}
		return now;
	}
	
	public static void make(int cnt) {
		if(cnt == numOfCalculator) {
			
			int now = order[0];
			for(int i = 1; i < order.length; i++) {
				if(now == 1 && order[i] == 1) {
					return;
				}
				now = order[i];
			}
			List<Character> temp_calculator = new ArrayList<Character>();
			List<Integer> temp_numbers = new ArrayList<>();
			for(int i = 0; i < order.length; i++) {
				
				if(i == order.length - 1) {
					if(order[i] == 1) {
						int temp = calc(str.substring(i*2, i*2 + 3));
						temp_numbers.add(temp);
					}else {
						temp_calculator.add(calculator.get(i));
						temp_numbers.add(str.charAt(i*2 + 2) - '0');
					}
				}else {
					if(order[i] == 1) {
						int temp = calc(str.substring(i*2, i*2 + 3));
						temp_numbers.add(temp);
					}else if(order[i] == 0 && order[i + 1] == 1 ){
						if(i == 0) {
							temp_numbers.add(str.charAt(0) - '0');
							temp_calculator.add(calculator.get(i));
						}else {
							temp_calculator.add(calculator.get(i));
						}
						
					}else if(order[i] == 0 && order[i + 1] == 0) {
						if(i == 0) {
							temp_numbers.add(str.charAt(0) - '0');
							temp_calculator.add(calculator.get(i));
							temp_numbers.add(str.charAt(i*2 + 2) - '0');
						}else {
							temp_calculator.add(calculator.get(i));
							temp_numbers.add(str.charAt(i*2 + 2) - '0');
						}

					}
				}
			}
			int my_ans = calc2(temp_calculator, temp_numbers);
			ans = Math.max(my_ans, ans);
			return;
		}
		order[cnt] = 1;
		make(cnt + 1);
		order[cnt] = 0;
		make(cnt + 1);
	}
	
	public static void main(String[] args) {
		ans =- (int) Math.pow(2, 31);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		str = sc.nextLine();
		
		numOfCalculator = N / 2;
		order = new int[numOfCalculator];
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '*' || str.charAt(i) == '-') {
				calculator.add(str.charAt(i));
			}
			else {
				numbers.add(str.charAt(i) - '0');
			}
		}
		if(N == 1) {
			System.out.println(Integer.parseInt(str));
		}
		else if(N == 3) {
			System.out.println(calc(str));
		}
		else {
			make(0);
			System.out.println(ans);
		}
		
	}
}
