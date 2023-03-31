
public class Solution_G5_상어초등학교_21608 {

	public static void main(String[] args) {
		
		
		int[] array = new int[1000];
		
		array[0] = 1;
		array[1] = 1;
		array[2] = 2;
		array[3] = 3;

		
		for(int i = 7; i < 1000; i++) {
			array[i] = Math.min(array[i - 1] + 1, Math.min(array[i - 4] + 1, array[i - 6] + 1));
		}
		System.out.println(array[8]);
		
		
	}
}
