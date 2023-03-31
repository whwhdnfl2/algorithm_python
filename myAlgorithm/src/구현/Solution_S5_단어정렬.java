//백준 1181번

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution_S5_단어정렬 {

	static int N;
	static List<String> array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		array = new LinkedList<String>();
		for(int i = 0; i < N; i++) {
			array.add(in.readLine());
		}
		Collections.sort(array);
		Collections.sort(array, (o1, o2)->{
			return o1.length() - o2.length();
		});
		String before = "";
		for(int i = 0; i < N; i++) {
			if(before.equals(array.get(i))){
				continue;
			}
			before = array.get(i);
			System.out.println(array.get(i));
		}
	}
}
