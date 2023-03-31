package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class atom{
	int x;
	int y;
	int direc;
	int energy;
	public atom(int x, int y, int direc, int energy) {
		super();
		this.x = x;
		this.y = y;
		this.direc = direc;
		this.energy = energy;
	}
	@Override
	public String toString() {
		return "atom [x=" + x + ", y=" + y + ", direc=" + direc + ", energy=" + energy + "]";
	}
}

public class Solutiuon_swea5648_원자소멸시뮬레이션 {
	
	static int N;
	
	static int count;
	
	static int ans;
	
	static atom[] atoms;
	
	static boolean[] visited;
	
	static int[] dx = {1, -1, 0, 0}; //우 
	static int[] dy = {0, 0, -1 ,1};


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) 
		{
			N = Integer.parseInt(in.readLine());
			count = N;
			atoms = new atom[N];
			visited = new boolean[N];
			String str[] = {" "};
			for(int i = 0; i < N; i++) {
				str = in.readLine().split(" ");
				atoms[i] = new atom(Integer.parseInt(str[1]) * 2, Integer.parseInt(str[0]) * 2, Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			}
			
			for(int a = 0; a < 4002; a++) {
				if(!simulation()) break;
				if(count <= 0) break;
			}
			System.out.println("#" + test_case + " " + ans);
			ans = 0;
		}
	}



	private static boolean simulation() {
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			int direc = atoms[i].direc;
			atoms[i].x += dx[direc];
			atoms[i].y += dy[direc];
			if(atoms[i].x >= 2002 || atoms[i].x <= -2002 || atoms[i].y >= 2002 || atoms[i].y <= -2002) {
				count--;
				visited[i] = true;
			}
		}
		
		
		
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			for(int j = i + 1; j < N; j++) {
				if(visited[j]) continue;
				if(atoms[i].x == atoms[j].x && atoms[i].y == atoms[j].y) {
					//System.out.println("asdasd");
					flag = true;
					ans += atoms[j].energy;
					visited[j] = true;
					count--;
				}
			}
			if(flag) {
				visited[i] = true;
				count--;
				ans += atoms[i].energy;
				flag = false;
			}
		}
		return true;
	}
}
