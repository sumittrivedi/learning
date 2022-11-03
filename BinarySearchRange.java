
import java.util.*;
import java.util.stream.Stream;

class BinarySearchRange {
	public static int[] searchForRange(int[] array, int target) {
		int result[] = new int[2];
		result[0] = setInitialRange(array, target, 0, array.length - 1);
		result[1] = setFinalRange(array, target, 0, array.length - 1);
		return result;
	}

	private static int setInitialRange(int[] array, int target, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				if (mid > 0 && array[mid - 1] == array[mid])
					high = mid - 1;
				else
					return mid;
			} else {
				if (target < array[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	private static int setFinalRange(int[] array, int target, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				if (mid < array.length - 1 && array[mid + 1] == array[mid])
					low = mid + 1;
				else
					return mid;
			} else {
				if (target < array[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int array[] = { 5, 7, 7, 8, 8, 10 };
		int target = 9;
		int x[] = BinarySearchRange.searchForRange(array, target);
		for (int a : x)
			System.out.println(a);
	}

}
