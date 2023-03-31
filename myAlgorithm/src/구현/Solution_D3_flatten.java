//swea

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_D3_flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = 10;
		for(int test_case = 1; test_case <= a; test_case++)
		{
			int T = Integer.parseInt(in.readLine());
			String[] temp = in.readLine().split(" ");
			
			List<Integer> map = new ArrayList<>();
			for(int i = 0; i < 100; i++) {
				map.add(Integer.parseInt(temp[i]));
			}
			Collections.sort(map);
			int ans = 0;
			while(true) {
				T -= 1;
				map.set(0, map.get(0) + 1);
				map.set(99, map.get(99) - 1);
				Collections.sort(map);
				if(map.get(99) - map.get(0) == 1 || map.get(99) - map.get(0) == 0) {
					ans = map.get(99) - map.get(0);
					break;
				}
				if(T == 0) {
					ans = map.get(99) - map.get(0);
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
