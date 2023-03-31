package 구현;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_암호생성기 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < 8; i++) {
			queue.offer(sc.nextInt());
		}
		
		
		int minus = 1;
		while(true) {
			int now = queue.poll();
			now -= minus++;
			if(minus == 6) {
				minus = 1;
			}
			if(now <= 0) {
				queue.offer(0);
				break;
			}
			queue.offer(now);
		}
		System.out.print("#"  + " ");
		for(int i = 0; i < 8; i++) {
			System.out.print(queue.poll() + " ");
			
		}
	}
}
