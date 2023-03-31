package 구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_상호의배틀필드 {
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	
	}

	static int N, M;
	static char[][] map;
	static Pos me;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(in.readLine());
		int tc = 1;
		while(T-- > 0) {
			sb.append("#").append(tc).append(" ");
			String[] line = in.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						me = new Pos(i, j);
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			int cmdN = Integer.parseInt(in.readLine());
			char[] cmds = in.readLine().toCharArray();
			for (int i = 0; i < cmdN; i++) {
				switch(cmds[i]) {
				case 'U': up(); break;
				case 'D': down(); break;
				case 'L': left(); break;
				case 'R': right(); break;
				case 'S': shoot(); break;
				}
			}
			
			//print
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			sb.append("\n");
			tc++;
		}
		System.out.println(sb);
	}

	private static void shoot() {
		int dr = 0;
		int dc = 0;
		switch(map[me.r][me.c]){
		case '^': dr = -1;break;
		case 'v': dr = 1; break;
		case '<': dc = -1; break;
		case '>': dc = 1; break;
		}
		int bombR = me.r;
		int bombC = me.c;
		while(true) {
			//System.out.println(1);
			bombR += dr;
			bombC += dc;
			
			if (bombR < 0 || bombR >= N || bombC < 0 || bombC >= M) break;
			if (map[bombR][bombC] == '#') break;
			if (map[bombR][bombC] == '*') {
				map[bombR][bombC] = '.';
				break;
			}
			
		}
	}

	private static void right() {
		map[me.r][me.c] = '>';
		int nr = me.r;
		int nc = me.c + 1;
		if(move(nr, nc, '>')) {
			map[nr][nc - 1] = '.';
		}
	}

	private static void left() {
		map[me.r][me.c] = '<';
		int nr = me.r;
		int nc = me.c - 1;
		if(move(nr, nc, '<')) {
			map[nr][nc + 1] = '.';
		}
	}

	private static void down() {
		map[me.r][me.c] = 'v';
		int nr = me.r + 1;
		int nc = me.c;
		if(move(nr, nc, 'v')) {
			map[nr - 1][nc] = '.';
		}
	}

	private static void up() {
		map[me.r][me.c] = '^';
		int nr = me.r - 1;
		int nc = me.c;
		if(move(nr, nc, '^')){
			map[nr + 1][nc] = '.';
		}
	}

	private static boolean move(int nr, int nc, char mo) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) return false;
		if (map[nr][nc] == '.') {
			me.r = nr;
			me.c = nc;
			map[nr][nc] = mo;
			return true;
		}
		return false;
	}
}
