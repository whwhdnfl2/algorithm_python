package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_swea2115_벌꿀채취 {
	static int N, M, C;
	
	static int numbers[];
	static int numbers2[];
	
	static int answer;
	
	static int[][] honey;
	
	static int worker1;
	static int worker2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			String[] str = in.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			C = Integer.parseInt(str[2]);
			
			numbers = new int[2];
			numbers2 = new int[M];
			honey = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				str = in.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(str[j]);
				}
			}
			combination(0, 0);
			System.out.println("#" + test_case + " " + answer);
			worker1 = 0;
			worker2 = 0;
			answer = 0;
		}
	}

	private static void combination(int count, int start) {
		if(count == 2) {
			int x1 = numbers[0] / N;
			int y1 = numbers[0] % N;
			
			int x2 = numbers[1] / N;
			int y2 = numbers[1] % N;
			if(x1 == x2) { // 같은 행에 있을 때 
				if(y1 == y2) { // 같은 좌표면 
					return;
				}
				else if(y1 > y2) { //조금이라도 겹치면 리턴 
					if(y2 + M - 1 >= y1) {
						return;
					}
				}
				else if(y1 < y2) {
					if(y1 + M - 1 >= y2) { // 조금이라도 겹치면 리턴 
						return;
					}
				}
			}
			if(y1 + M > N || y2 + M > N) {
				return;
			}
			
			
			for(int i = 1; i <= M; i++) {
				check1(x1, y1, 0, 0, i);
				for(int j = 0; j <= M; j++) {
					check2(x2, y2, 0, 0, j);
				}
			}
			answer = Math.max(answer, worker1 + worker2);
			worker1 = 0;
			worker2 = 0;
			
			return;
		}
		for(int i = start; i < N * N; i++) {
			numbers[count] = i;
			combination(count + 1, i + 1);
		}
	}

	private static void check1(int x1, int y1, int count, int start, int stop) {
		if(count == stop) {
			int temp1 = 0;
			for(int i = 0; i < stop; i++) {
				temp1 += honey[x1][y1 + numbers2[i]];
			}
			int tworker1 = 0;
			if(temp1 <= C) {
				for(int i = 0; i < stop; i++) {
					tworker1 += Math.pow(honey[x1][y1 + numbers2[i]], 2);
				}
			}
			worker1 = Math.max(worker1, tworker1);
			return;
		}
		for(int i = start; i < M; i++) {
			numbers2[count] = i;
			check1(x1, y1, count + 1, i + 1, stop);
		}
	}
	
	private static void check2(int x2, int y2, int count, int start, int stop) {
		if(count == stop) {
			int temp2 = 0;
			for(int i = 0; i < stop; i++) {
				temp2 += honey[x2][y2 + numbers2[i]];
			}
			int tworker2 = 0;

			if(temp2 <= C) {
				for(int i = 0; i < stop; i++) {
					tworker2 += Math.pow(honey[x2][y2 + numbers2[i]], 2);
				}
			}
			worker2 = Math.max(worker2, tworker2);
			return;
		}
		for(int i = start; i < M; i++) {
			numbers2[count] = i;
			check2(x2, y2, count + 1, i + 1, stop);
		}
	}
}
