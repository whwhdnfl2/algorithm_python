package 구현;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;


public class Solution_모의sw역량테스트_무선충전 {
	 static int[] dx = {-1, 0, 1, 0}; //상우하좌
	 static int[] dy = {0, 1, 0, -1};
	 
	 static int[] dx1 = {0, -1, 0, 1, 0}; //않상우하좌
	 static int[] dy2 = {0, 0, 1, 0, -1};
	 
	 static int[][][] map;
	 
	 static int[][] visited;
	 


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) 
		{
			
			int ans = 0; //답
			int M = sc.nextInt(); // 총 이동시간
			int A = sc.nextInt(); // bc 개수
			map = new int[11][11][A]; // 각 지도의 좌표에 어떤 bc가 있는지 표시한다.
			int user1[] = new int[M]; // 이동 정보
			int user2[] = new int[M];
			int bc[] = new int[A]; // 각 배터리 별 처리량
			
			int userAx = 1;
			int userAy = 1;
			int userBx = 10;
			int userBy = 10;
			
			sc.nextLine();
			String str1[] = sc.nextLine().split(" ");
			String str2[] = sc.nextLine().split(" ");
			for(int i = 0; i < M; i++) {
				user1[i] = Integer.parseInt(str1[i]);
				user2[i] = Integer.parseInt(str2[i]);
			}
			
			// 배터리 좌표 받으면서 map에 표시까지 한다.
			for(int i = 0; i < A; i++) {
				int bcy = sc.nextInt(); // 배터리 좌표
				int bcx = sc.nextInt();
				int C = sc.nextInt(); // 충전 범위
				int P = sc.nextInt(); // 처리량
				bc[i] = P;
				visited = new int[11][11];
				bfs(bcx, bcy, C, i);
				//System.out.println();
				for(int j = 1; j < 11; j++) {
					//System.out.println(Arrays.toString(visited[j]));
				}
			}
			
			//명령대로 움직이며 정답 저장.
			ans += check(userAx, userAy, userBx, userBy, A, bc);
			for(int i = 0; i < M; i++) {
				userAx += dx1[user1[i]];
				userAy += dy2[user1[i]];
				userBx += dx1[user2[i]];
				userBy += dy2[user2[i]];
//				System.out.print("A" + userAx + " " + userAy + "    ");
//				System.out.println("B" + userBx + " " + userBy);
				ans += check(userAx, userAy, userBx, userBy, A, bc);
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static void bfs(int x, int y, int C, int order) {
		visited[x][y] = 1;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[]{x, y, 0});
		map[x][y][order] = 1; // x,y좌표에 order번째 bc가 존재한다.(영향이 닿는다.)
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cnt = temp[2];
			if(cnt == C ) {
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx >= 1 && nx < 11 && ny >= 1 && ny < 11) {
					if(visited[nx][ny] == 0) {
						map[nx][ny][order] = 1;
						queue.offer(new int[] {nx, ny, cnt + 1});
						visited[nx][ny] = 1;
					}
				}
			}
		}
	}
	
	public static int check(int userAx, int userAy, int userBx, int userBy, int A, int[] bc) {
		int[] userAbc = map[userAx][userAy]; // A가 있는 곳의 배터리 목록
//		System.out.println(Arrays.toString(userAbc));
		
		int[] userBbc = map[userBx][userBy]; // B가 있는 곳의 배터리 목록
//		System.out.println(Arrays.toString(userBbc));
		
		int answer = 0;
		
		for(int i = 0; i < A; i++) {
			if(userAbc[i] == 1 && userBbc[i] == 1) {
				answer = Math.max(answer, bc[i]);
			}
		}
		
		int tempans = 0;
		for(int i = 0; i < A; i++) {
			if(userAbc[i] == 1) {
				tempans = bc[i];
			}
			for(int j = 0; j < A; j++) {
				if(i == j) continue;
				if(userBbc[j] == 1) {
					answer = Math.max(answer, tempans + bc[j]);
				}
			}
			answer = Math.max(answer, tempans);
		}
//		tempans = 0;
//		for(int i = 0; i < A; i++) {
//			if(userBbc[i] == 1) {
//				tempans = bc[i];
//			}
//			for(int j = 0; j < A; j++) {
//				if(i == j) continue;
//				if(userAbc[j] == 1) {
//					answer = Math.max(answer, tempans + bc[j]);
//				}
//			}
//			answer = Math.max(answer, tempans);
//		}
		
		return answer;
	}
}
