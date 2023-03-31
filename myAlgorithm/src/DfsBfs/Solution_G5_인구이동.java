package DfsBfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



class point{
	int x;
	int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution_G5_인구이동 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int N, L, R;
	static int [][] population;
	static int [][] visited;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		sc.nextLine();
		population = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			for(int j = 0; j < str.length; j++) {
				population[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		while(true) {
			if(!compute()) {
				break;
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(population[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(ans);
	}

	private static boolean compute() {
		boolean flag = false; // 연합이 한번이라도 생기면 true
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					if(bfs(i, j)){
						flag = true;
					}
				}
			}
		}
		//System.out.println(flag);
		if(flag) ans++;
		return flag;
	}

	private static boolean bfs(int a, int b) {
		Queue<point> queue = new ArrayDeque<>();
		
		boolean flag = false; // 연합이 생기면 true로
		
		point good = new point(a, b);
		queue.offer(good);
		visited[a][b] = 1;
		List<point> Union = new ArrayList<>(); // bfs 돌릴 때 생긴 연합
		int sumOfPopulation = population[a][b]; //연합 인구 합
		Union.add(good);
		
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int diff = Math.abs(population[x][y] - population[nx][ny]);
					if(diff >= L && diff <= R && visited[nx][ny] == 0) {
						flag = true;
						visited[nx][ny] = 1;
						point temp_point = new point(nx, ny);
						queue.offer(temp_point);
						Union.add(temp_point);
						sumOfPopulation += population[nx][ny];
					}
				}
			}
		}
		if(flag) {
			int divSumOfPopulation = sumOfPopulation / Union.size();
			for(int i = 0; i < Union.size(); i++) {
				population[Union.get(i).x][Union.get(i).y] = divSumOfPopulation;
			}
		}
		//System.out.println(flag);
		return flag;
	}
}
