//이코테 구현

package 구현;

import java.util.Scanner;

public class Solution_이코테_왕실의나이트 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String N = scan.next();
		
		int y = N.charAt(0) - 'a';
		int x = N.charAt(1) - '0' - 1;
		
		int dx[] = {1, 2, 1, 2, -1, -2, -1, -2};
		int dy[] = {2, 1, -2, -1, 2, 1, -2, -1};
		
		int ans = 0;
		for(int i = 0; i < 8; i++) {
			int t_x = x + dx[i];
			int t_y = y + dy[i];
			if(t_x >= 0 && t_x < 8 && t_y >= 0 && t_y < 8) {
				ans ++;
			}
		}
		System.out.println(ans);
		
	}
}
