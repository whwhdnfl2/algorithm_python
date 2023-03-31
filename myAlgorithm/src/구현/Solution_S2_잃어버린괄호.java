//BOJ 1541번

package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_S2_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] temp1 = str.split("\\+");

		List<String> number = new ArrayList<>();
		List<Character> com = new ArrayList<>();
		for(int i = 0; i < temp1.length; i++) {
			String[] temp2 = temp1[i].split("\\-");
			for(int j = 0; j < temp2.length; j++) {
				number.add(temp2[j]);
			}
		}
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x == '+' || x == '-') {
				com.add(str.charAt(i));
			}
		}
		int ans = Integer.parseInt(number.get(0));
		boolean flag = true; //최초로 -를 만나면 false로 변함.
		for(int i = 1; i < number.size() ; i++) {
			int num = Integer.parseInt(number.get(i));
			char cal = com.get(i - 1);
			if(flag && cal == '+') {
				ans += num;
				continue;
			}else if(flag && cal == '-') {
				ans -= num;
				flag = false;
			}else if(!flag) {
				ans -= num;
			}
		}
		System.out.println(ans);
	}
}
