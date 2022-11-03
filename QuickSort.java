
public class QuickSort {
	
	public static int[] quickSort(int[] array) {
		quickSortHelper(array, 0, array.length - 1);
		return array;
  }
	
//	private static void quickSortHelper(int[] array, int low, int high) {
//		if (low < high) {
//			int pivot = array[high];
//			int i = (low - 1);
//			for (int j = low; j < high; j++) {
//				if (array[j] <= pivot) {
//					i++;
//					swap(array, i, j);
//				}
//			}
//			swap(array, i + 1, high);
//			quickSortHelper(array, low, i);
//			quickSortHelper(array, i + 2, high);
//		}
//	}
	
	private static void quickSortHelper(int[] array, int low, int high) {
		if (low < high) {
			int i = low;
			int j = high - 1;
			int pivot = array[high];
			while (i <= j) {
				while (i <= j && array[i] <= pivot)
					i++;
				while (j >= i && array[j] > pivot)
					j--;
				//if (i < j) {
					swap(array, i, j);
					i++;
					j--;
				//}
			}
			swap(array, i, high);
			quickSortHelper(array, low, i - 1);
			quickSortHelper(array, i + 1, high);
		}
	}
//		int pivot = array[high];
//		int i = low;
//		int j = high - 1;
////		if(i < j) {
//		while (i + 1 != j) {
//			while (i < j && array[i] < pivot)
//				i++;
//			while (j > 0 && array[j] > pivot)
//				j--;
//			if (i + 1 != j) {
//				swap(array, i, j);
////				i++;
////				j--;
//			}
//			System.out.println(i + "  "+ j);
//		}
//		swap(array, i + 1, high);
//		quickSortHelper(array, low, i);
//		quickSortHelper(array, i + 2, high);
	

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String args[]) {
		int[] array = {8, 5, 2, 9, 5, 6, 3};
		QuickSort.quickSort(array);
		for (int i : array)
			System.out.println(i);
	}
}
