import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_G5_숫자고르기 {
	
	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static HashSet<Integer> set;
	static HashSet<Integer> set2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = N; i > 0; i--) {
			set = new HashSet<>();
			set2 = new HashSet<>();
			isSelected = new boolean[N + 1];
			combination(0, 1, i);
		}
		
	}
	
	public static void combination(int cnt, int start, int end) {
		if(cnt == end) {
			HashSet<Integer> save = (HashSet<Integer>)set.clone();
			save.retainAll(set2);
			if(save.size() == set2.size()) {
				System.out.println(save.size());
				for(int n : save) {
					System.out.println(n);
				}
				System.exit(0);
			}
			return;
		}
		else {
			for(int i = start; i <= N; i++) {
				if(isSelected[i] || set.contains(arr[i])) continue;
				set.add(arr[i]);
				set2.add(i);
				if(cnt + 1 != set.size()) {
					set2.remove(i);
					continue;
				}
				isSelected[i] = true;
				combination(cnt + 1, i + 1, end);
				set.remove(arr[i]);
				set2.remove(i);
				isSelected[i] = false;
			}
		}
	}
}
