package 구현;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class person{
	int recommend;
	int time;
	int number;
	
	public person(int recommend, int time, int number) {
		super();
		this.recommend = recommend;
		this.time = time;
		this.number = number;
	}
}

public class Solution_S1_후보추천하기 {
	
	
	static int time[];
	static int[] recommend;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		sc.nextLine();
		
		//초기화
		recommend = new int[101];
		time = new int[101];
		int[] picture = new int[101];
		//List<Integer> picture = new ArrayList<>();
		int pictureCount = 0;
		
		String[] str = sc.nextLine().split(" ");
		for(int i = 0; i < R; i++) {
			int nowRecommend = Integer.parseInt(str[i]);
			
			if(pictureCount < N) {
				if(recommend[nowRecommend] == 0) {
					recommend[nowRecommend] ++; // recommend 1 더함
					picture[nowRecommend] = 1;
				//	picture.add(nowRecommend); // 사진틀에 넣음
					for(int j = 0; j < 101; j++) { // 시간 +1씩 다 함.
						if(picture[j] == 1) {
							time[j]++;
						}
					}
					pictureCount++;
				}else if(recommend[nowRecommend] > 0){
					recommend[nowRecommend] ++;
					for(int j = 0; j < 101; j++) { // 시간 +1씩 다 함.
						if(picture[j] == 1) {
							time[j]++;
						}
					}
				}
			}
			else {
				if(recommend[nowRecommend] == 0) {
					int firstIndex = 0;
					for(int j = 0; j < 101; j++) { 
						if(picture[j] == 1) {
							firstIndex = j;
							break;
						}
					}
					int firstRecommend = recommend[firstIndex]; // 사진틀에 있는 첫번째 사진의 추천수와 시간 저장.
					int firstTime = time[firstIndex];
					
					for(int j = 0; j < 101; j++) { //사진틀 다 돌면서 지울거 정한다.
						if(picture[j] == 1) {
							if(recommend[j] < firstRecommend) { // 추천수가 작다면
								firstRecommend = recommend[j];
								firstTime = time[j];
								firstIndex = j; // 지울거 저장
							}
							else if(recommend[j] == firstRecommend) { // 추천수가 같은데 시간차이가 날 경우
								if(firstTime < time[j]) {
									firstRecommend = recommend[j];
									firstTime = time[j];
									firstIndex =j; // 지울거 저장
								}
							}
						}
					}
					recommend[firstIndex] = 0;
					time[firstIndex] = 0;
					recommend[nowRecommend] = 1;
					picture[firstIndex] = 0;
					picture[nowRecommend] = 1;
					for(int j = 0; j < 101; j++) { // 시간 +1씩 다 함.
						if(picture[j] == 1) {
							time[j]++;
						}
					}
				}
				else if(recommend[nowRecommend] > 0) {
					recommend[nowRecommend] ++;
					for(int j = 0; j < 101; j++) { // 시간 +1씩 다 함.
						if(picture[j] == 1) {
							time[j]++;
						}
					}
				}
			}
//			System.out.println("reco" + Arrays.toString(recommend));
//			System.out.println("time" + Arrays.toString(time));

		}
		for(int j = 0; j < 101; j++) { // 시간 +1씩 다 함.
			if(picture[j] == 1) {
				System.out.print(j + " ");
			}
		}
	}
	
}
