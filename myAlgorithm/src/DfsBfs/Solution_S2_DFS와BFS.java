//백준 1260

package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_S2_DFS와BFS {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
//	public static ArrayList<ArrayList<Integer>> graph;
	public static int[] visited;
	public static int V;
	static Node[] graph;
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visited[V] = 1;
		while(!q.isEmpty()) {
			int good = q.poll();
			System.out.print(good + " ");
			for(int i = 0; i < graph.get(good).size(); i++) {
				if(visited[graph.get(good).get(i)] == 0) {
					q.add(graph.get(good).get(i));
					visited[graph.get(good).get(i)] = 1;
				}
			}
		}
	}
	
	public static void dfs(int num) {
		visited[num] = 1;
		System.out.print(num +  " ");
		for(int i = 0; i < graph.get(num).size(); i++) {
			int y = graph.get(num).get(i);
			if(visited[y] == 0) {
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = in.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		V = Integer.parseInt(temp[2]);
		visited = new int[N + 1];
		
//		graph = new ArrayList<ArrayList<Integer>>();
//		for(int i = 0; i <= N; i ++) {
//			graph.add(new ArrayList<Integer>());
//		}
		
		graph = new Node[N + 1];
		
		
		for(int i = 0; i < M; i++) {
			temp = in.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			graph[a] = new Node(b, graph[a]);
			graph[b] = new Node(a, graph[b]);
			
		}
//		for(int i = 0; i <= N; i ++) {
//			Collections.sort(graph.get(i));
//		}
//		dfs(V);
		print();
		System.out.println();
		visited = new int[N + 1];
//		bfs();
	}
	
	static void print() {
		for(Node node: graph) {
			System.out.println(node);
		}
	}
}
