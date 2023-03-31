package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_D3_암호문1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		List<String> secret = new ArrayList<>();
		
		String[] str = in.readLine().split(" ");
		for(int i = 0; i < str.length; i++) {
			secret.add(str[i]);
		}
		int M = Integer.parseInt(in.readLine());
		
		str = in.readLine().split("I ");
		for(int j = 0; j < str.length; j++) {
			String[] temp_str = str[j].split(" ");
		
			if(temp_str.length == 1) {
				continue;
			}
			int where =Integer.parseInt(temp_str[1]);
			for(int k = 3; k < temp_str.length; k++) {
				secret.add(where++, temp_str[k]);
			}
		}
		System.out.print("#"  +  " ");
		for(int i = 0; i < 10; i++) {
			System.out.print(secret.get(i) + " ");
		}
	}
}
