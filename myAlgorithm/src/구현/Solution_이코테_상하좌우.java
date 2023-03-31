//이코테 구현

package 구현;

import java.util.Scanner;

public class Solution_이코테_상하좌우 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] map = new int[N + 1][N + 1];
		String temp = scan.nextLine();
		 temp = scan.nextLine();
		String[] move = temp.split(" ");	
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		String[] good = {"U", "D", "L", "R"};
		int x = 1;
		int y = 1;
		for(int i = 0; i < move.length; i++) {
			for(int j = 0; j < 4; j++) {
				if(good[j].equals(move[i])) {
					int t_x = x + dx[j];
					int t_y = y + dy[j];
					if(1 <= t_x && t_x <= N && 1<= t_y && t_y <= N) {
						x = t_x;
						y = t_y;
					}
				}
			}
		}
		System.out.println(x + " " + y);
	}
}
