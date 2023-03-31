package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_G2_청소년상어_19236 {
	
	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][][] map = new int[4][4][2];//0: 번호, 1: 방향
		String[] str;
		for(int i = 0; i < 4; i++) {
			str = in.readLine().split(" ");
			for(int j = 0; j < 4; j++) {
				map[i][j][0] = Integer.parseInt(str[j * 2]);
				map[i][j][1] = Integer.parseInt(str[j * 2 + 1]) - 1;
			}
		}
	

		
		int sum = map[0][0][0];
		
		int[] shark = new int[3];// x, y, 방향
		shark[0] = 0;
		shark[1] = 0;
		shark[2] = map[0][0][1];
		map[0][0][0] = 0; // 먹히면 0으로 초기화.	
		dfs(sum, shark, map);
		System.out.println(max);
		
	}
	
	
	public static void dfs(int sum, int[] shark, int map[][][]) {
		int[][][] newMap = rotate(map, shark);
		boolean isAte = false;
		
		for(int i = 1; i < 4; i++) {
			int nx = shark[0] + dx[shark[2]] * i;
			int ny = shark[1] + dy[shark[2]] * i;
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			
			if(newMap[nx][ny][0] != 0) {
				
				isAte = true;
				
				int temp = newMap[nx][ny][0];
				newMap[nx][ny][0] = 0;
				
				dfs(sum + temp, new int[] {nx, ny, newMap[nx][ny][1]}, newMap);
				newMap[nx][ny][0] = temp;
			}
		}
		
		if(!isAte) {
			if(sum > max) {
				max = sum;
			}
		}
		
	}

	

	private static int[][][] rotate(int[][][] map, int[] shark) {
		
		int tempMap[][][] = new int[4][4][2];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 2; k++) {
					tempMap[i][j][k] = map[i][j][k];
				}
			}
		}
		
		
		for(int i = 1; i < 17; i++) { // 1번 물고기부터 17번 물고기까지(상어가 있는 자리와 빈 자리는 0임)
			
			boolean isChanged = false;
			
			for(int j = 0; j < 4; j++) {
				
				if(isChanged) break;
				
				for(int k = 0; k < 4; k++) { // 맵 전체 보면서 i번에 해당하는 물고기를 찾으면	
					
					if(isChanged) break;
					
					if(tempMap[j][k][0] == i) {
						for(int a = 0; a < 8; a++) { // 반시계 회전
							int nowDirec = (tempMap[j][k][1] + a) % 8;
							int nx = j + dx[nowDirec];
							int ny = k + dy[nowDirec];
							if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
							if(tempMap[nx][ny][0] != 0) { // 물고기가 있는 칸
								
								int tempCan1 = tempMap[j][k][0];
								
								tempMap[j][k][0] = tempMap[nx][ny][0];
								tempMap[j][k][1] = tempMap[nx][ny][1];
								
								tempMap[nx][ny][0] = tempCan1;
								tempMap[nx][ny][1] = nowDirec;
								
								isChanged = true;
								
								break;
								
							}else { // 빈칸이거나 상어가 있는 칸
								if(nx == shark[0] && ny == shark[1]) { //상어 칸이라면
									continue;
								}else { //빈칸이면
									tempMap[nx][ny][0] = tempMap[j][k][0];
									tempMap[nx][ny][1] = nowDirec;
									tempMap[j][k][0] = 0; // 원래 물고기 자리를 빈칸으로 만듦
									
									isChanged = true;
									
									break;
								}
							}
						}						
					}
				}
			}
		}
		return tempMap;
	}
}
