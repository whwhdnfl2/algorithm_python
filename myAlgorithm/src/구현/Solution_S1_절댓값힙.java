package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_S1_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else {
					return Math.abs(o1) - Math.abs(o2);
				}
			}

		});
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine());
			if(input == 0) {
				if(queue.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(queue.poll());
				}
			}
			else {
				queue.offer(input);
			}
		}
	}
}
