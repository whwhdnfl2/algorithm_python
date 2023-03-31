package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_swea5656_벽돌깨기 {
	
	static int N;
	static int W; //가로 
	static int H; //세로 
	
	static int[][] map;
	static int[] numbers;
	
	static int answer = Integer.MAX_VALUE;
	
	static int[][] tempMap;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			String str[] = in.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			H = Integer.parseInt(str[2]);
			
			
			map = new int[H][W];
			numbers = new int[N];
			
			for(int i = 0; i < H; i++) {
				str = in.readLine().split(" ");
				for(int j = 0; j < W; j++) {
					int a = Integer.parseInt(str[j]);
					map[i][j] = a;
				}
			}
			combination(0);
			System.out.println("#" + test_case + " " + answer);
			answer = Integer.MAX_VALUE;
		}
	}


	private static void combination(int count) {
		if(count == N) {
			tempMap = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			for(int i = 0; i < N; i++) {
				bomb(numbers[i]);
				push();
			}	
			int tempans = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(tempMap[i][j] >= 1) {
						tempans++;
					}
				}
			}
			answer = Math.min(answer, tempans);
			return;
		}
		for(int i = 0; i < W; i++) {
			numbers[count] = i;
			combination(count + 1);
		}
	}


	private static void bomb(int y) {
		for(int i = 0; i < H; i++) {
			if(tempMap[i][y] >= 1) {
				breakbuk(i, y, tempMap[i][y]);
				break;
			}
		}
	}
	
	private static void breakbuk(int x, int y, int temp) {
		for(int i = - temp + 1; i <= temp - 1; i++) {
			if(x + i >= 0 && x + i < H) {
				int now = tempMap[x + i][y];
				if(now == 0) continue;
				tempMap[x + i][y] = 0;
				breakbuk(x + i, y, now);
			}
		}
		for(int i = -temp + 1; i <= temp - 1; i++) {
			if(y + i >= 0 && y + i < W) {
				int now = tempMap[x][y + i];
				if(now == 0) continue;
				tempMap[x][y + i] = 0;
				breakbuk(x, y + i, now);
			}
		}
	}
	
	private static void push() {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(tempMap[j][i] >= 1) stack.add(tempMap[j][i]);
				tempMap[j][i] = 0;
			}
			int x = H-1;
			while(!stack.isEmpty()) {
				tempMap[x][i] = stack.pop();
				x--;
			}
		}
	}
	
}
