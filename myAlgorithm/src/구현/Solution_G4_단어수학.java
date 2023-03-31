//BOJ1339

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_G4_단어수학 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		List <char[]> box = new ArrayList<char[]>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] check = new int[50];
		for(int i = 0; i < N; i++) {
			char[] word = in.readLine().toCharArray();
			box.add(word);
			for(int j = 0; j < word.length; j++) {
				check[word[j] - 'A'] += Math.pow(10,(word.length - j));
			}
		}
		int ans = 0;
		int first = 9;
		while(true) {
			int max = 0;
			int idx = -1;
			for(int i = 0; i < 50; i++) {
				if(check[i] > max) {
					max = check[i];
					idx = i;
				}
			}
			if(max == 0) {
				break;
			}
			char check_char = (char) (idx + 'A');
			for(int i = 0; i < box.size(); i++) {
				char[] temp = box.get(i);
				for(int j = 0; j < temp.length; j++) {
					if(temp[j] == check_char) {
						ans += first * Math.pow(10, temp.length - j - 1);
					}
				}
			}
			first--;
			check[idx] = 0;
		}
		System.out.println(ans);
	}
}
