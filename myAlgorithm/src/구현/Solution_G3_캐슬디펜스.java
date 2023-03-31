package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_G3_캐슬디펜스 {
	
	static int N, M;
	static int D;
	static int ans = 0;
	static int[] archor;
	
	static int[] x = new int[3];
	
	
	static List<String[]> map = new ArrayList<>();
	
	
	
	public static void make_solve(int cnt, int oneCount) {
		if(cnt == M && oneCount == 3) { //1이 딱 세개만 있는거 생성
			
			List<String[]> shootedOrIn = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				String[] asd = new String[M];
				shootedOrIn.add(new String[M]);
			}
			
			
			int temp = 0;
			for(int i = 0; i < M; i++) {
				if(archor[i] == 1) {
					x[temp] = i;
					temp++;
				}
			}
			
			
			int [][] good = {{ //각 순서대로 
				-1, -1, 999999999
			},{
				-1, -1, 999999999
			},{
				-1, -1, 999999999
			}
			};

			
			int temp_ans = 0;
	

			for(int count = 0; count < N; count++) { //한 턴
				for(int archorSelect = 0; archorSelect < 3; archorSelect++) { // 궁수 선택
					for(int i = N - 1 - count; i >= 0; i--) { //맨 밑부터 체크. 그런데 한 턴씩 진행될 때마다 맨 밑 제외
						for(int j = 0; j < M; j++) {
							if(shootedOrIn.get(i)[j] == null && map.get(i)[j].equals("1")) {
								if(good[archorSelect][2] > distance(x[archorSelect], i + count, j) && distance(x[archorSelect], i + count, j) <= D) {
									good[archorSelect][0] = i;
									good[archorSelect][1] = j;
									good[archorSelect][2] = distance(x[archorSelect], i + count, j);
								}
								else if(good[archorSelect][2] == distance(x[archorSelect], i + count, j) && good[archorSelect][1] > j) {
									good[archorSelect][0] = i;
									good[archorSelect][1] = j;
									good[archorSelect][2] = distance(x[archorSelect], i + count, j);
								}
							}
						}
					}
				}
				for(int archorSelect = 0; archorSelect < 3; archorSelect++) {
					if(good[archorSelect][0] == -1) {
						continue;
					}
					if(shootedOrIn.get(good[archorSelect][0])[good[archorSelect][1]] == null) {
						shootedOrIn.get(good[archorSelect][0])[good[archorSelect][1]] = "1";
						temp_ans += 1;
					}
				}
				good[0][0] = -1;
				good[1][0] = -1;
				good[2][0] = -1;
				good[0][1] = -1;
				good[1][1] = -1;
				good[2][1] = -1;
				good[0][2] = 999999999;
				good[1][2] = 999999999;
				good[2][2] = 999999999;

				
			}
			

			if(ans <= temp_ans) {
				ans = temp_ans;
			}
			return;
		}
		if(cnt == M && oneCount != 3) {
			return;
		}
		else {
			archor[cnt] = 1;
			make_solve(cnt + 1, oneCount+1);
			archor[cnt] = 0;
			make_solve(cnt + 1, oneCount);
		}
	}
	
	public static int distance(int archorLo, int oneX, int oneY) {
		return Math.abs( N - oneX) + Math.abs(oneY - archorLo);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		sc.nextLine();
		
		archor = new int[M];
		
		for(int i = 0; i < N; i++) {
			String str[] = sc.nextLine().split(" ");
			map.add(str);
		}
		
		
		make_solve(0, 0);
		
		System.out.println(ans);
		
		
	}
}