import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_G5_월드컵 {
	//승, 패의 수가 같아야함.
	//총 경기수가 30이어야함.
	//각 국가마다 경기를 5번 해야함.
	//무승부

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			List<Integer> sameList = new ArrayList<>();
			int[] loseArray = new int[6];
			int[] winArray = new int[6];
			boolean flag = false;
			boolean flag5 = false;
			boolean flag6 = false;
			int winCount = 0;
			int loseCount = 0;
			int sameCount = 0;
			for(int j = 0; j < 6; j++) {
				int win = sc.nextInt();
				int same = sc.nextInt();
				int lose = sc.nextInt();
				
				winCount += win;
				loseCount += lose;
				sameCount += same;
				if(win == 5) {
					flag5 = true;
					loseArray[j] = 1;
				}else {
					loseArray[j] = lose;
				}
				
				if(lose == 5) {
					flag6 = true;
					winArray[j] = 1;
				}else {
					winArray[j] = win;
				}
				
				
				if(same != 0) {
					sameList.add(same);
				}
				
				if(win + same + lose != 5) { // 각 국가마다 경기 5번 확인
					System.out.print(0 + " ");
					flag = true;
					break;
				}
			}
			if(flag) {
				continue;
			}
			boolean flag4 = false;
			//5인 win이 있다면
			if(flag5) {
				for(int j = 0; j < 6; j++) {
					if(loseArray[j] == 0) {
						System.out.print(0 + " ");
						flag4 = true;
						break;
					}
				}
			}
			if(flag4) {
				continue;
			}
			
			boolean flag10 = false;
			//5인 lose가 있다면
			if(flag6) {
				for(int j = 0; j < 6; j++) {
					if(winArray[j] == 0) {
						System.out.print(0 + " ");
						flag10 = true;
						break;
					}
				}
			}
			if(flag10) {
				continue;
			}
			
			// 총 경기수 30
			if(loseCount + winCount + sameCount != 30) {
				System.out.print(0 + " ");
				continue;
			}
			//승리와 패배 수가 같나
			if(loseCount != winCount) {
				System.out.print(0 + " ");
				continue;
			}
			// 무승부 확인

			if(sameList.size() != 0) {
				Collections.sort(sameList, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});
				for(int j = 0; j < sameList.size(); j++) {
					for(int k = j + 1; k < sameList.size(); k++) {
						if(sameList.get(j) != 0 && sameList.get(k) != 0) {
							sameList.set(j, sameList.get(j) - 1);
							sameList.set(k, sameList.get(k) - 1);
						}
					}
				}
				
				boolean flag2 = false;
				for(int j = 0; j < sameList.size(); j++) {
					if(sameList.get(j) != 0) {
						System.out.print(0 + " ");
						flag2 = true;
						break;
					}
				}
				if(flag2) {
					continue;
				}
			}
			System.out.print(1 + " ");
		}
	}
}
