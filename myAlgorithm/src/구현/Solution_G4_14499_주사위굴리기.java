package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_G4_14499_주사위굴리기 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] number = {1, 5, 2, 3, 4, 0}; // 123456 : 처음 스타트
	static int[] gap = {0, 0, 0, 0, 0, 0};
	static int now_bottom = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		x = Integer.parseInt(str[2]);
		y = Integer.parseInt(str[3]);
		K = Integer.parseInt(str[4]);
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		str = in.readLine().split(" ");
		char[] order = new char[K];
		for(int i = 0; i < K; i++) {
			order[i] = str[i].charAt(0);
		}

		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		
		for(int a = 0 ; a < K; a++) {			
			int nx = x + dx[order[a] - '0' - 1];
			int ny = y + dy[order[a] - '0' - 1];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
			x = nx;
			y = ny;
			
			
			if(order[a] == '1') { //동으로 굴림
				for(int i = 0; i < 6; i++) {
					if(number[i] == 1) { // 위를 보고 있다면
						number[i] = 2;
					}
					else if(number[i] == 0) { // 아래를 보고 있다면
						number[i] = 4;
					}
					else if(number[i] == 2) { // 동를 보고 있다면
						number[i] = 0;
						now_bottom = i;
					}
					else if(number[i] == 3) { // 남를 보고 있다면
						number[i] = 3;
					}
					else if(number[i] == 4) { // 서를 보고 있다면
						number[i] = 1;
					}
					else if(number[i] == 5) { // 북를 보고 있다면
						number[i] = 5;
					}
				}
			}
			if(order[a] == '2') {
				for(int i = 0; i < 6; i++) {
					if(number[i] == 1) { // 위를 보고 있다면
						number[i] = 4;
					}
					else if(number[i] == 0) { // 아래를 보고 있다면
						number[i] = 2;
					}
					else if(number[i] == 2) { // 동를 보고 있다면
						number[i] = 1;
					}
					else if(number[i] == 3) { // 남를 보고 있다면
						number[i] = 3;
					}
					else if(number[i] == 4) { // 서를 보고 있다면
						number[i] = 0;
						now_bottom = i;
					}
					else if(number[i] == 5) { // 북를 보고 있다면
						number[i] = 5;
					}
				}
			}
			if(order[a] == '3') {
				for(int i = 0; i < 6; i++) {
					if(number[i] == 1) { // 위를 보고 있다면
						number[i] = 5;
					}
					else if(number[i] == 0) { // 아래를 보고 있다면
						number[i] = 3;
					}
					else if(number[i] == 2) { // 동를 보고 있다면
						number[i] = 2;
					}
					else if(number[i] == 3) { // 남를 보고 있다면
						number[i] = 1;
					}
					else if(number[i] == 4) { // 서를 보고 있다면
						number[i] = 4;
					}
					else if(number[i] == 5) { // 북를 보고 있다면
						number[i] = 0;
						now_bottom = i;
					}
				}
			}
			if(order[a] == '4') {
				for(int i = 0; i < 6; i++) {
					if(number[i] == 1) { // 위를 보고 있다면
						number[i] = 3;
					}
					else if(number[i] == 0) { // 아래를 보고 있다면
						number[i] = 5;
					}
					else if(number[i] == 2) { // 동를 보고 있다면
						number[i] = 2;
					}
					else if(number[i] == 3) { // 남를 보고 있다면
						number[i] = 0;
						now_bottom = i;
					}
					else if(number[i] == 4) { // 서를 보고 있다면
						number[i] = 4;
					}
					else if(number[i] == 5) { // 북를 보고 있다면
						number[i] = 1;
					}
				}
			}
			if(map[nx][ny] == 0) {
				map[nx][ny] = gap[now_bottom];
			}
			else {
				gap[now_bottom] = map[nx][ny];
				map[nx][ny] = 0; 
			}
			
			for(int i = 0; i < 6; i++) {
				if(number[i] == 1) {
					sb.append(gap[i] + "\n");
				}
			}
		}
		System.out.print(sb);
	}
}
