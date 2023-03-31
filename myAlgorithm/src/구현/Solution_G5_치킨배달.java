package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BBQ{ // 치킨집 좌표
	int x;
	int y;
	public BBQ(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Solution_G5_치킨배달 {
	//input
	static int N; //지도 크기
	static int M; //고를 치킨 집 개수
	static String[][] map; //도시 지도
	
	static int chickenNum; //도시의 치킨집 개수
	
	static boolean isSelected[]; // 조합 생성을 위한 선택됐는지 체크하는 배열

	//static List<BBQ> chickenArray; // 치킨집 좌표를 저장하는 리스트
	static BBQ[] chickenArray; // 치킨집 좌표를 저장하는 리스트
	
	static int answer = Integer.MAX_VALUE; // 최종 정답
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		//Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(sc.readLine());
		M = Integer.parseInt(sc.readLine());
		//sc.nextLine();
		
		//초기화
		map = new String[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.readLine().split(" ");
		}
		
	//	chickenArray = new ArrayList<>();
		chickenArray = new BBQ[2501];
		
		int chickenIndex = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].equals("2")) {
					chickenNum ++;
					//chickenArray.add(new BBQ(i, j));
					chickenArray[chickenIndex++] = new BBQ(i, j);
				}
			}
		}
		
		isSelected = new boolean[chickenNum];
		
		//답 구하고 출력
		combination(0, 0);
		System.out.println(answer);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			
			int combinationAnswer = 0; // 해당 조합에서의 답인 치킨거리의 최솟값의 합을 구한다.
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j].equals("1")) { // 원래 temp_map
						
						int dist = Integer.MAX_VALUE; // 해당 좌표에서의 치킨거리를 구한다.
						
						for(int k = 0; k < chickenNum; k++) { 
							if(isSelected[k]) {			// 제거되지 않은 치킨집을 고른다.
							//	BBQ Chicken = chickenArray.get(k);
								BBQ Chicken = chickenArray[k];
								int x = Chicken.x;
								int y = Chicken.y;
								dist = Math.min(dist, check_distance(x, y, i, j));
							}
						}
						combinationAnswer += dist;
					}
				}
			}
			answer = Math.min(answer, combinationAnswer);
			return;
		}else {
			for(int i = start; i < chickenNum; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				combination(cnt + 1, i + 1);
				isSelected[i] = false;
			}
		}
	}
	
	private static int check_distance(int x, int y, int i, int j) {
		return Math.abs(x - i) + Math.abs(y - j);
	}
}
