package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class hall{
	int x;
	int y;
	int num;
	
	public hall(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

class ball{
	int x;
	int y;
	char direction;
	public ball(int x, int y, char direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}

public class Solution_swea_핀볼게임 {
	static int[][] map;
	
	static List<hall> hallList;
	
	static int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
		
	static int N;
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());

		for(int test_case = 1; test_case <= t; test_case++) 
		{
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			hallList = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				String[] str = in.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if(map[i][j] >= 6) {
						hallList.add(new hall(i, j, map[i][j]));
					}
				}
			}
//			System.out.println(test_case);
//			for(int i = 0; i < hallList.size(); i++) {
//				hall temp = hallList.get(i);
//				System.out.println(temp.x + " " + temp.y + " " + temp.num);
//			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						for(int k = 0; k < 4; k++) {
							answer = Math.max(game(i, j, k), answer);
						}
					}
				}
			}
	//		System.out.println(game(2, 3, 3));
			System.out.println("#" + test_case + " " + answer);
			answer = 0;
		}
	}

	private static int game(int x, int y, int direc) {
		int ans = 0;
		int first_x = x;
		int first_y = y;
		while(true) {
			
			int nx = x + dx[direc];
			int ny = y + dy[direc];
			//System.out.println(nx + " " + ny);
			
			//처음 자리 도달
			if(nx == first_x && ny == first_y) {
				break;
			}
			//벽에 박았을 때
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				ans++; // 점수 + 1
				//방향 전환
				direc = direcChange5(direc);
				x = nx;
				y = ny;
				continue;
			}
			//블랙홀 만나면 나감
			if(map[nx][ny] == -1) {
				break;
			}
			
			//그냥 앞으로 나감
			if(map[nx][ny] == 0) {
				x = nx;
				y = ny;
				continue;
			}
			
			//삼각형 박음, 정사각형 박음
			if(map[nx][ny] <= 5 && map[nx][ny] > 0) {
				ans++;
				switch(map[nx][ny]) {
				case 1:
					direc = direcChange1(direc);
					break;
				case 2:
					direc = direcChange2(direc);
					break;
				case 3:
					direc = direcChange3(direc);
					break;
				case 4:
					direc = direcChange4(direc);
					break;
				case 5:
					direc = direcChange5(direc);
					break;
				}
				x = nx;
				y = ny;
				continue;
			}
			if(map[nx][ny] >= 6 && map[nx][ny] <= 10) {
				for(int i = 0; i < hallList.size(); i++) {
					hall temp = hallList.get(i);
					if(temp.num == map[nx][ny] && (temp.x != nx || temp.y != ny)) {
						x = temp.x;
						y = temp.y;
						break;
					}
				}
			}
		}
		
		return ans;
	}

	//상하좌우
	private static int direcChange1(int direc) {
		if(direc == 0) {
			return 1;
		}
		else if(direc == 1) {
			return 3;
		}
		else if(direc == 2) {
			return 0;
		}
		else {
			return 2;
		}
	}
	
	private static int direcChange2(int direc) {
		if(direc == 0) {
			return 3;
		}
		else if(direc == 1) { 
			return 0;
		}
		else if(direc == 2) {
			return 1;
		}
		else { //
			return 2;
		}
	}
	
	private static int direcChange3(int direc) {
		if(direc == 0) {
			return 2;
		}
		else if(direc == 1) {//
			return 0;
		}
		else if(direc == 2) {//
			return 3;
		}
		else {
			return 1;
		}
	}
	
	private static int direcChange4(int direc) {
		if(direc == 0) {
			return 1;
		}
		else if(direc == 1) {
			return 2;
		}
		else if(direc == 2) {
			return 3;
		}
		else {
			return 0;
		}
	}
	
	private static int direcChange5(int direc) {
		if(direc == 0) {
			return 1;
		}
		else if(direc == 1) {
			return 0;
		}
		else if(direc == 2) {
			return 3;
		}
		else {
			return 2;
		}
	}
	


}
