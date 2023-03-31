package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_G1_15644_구슬탈출3 {
	
	static int N, M;
	
	static char[][] map;

	static int[] all;


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		
		int redx = 0;
		int redy = 0;
		int bluex = 0;
		int bluey = 0;
		
		
		for(int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					redx = i;
					redy = j;
				}
				if(map[i][j] == 'B') {
					bluex = i;
					bluey = j;
				}
			}
		}
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {redx, redy, 0, bluex, bluey});
		bfs(queue);
	}

	private static void bfs(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[2] >= 10) { // 깊이가 10이 넘어가버리면 break한다.
				System.out.println(0);
				break;
			}
			for(int i = 0; i < 4; i++) {
				check(queue, temp, i);
			}
		}
	}
	
	static int[] dx = {1, -1, 0, 0}; // 아래로, 위로, 우로, 좌로
	static int[] dy = {0, 0, 1, -1};

	private static void check(Queue<int[]> queue, int[] temp, int i) {
		int nxr = temp[0];
		int nyr = temp[1];
		int nxb = temp[3];
		int nyb = temp[4];
		
		int b_nxr = 0;
		int b_nyr = 0;
		int b_nxb = 0;
		int b_nyb = 0;
		
		while(true) {
			b_nxr = nxr;
			b_nyr = nyr;
			b_nxb = nxb;
			b_nyb = nyb;
			nxr += dx[i];
			nyr += dy[i];
			nxb += dx[i];
			nyb += dy[i];
			if(nxr < N  && nxr >= 0 && nxb < N  && nxb >= 0 && nyr < M && nyr >= 0 && nyb < M && nyb >= 0) {
				if(map[nxr][nyr] == '#') { // 벽에 박음
					nxr -= dx[i];
					nyr -= dy[i];
				}
				if(map[nxb][nyb] == '#') { // 벽에 박음
					nxb -= dx[i];
					nyb -= dy[i];
				}
				
				if(map[nxb][nyb] == 'O') { // 가다가 파란색이 구멍에 들어감.
					break; // queue에 안넣음.
				}
				
				else if(map[nxr][nyr] == 'O') { // 가다가 빨간색이 구멍에 들어감.
					boolean flag = false;
					while(true) {
						nxb += dx[i];
						nyb += dy[i];
						if(map[nxb][nyb] == 'O'){ // 파란색도 구멍 만나면
							flag = true;
							break;
						}
						if(map[nxb][nyb] == '#') { // 파란색이 벽을 만나면
							break;
						}
					}
					if(!flag) {
						System.out.println(1); // depth+1해주고 출력하고 종료.
						System.exit(0);
					}else {
						break; // 파란색도 들어감.
					}

				}
				
				if(b_nxr == nxr && b_nyr == nyr && (b_nxb != nxb || b_nyb != nyb)) { // 빨간색이 안바뀌고 파란색은 바뀜.
					if(nxr == nxb && nyr == nyb) { // 겹쳐버림.
						queue.offer(new int[] {nxr, nyr, temp[2] + 1, b_nxb, b_nyb});
					}
				}
				
				else if(b_nxb == nxb && b_nyb == nyb && (b_nxr != nxr || b_nyr != nyr)) { // 파란색이 안바뀌고 빨간색은 바뀜.
					if(nxr == nxb && nyr == nyb) { // 겹쳐버림.
						queue.offer(new int[] {b_nxr, b_nyr, temp[2] + 1, nxb, nyb});
					}
				}
				else if(b_nxr == nxr && b_nyr == nyr && b_nxb == nxb && b_nyb == nyb) {//바뀌지 않았음.
					queue.offer(new int[] {nxr, nyr, temp[2] + 1, nxb, nyb});
					break; // queue에 넣음.
				}
			}
		}
	}
}
