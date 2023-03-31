package 구현;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_S4_카드2 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			int temp = queue.poll();
			queue.offer(temp);
		}
		System.out.println(queue.poll());
	}
}
