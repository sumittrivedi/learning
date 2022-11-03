package com.epam.learning;

public class Centime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int array[] = {1,3,4,6,7,8,9};
		int k = 12;
		
//		for ( int  i = 0; i < array.length - 1; i++) {
//			int pairIndex = binarySearchHelper(array, i, k);
//			if (pairIndex > 0) {
//				System.out.println("Indecies : " + i +" " + pairIndex);
//			}
//		}
		
		Centime.printRecusion(k);

	}
	static int temp = 1;
	private static void printRecusion(int k) {
		if (temp > k) 
			return;
		System.out.println(temp);
		temp += 1;
		printRecusion(k);
	}
	
	
//	private static void printRecusion(int k, int begin) {
//		if (begin > k) 
//			return;
//		System.out.println(begin);
//		printRecusion(k,begin + 1);
//	}
	
	
	private static int binarySearchHelper(int[] array, int index, int target) {
		return binarySearch(array, index + 1, array.length, target - array[index]);
//		return -1;
	}
	
	private static int binarySearch(int[] array, int low, int high, int target) {
		int mid = low + (high - low)/2;
		if (array[mid] == target) {
			return mid;
		}
		else if (array[mid] > target) {
			high = mid - 1;
		}
		else {
			low = mid + 1;
		}
		return binarySearch(array, low, high, target);
	}

}
