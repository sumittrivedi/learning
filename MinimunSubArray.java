
public class MinimunSubArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int[] subarray = MinimunSubArray.subarraySort(array);
		for (int x : subarray)
			System.out.println(x);
	}
	
	public static int[] subarraySort(int[] array) {
		int[] smallestSubArray = {-1, -1};
		int n = array.length;
		for ( int i = 1; i < n; i++) {
			if (array[i] < array[i -1]) {
				smallestSubArray[0] = i - 1;
			System.out.println(smallestSubArray[0]);break;
			}
		}
		for ( int j = n - 2; j > smallestSubArray[0]; j--) {
			if (array[j] > array[j + 1]) {
				smallestSubArray[1] = j + 1;
				System.out.println(smallestSubArray[1]);break;
			}
		}
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for ( int i = smallestSubArray[0]; i <= smallestSubArray[1]; i++) {
			minValue = Math.min(array[i], minValue);
			maxValue = Math.max(array[i], maxValue);
		}
		System.out.println(minValue + " " + maxValue);
		for ( int i = 0; i < smallestSubArray[0]; i++) {
			if (array[i] > minValue) {
				smallestSubArray[0] = i;
				break;
			}
		}
		for ( int i = n - 1 ; i > smallestSubArray[1]; i--) {
			if (array[i] < maxValue) {
				smallestSubArray[1] = i;
				break;
			}
		}
    return smallestSubArray;
  }
	

}
