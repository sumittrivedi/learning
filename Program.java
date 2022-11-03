package com.epam.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Program {
	
	
//	Print 3rd largest element from an unsorted and duplicated Integer array (min size of array is 3)
//	I/P == 3,2,9,10,22,22,9,103,4,2,1,2,3,0,5  O/P == 10

//			Integer a[] = new Integer[]{3,2,9,10,22,22,9,103,4,2,1,2,3,0,5};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = new Integer[]{3,2,9,10,22,22,9,103,4,2,1,2,3,0,5};
		Arrays.sort(a);
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = a.length - 1; i >= 0 ; i--) {
			set.add(a[i]);
//			if (!set.contains(a[i]))
//				count++;
			if(set.size() == 3) {
				System.out.println("Third largest : " + a[i]);
				return;
			}
		}
		System.out.println("No 3rd largest element found");
	}

}
