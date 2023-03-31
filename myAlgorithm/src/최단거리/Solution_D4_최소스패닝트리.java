package 최단거리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_최소스패닝트리 {
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static void makeSet() {
		parents = new int[V + 1];
		for(int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= t; test_case++ ) 
		{
			String[] str = in.readLine().split(" ");
			V = Integer.parseInt(str[0]);
			E = Integer.parseInt(str[1]);
			edgeList = new Edge[E];
			for(int i = 0; i < E; i++) {
				str = in.readLine().split(" ");
				edgeList[i] = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			}
			Arrays.sort(edgeList);
			
			makeSet();
			long result = 0, count = 0;
			
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {		
					result += edge.weight;
					if(++count == V) break;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
