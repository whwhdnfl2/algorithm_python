package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_G4_야구공그림 {
	
	public static int next_player;
	public static int out_count;
	public static int score;
	public static int[] order = new int[9];
	public static boolean[] isSelected = new boolean[9];
	public static List<String []> ening = new ArrayList<>();
	public static int N;
	public static int first_ru;
	public static int second_ru;
	public static int third_ru;
	
	public static int count;
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			if(order[3] == 0) {
				int temp_score = 0;
				for(int i = 0; i < N; i++) {
					boolean flag = true;
					while(flag) {
						for(int j = next_player; j < 9; j++) {
							next_player = j + 1;
							if(next_player == 9) {
								next_player = 0;
							}
							int raw = Integer.parseInt(ening.get(i)[order[j]]);
							if(raw == 0) {
								out_count++;
								if(out_count == 3) {
									flag = false;
									first_ru = 0;
									second_ru = 0;
									third_ru = 0;
									out_count = 0;
									break;
								}
							}
							if(raw == 1) {
								if(third_ru == 1) {
									temp_score ++;
									third_ru = 0;
								}
								if(second_ru == 1) {
									third_ru = 1;
									second_ru = 0;
								}
								if(first_ru == 1) {
									second_ru = 1;
									first_ru = 0;
								}
								first_ru = 1;
							}
							if(raw == 2) {
								if(third_ru == 1) {
									temp_score ++;
									third_ru = 0;
								}
								if(second_ru == 1) {
									temp_score ++;
									second_ru = 0;
								}
								if(first_ru == 1) {
									third_ru = 1;
									first_ru = 0;
								}
								second_ru = 1;
							}
							
							if(raw == 3) {
								if(third_ru == 1) {
									temp_score ++;
									third_ru = 0;
								}
								if(second_ru == 1) {
									temp_score ++;
									second_ru = 0;
								}
								if(first_ru == 1) {
									temp_score ++;
									first_ru = 0;
								}
								third_ru = 1;					
							}
							if(raw == 4) {
								temp_score++;
								if(third_ru == 1) {
									temp_score ++;
									third_ru = 0;
								}
								if(second_ru == 1) {
									temp_score ++;
									second_ru = 0;
								}
								if(first_ru == 1) {
									temp_score ++;
									first_ru = 0;
								}
							}
						}
					}
				}
				if( temp_score > score) {
					score = temp_score;
				}
			}
			next_player = 0;
			return;
		}
		else {
			for(int i = 0; i < 9; i++) {
				if(isSelected[i]) {
					continue;
				}
				order[cnt] = i;
				isSelected[i] = true;
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(sc.readLine());
		for(int i = 0; i < N; i++) {
			ening.add(sc.readLine().split(" "));
		}
		

		permutation(0);
		System.out.println(score);
	}
}
