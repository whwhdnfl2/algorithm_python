import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_G3_14890_경사로 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		boolean[][] check_garo = new boolean[N][N];
		boolean[][] check_saero = new boolean[N][N];
		
		int answer = 0;
		
		String[] str;
		for(int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0; i < N; i++) { //가로로 검사
			boolean flag = false;
			for(int j = 0; j < N; j++) {
				if(j == 0) {
					if(!check_right(i, j)) {
						flag = true;
						break;
					}
				}
				else if(j == 1) {
					if(!check_right(i, j)) {
						flag = true;
						break;
					}
					if(map[i][j] != map[i][j - 1]) {
						flag = true;
						break;
					}
				}
				else if(j == 2) {
					if(check_right(i, j)) {
						flag = true;
						break;
					}
					if(map[i][j - 1] == map[i][j - 2]) {
						if(map[i][j - 1] == map[i][j]) continue;
						if(map[i][j - 1] + 1 == map[i][j]) {
							check_garo[i][j - 1] = true;
							check_garo[i][j - 2] = true;
							continue;
						}
						if(map[i][j - 1] - 1 == map[i][j]) {
							check_garo[i][j - 1] = true;
							check_garo[i][j - 2] = true;
							continue;
						}
						flag = true;
						break;
					}
					else {
						flag = true;
						break;
					}
				}
				
				else if(j == N - 1) {
					if(!check_left(i, j)) {
						flag = true;
						break;
					}
				}
				else if(j == N - 2) {
					if(check_left(i, j)) {
						flag = true;
						break;
					}
					if(map[i][j] != map[i][j + 1]) {
						flag = true;
						break;
					}
				}
				else if(j == N - 3) {
					if(check_left(i, j)) {
						flag = true;
						break;
					}
					if(map[i][j + 1] == map[i][j + 2]) {
						if(map[i][j + 1] == map[i][j]) continue;
						if(map[i][j + 1] - 1 == map[i][j]) {
							check_garo[i][j + 1] = true;
							check_garo[i][j + 2] = true;
							continue;
						}
						if(map[i][j - 1] + 1 == map[i][j]) {
							check_garo[i][j + 1] = true;
							check_garo[i][j + 2] = true;
							continue;
						}
						flag = true;
						break;
					}
					else {
						flag = true;
						break;
					}
				}
				
				else {
					if(check_left(i, j)) {
						flag = true;
						break;
					}
					if(check_right(i, j)) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				answer++;
			}
		}
		
		for(int j = 0; j < N; j++) {//가로로 검사
			for(int i = 0; i < N; i++) {
				
			}
		}
		
		
	}

	private static boolean check_left(int x, int y) {
		if(map[x][y] == map[x][y - 1] && map[x][y - 2] == map[x][y]) { // 세 개 다 같으면
			return true;
		}
		else if(map[x][y - 1] != map[x][y - 2]) { // 앞에 두개가 서로 다르면
			return false;
		}
		else if(map[x][y - 1] == map[x][y - 2]) { // 앞에 두개가 같으면
			if(map[x][y - 1] + 1 == map[x][y]){ // 1차이 나면
				return true;
				visited[y]
			}	
			else if(map[x][y - 1] - 1 == map[x][y]) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	private static boolean check_right(int x, int y) {
		
	}
	
}
