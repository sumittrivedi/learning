
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {0,0,0,9,1,0,2,0,9,0, 1,3,0,0,5,0,0};
		//{1,0,2,0,3,0,0,5};
		MoveZeroes.moveZeroes(array);
		for (int i : array)
		System.out.println(i);
	}
	
	public static int[] moveZeroes(int[] array) {
		int n = array.length;				// 8
		int zeroIndex = Integer.MAX_VALUE;		// Inf, 1,2,3,4
		for (int i = 0; i < n; i++) {			// i = 0,1,2,3,4,5,6,7,8
			if (array[i] == 0) {
				if (zeroIndex == Integer.MAX_VALUE)
					zeroIndex = i;
				continue;
			}
			if ( zeroIndex < i) {
				swap(array, i, zeroIndex);
				zeroIndex += 1;
			}
		} 
		return array;
		
	}

	private static void swap(int[] array, int i, int zeroIndex) {
		int temp = array[i];
		array[i] = array[zeroIndex];
		array[zeroIndex] = temp;
	}

}
