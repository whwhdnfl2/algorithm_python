package 구현;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_S5_스네이크버드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[N];
		String str[] = sc.nextLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			if(arr[i] <= M) {
				M++;
			}else {
				break;
			}
		}
		System.out.println(M);
	}
}
