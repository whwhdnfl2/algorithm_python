package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8방탐색 -> 네 방향만 체크하면 중복없이 구할 수 있다.
public class Solution_S1_오목 {

	static String[][] badukPan = new String[19][];
	
	public static boolean check_garo1(int i, int j) {
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i][j + k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(j + 5 == 19) {
			return true;
		}
		if(badukPan[i][j + 5].equals(color)) {
			return false;
		}
		return true;
	}
	
	
	public static boolean check_garo2(int i, int j) {
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i][j - k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(j - 5 == -1) {
			return true;
		}
		if(badukPan[i][j - 5].equals(color)) {
			return false;
		}
		return true;
	}
	
	
	
	public static boolean check_saero1(int i, int j) {
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i + k][j].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i + 5 == 19) {
			return true;
		}
		if(badukPan[i + 5][j].equals(color)) {
			return false;
		}
		return true;
	}
	
	public static boolean check_saero2(int i, int j) {
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i - k][j].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i - 5 == -1) {
			return true;
		}
		if(badukPan[i - 5][j].equals(color)) {
			return false;
		}
		return true;
	}
	
	public static boolean check_daegak11(int i, int j) { // (왼아래에서 오른위로)
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i - k][j + k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i - 5 == -1 || j + 5 == 19) {
			return true;
		}
		if(badukPan[i - 5][j + 5].equals(color)) {
			return false;
		}
		return true;
	}
	
	public static boolean check_daegak12(int i, int j) { //오른위에서 왼아래로
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i + k][j - k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i + 5 == 19 || j - 5 == -1) {
			return true;
		}
		if(badukPan[i + 5][j - 5].equals(color)) {
			return false;
		}
		return true;
	}
	
	public static boolean check_daegak21(int i, int j) { //(왼위에서 오른아래로)
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i + k][j + k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i + 5 == 19 || j + 5 == 19) {
			return true;
		}
		if(badukPan[i + 5][j + 5].equals(color)) {
			return false;
		}
		return true;
		
	}
	
	public static boolean check_daegak22(int i, int j) {//(오른아래에서 왼위로)
		String color = badukPan[i][j];
		for(int k = 1; k < 5; k++) {
			if(badukPan[i - k][j - k].equals(color)) {
				continue;
			}else {
				return false;
			}
		}
		if(i - 5 == -1 || j - 5 == -1) {
			return true;
		}
		if(badukPan[i - 5][j - 5].equals(color)) {
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 19; i++) {
			String[] str = in.readLine().split(" ");
			badukPan[i] = str;
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(badukPan[i][j].equals("0")) { // 0이면 탈주
					continue;
				}
				
				// 가로 체크(왼쪽에서 오른쪽)
				if(j <= 14) {// j가 0 ~ 14일 때
					if(check_garo1(i, j) && check_garo2(i, j + 4)) {
						i++;
						j++;
						System.out.println(badukPan[i - 1][j - 1]);
						System.out.print(i + " " + j);
						return;

					}
				}
				
				
				// 세로 체크(위에서 아래로)
				if(i <= 14) {// i가 0 ~ 14일 때
					if(check_saero1(i, j) && check_saero2(i + 4, j)) {
						i++;
						j++;
						System.out.println(badukPan[i - 1][j - 1]);
						System.out.print(i + " " + j);
						return;

					}
				}
				
				
				// 대각 체크1(왼아래에서 오른위로)
				if(j <= 14 && i >= 4) {
					if(check_daegak11(i, j) && check_daegak12(i - 4, j + 4)) {
						i++;
						j++;
						System.out.println(badukPan[i - 1][j - 1]);
						System.out.print(i + " " + j);
						return;

					}
				}
				
				
				// 대각 체크2(왼위에서 오른아래로)
				if(i <= 14 && j <= 14) {
					if(check_daegak21(i, j) && check_daegak22(i + 4, j + 4)) {
						i++;
						j++;
						System.out.println(badukPan[i - 1][j - 1]);
						System.out.print(i + " " + j);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
}
