package dp;

public class Solution_막대색칠하기 {

	public static void main(String[] args) {
		int array[][] = new int[10][2];
		
		array[1][0] = 2; //0: 끝이 1cm인거, 1: 끝이 2cm인거
		array[1][1] = 0;
		array[2][0] = 4;
		array[2][1] = 1;
		
		for(int i = 3; i < 9; i++) {
			array[i][0] = array[i - 1][0] * 2 + array[i - 1][1] * 2;
			array[i][1] = array[i - 2][0] + array[i - 2][1];
		}
		System.out.println(array[6][0] + array[6][1]);
	}
}
