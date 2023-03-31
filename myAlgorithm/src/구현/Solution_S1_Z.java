package 구현;
import java.util.Scanner;

public class Solution_S1_Z {

	static int N, r, c;
	
	static int map[][];
	
	static int count = 0;
	static int ans = 0;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		divide((int)Math.pow(2, N), 0, 0);
	}


	private static void divide(int size, int startX, int startY) {
		if(size == 2) {
			count++;
			if(startX == r && startY == c) {
				ans = count;
				System.out.println(ans - 1);
				System.exit(0);
			}
			count++;
			startY = startY + 1;
			if(startX == r && startY == c) {
				ans = count;
				System.out.println(ans - 1);
				System.exit(0);
			}
			count++;
			startX = startX + 1;
			startY = startY - 1;
			if(startX == r && startY == c) {
				ans = count;
				System.out.println(ans - 1);
				System.exit(0);
			}
			count++;
			startY = startY + 1;
			if(startX == r && startY == c) {
				ans = count;
				System.out.println(ans - 1);
				System.exit(0);
			}
			return;
		}
		else {
			
			int half = size / 2;
			if(r < half + startX && c < half + startY) {
				divide(half, startX, startY);
			}
			else if(r < half + startX && c >= half + startY){
				count += half * half;
				divide(half, startX, startY + half);
			}
			else if(r >= half + startX && c < half + startY) {
				count += half * half * 2;
				divide(half, startX + half, startY);
			}else {
				count += half * half * 3;
				divide(half, startX + half, startY + half);
			}
		}
	}
	
}
