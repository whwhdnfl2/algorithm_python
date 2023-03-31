package dp;

public class Solution_아파트색칠하기 {

	public static void main(String[] args) {
		int array[][] = new int[10][2]; // 0: 노랑, 1: 파랑
		array[0][0] = 1;
		array[0][1] = 1;
		array[1][0] = 2;
		array[1][1] = 1;
		for(int i = 2; i < 10; i++) {
			array[i][0] = array[i - 1][0] + array[i - 1][1];
			array[i][1] = array[i - 1][0];
		}
		System.out.println(array[7][0] + array[7][1]);
	}
}
