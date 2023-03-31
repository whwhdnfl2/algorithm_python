package 최단거리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_창용마을무리의개수 {
	
	static int[] set;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			String[] str = in.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			makeSet();
			
			for(int i = 0; i < M; i++) {
				str = in.readLine().split(" ");
				int order = Integer.parseInt(str[0]);
				int a = Integer.parseInt(str[1]);
				int b = Integer.parseInt(str[2]);
				if(order == 0) {
					union(a, b);
				}
				else {
					if(findSet(a) == findSet(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
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
