package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S1_14888_연산자끼워넣기 {
	
	static int[] callist;
	static boolean[] isSelected;
	
	static int N;
	
	static int[] numbers;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		numbers = new int[N];
		String[] str = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(str[i]);
		}
		callist = new int[N - 1];
		
		str = in.readLine().split(" ");
		int plus = Integer.parseInt(str[0]);
		int minus = Integer.parseInt(str[1]);
		int mul = Integer.parseInt(str[2]);
		int div = Integer.parseInt(str[3]);
		for(int i = 0; i < plus; i++) {
			callist[i] = 1;
		}
		for(int i = plus; i < plus + minus; i++) {
			callist[i] = 2;
		}
		for(int i = plus + minus; i < plus + minus + mul; i++) {
			callist[i] = 3;
		}
		for(int i = plus + minus + mul; i < plus + minus + mul + div; i++) {
			callist[i] = 4;
		}
		
		isSelected = new boolean[N - 1];
		permutation(0, numbers[0]);
		System.out.println(max + " " + min);
	}

	private static void permutation(int cnt, int cal) {
		if(cnt == N - 1) {
			if(cal > max) {
				max = cal;
			}
			if(cal < min) {
				min = cal;
			}
			return;
		}
		for(int i = 0; i < N - 1; i++) {
			if(isSelected[i]) {
				continue;
			}else {
				isSelected[i] = true;
				permutation(cnt + 1, calculate(cal, i, cnt + 1));
				isSelected[i] = false;
			}
		}
	}

	private static int calculate(int cal, int i, int cnt) {
		if(callist[i] == 1) {
			return cal + numbers[cnt];
		}
		if(callist[i] == 2) {
			return cal - numbers[cnt];
		}
		if(callist[i] == 3) {
			return numbers[cnt] * cal;
		}
		if(callist[i] == 4) {
			if(cal < 0) {
				cal = Math.abs(cal);
				return -(cal / numbers[cnt]);
			}else {
				return  cal / numbers[cnt];
			}
		}
		return -1;
	}
}
