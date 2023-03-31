package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution_G4_3190_뱀 {
	
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int map[][];
	
	static int N;
	
	static point tail;
	static point head;
	
	static int[] dx = {0, -1, 0, 1}; // 우 상 좌 하
	static int[] dy = {1, 0, -1, 0};
	
	static int now_direc = 0; // 처음은 오른쪽으로 움직임.
	
	static int answer;
	
	static Queue<point> snake;
	
	//머리 위치를 저장해야한다.
	//5: 사과 위치, 1: 뱀 위치
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map[0][0] = 1;
		
		head = new point(0, 0); // 뱀 머리
		
		snake = new ArrayDeque<>();
		
		snake.offer(tail);
		
		int M = Integer.parseInt(br.readLine());
		String str[];
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]) - 1;
			int b = Integer.parseInt(str[1]) - 1;
			map[a][b] = 5;
		}
		int L = Integer.parseInt(br.readLine());
		
		for(int c = 0; c < L; c++) {
			str = br.readLine().split(" ");
			int second = Integer.parseInt(str[0]); // 해당 초가 지나면
			String direc = str[1]; // 방항 전환
			for(int i = answer; i < second; i++) {
				move();
			}
			changeDirec(direc);
		}
		
		while(true) {
			move();
		}
		
	}

	private static void move() {
		answer++;
		int nx = head.x + dx[now_direc];
		int ny = head.y + dy[now_direc];
		if(nx >= N || nx < 0 || ny >= N || ny < 0 || map[nx][ny] == 1) {
			System.out.println(answer);
			System.exit(0);
		}
		if(map[nx][ny] == 5) {
			head = new point(nx, ny);
			snake.offer(new point(nx, ny));
			map[nx][ny] = 1;
		}
		else {
			head = new point(nx, ny);
			point temp_tail = snake.poll();
			map[temp_tail.x][temp_tail.y] = 0;
			snake.offer(new point(nx, ny));
			map[nx][ny] = 1;
		}
		
	}

	private static void changeDirec(String direc) {
		if(direc.equals("L")) {
			now_direc += 1;
			if(now_direc > 3) {
				now_direc = 0;
			}
		}else {
			now_direc -= 1;
			if(now_direc < 0) {
				now_direc = 3;
			}
		}
	}
}
