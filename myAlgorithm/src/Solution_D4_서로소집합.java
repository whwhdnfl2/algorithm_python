import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_서로소집합 {
	
	static int[] set;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 0;
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			String[] str = in.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			makeSet();
			
			for(int i = 0; i < M; i++) {
				str = in.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				union(a, b);
			}
			
			int check[] = new int [N + 1];
			findSet(N);
			
			for(int i = 1; i <= N; i++) {
				check[set[i]] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				if(check[i] == 1) ans++;
			}
			System.out.println(Arrays.toString(set));
			sb.append(ans);
			System.out.println(sb);
		}
	}
	
	// 단위 집합 생성
	private static void makeSet() {
		
		set = new int[N + 1]; // 인덱스 0번부터 사용
		
		// 자신의 부모노드를 자신의 값으로 설정
		
		for(int i = 0; i <= N; i++) {
			set[i] = i;
		}
	}
	
	//a의 집합 찾기 (a의 대표자 찾기)
	public static int findSet(int a) {
		if(set[a] == a) {
			return a;
		}
		
		//return findSet(parents[a]);
		return set[a] = findSet(set[a]);
	}
	
	//a, b 두 집합 합치기
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		//대포자가 같으면 같은 집합
		if(aRoot == bRoot) {	
			return false;
		}
		
		//b 집합의 대표자는 a집합 대표자 밑으로 들어감.
		set[bRoot] = aRoot;
		return true;
	}
}
