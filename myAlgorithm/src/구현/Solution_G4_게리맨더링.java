package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_G4_게리맨더링 {
	
	static int N;
	static int[] population;
	static int[][] graph;
	static int ans = 999999999;
	
	static int check[];

	static int[] split;

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(sc.readLine());
		population = new int[N]; // 각 노드 별 인구
		
		String[] str = sc.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(str[i]);
		}
			
		graph = new int[N][]; // 연결된 노드 그래프
		for(int i = 0; i < N; i++) {
			str = sc.readLine().split(" ");
			graph[i]
			int temp[] = new int[M];
			for(int j = 0; j < M; j++) {
				temp[j] = sc.nextInt(); //입력 들어올 때 배열 인덱스보다 하나 더 크게 들어온다 
			}
			graph[i] = temp;
		}
		split = new int[N]; // 조합
		solve(0);
		
		if(ans == 999999999) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	public static void check1(int num, int one2) {
		if(one2 == 1) {
			check[num] = 1;
			return ;
		}else {
			check[num] = 1;
			for(int i = 0; i < graph[num].length; i++) {
				if(split[graph[num][i] - 1] == 1 && check[graph[num][i] - 1] == 0) {
					check1(graph[num][i] - 1, one2);
				}
			}
		}
		return ;
	}
	public static void check2(int num, int zero2) {
		if(zero2 == 1) {
			check[num] = 1;
			return ;
		}else {
			check[num] = 1;
			for(int i = 0; i < graph[num].length; i++) {
				if(split[graph[num][i] - 1] == 0 && check[graph[num][i] - 1] == 0) {
					check2(graph[num][i] - 1, zero2);
				}
			}
		}
		return ;
	}
	
	public static void solve(int count) {
		if(count == N) {
			int one2 = 0;
			int zero2 = 0;
			for(int i = 0; i < N; i++) { // 전부 0이거나 1인거 삭제 
				if(split[i] == 1) {
					one2 += 1;
				}else {
					zero2 += 1;
				}
				if(one2 == N  || zero2 == N) {
					return;
				}
			}
			
			
			int done1 = 1; // 한 번 재귀 돌리면 다른 부분은 볼 필요가 없다.
			int done2 = 1;
			
			check = new int[N];
			for(int i = 0; i < N; i++) {
				if(split[i] == 1 && done1 == 1) {
					check1(i, one2);
					done1 = 0;
				}else if(split[i] == 0 && done2 == 1) {
					check2(i, zero2);
					done2 = 0;
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(check[i] == 0) {
					return;
				}
			}
			
			int zero = 0;
			int one = 0;
			for(int i = 0; i < N; i++) {
				if(split[i] == 1) {
					one += population[i];
				}
				else {
					zero += population[i];
				}
			}
			int diff = Math.abs(one - zero);
		//	System.out.println(diff);
			ans = Math.min(ans, diff);
			return;
		}else {
			split[count] = 1;
			solve(count + 1);
			split[count] = 0;
			solve(count + 1);
		}
	}
}
