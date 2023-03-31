import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


class move{
	int speed;
	int distance;
	int count;
	
	public move(int speed, int distance, int count) {
		super();
		this.speed = speed;
		this.distance = distance;
		this.count = count;
	}
}

public class Solution_G5_FlymetotheAlphaCentauri {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int distance = x - y;
			int moveDistance = 0;
			int moveCount = 0;
			int nowSpeed = 0;
			int ans = Integer.MAX_VALUE;
			if(distance == 1 || distance == 2 || distance == 3) {
				moveCount = distance;
			}
			else {
				
				Queue<move> queue = new ArrayDeque<>();
				queue.offer(new move(1, 3, 3));
				//queue.offer(new move(2, 3, 2));
				while(!queue.isEmpty()) {
					move tempMove = queue.poll();
					int tempDistance = tempMove.distance;
					int tempSpeed = tempMove.speed;
					int tempCount = tempMove.count;
					if(tempDistance == distance && tempSpeed == 1) {
						if(moveCount < ans) ans = moveCount;
					}else if((tempDistance == distance && tempSpeed != 0) || tempDistance > distance){
						continue;
					}else if(tempSpeed <= 0) {
						continue;
					}else {
						queue.offer(new move(tempSpeed + 1, tempDistance + tempSpeed, tempCount + 1));
						queue.offer(new move(tempSpeed, tempDistance + tempSpeed, tempCount + 1));
						queue.offer(new move(tempSpeed - 1, tempDistance + tempSpeed, tempCount + 1));
					}
					
				}
				
				
			}
			
			System.out.println(ans);
		}
	}
}
