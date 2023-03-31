package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_G5_신기한소수 {
	
	public static int N;
	
	
	public static void gogo(int num, int cnt) {
		if(cnt == N && isPrime(num)) {
			System.out.println(num);
		}
		for(int i = 0; i < 10; i++) {
			if(isPrime(num)) gogo(num*10+i, cnt+1);
		}
	}
	
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		for(int i = 1; i < 10; i++) {
			gogo(i, 1);
		}
		
	}
}
