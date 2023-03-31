import java.util.HashSet;
import java.util.Scanner;

//class point{
//	int x;
//	int y;
//	
//	public point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//	
//}

public class Solution_G4_알파벳 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int R;
	static int C;
	
	static int ans;
	
	static String[][] map;
	
	static HashSet<String> set = new HashSet<String>(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		sc.nextLine();
		map = new String[R][C];
		
		for(int i = 0; i < R; i++) {
			String[] str = sc.nextLine().split("");
			map[i] = str;
		}
		
		set.add(map[0][0]);
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int cnt) {
		if(cnt > ans) ans = cnt;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(!set.contains(map[nx][ny])) {
					set.add(map[nx][ny]);
					dfs(nx, ny, cnt + 1);
					set.remove(map[nx][ny]);
				}
			}
		}
	}
	
	
}
