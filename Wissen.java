package com.epam.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Wissen {
	
	public static void main(String[] args) {
	    String first = "abcbcd";
	    String second = "cdefef";
	    String common = commonCharacters(first, second);
	    System.out.println("common characters in '" + first + "' and '" + second + "' are '" + common + "'");
	    
	}
	
	public static String commonCharacters(String first, String second) {
		Map<Character, Integer> firstMap =  new HashMap<>();
		Map<Character, Integer> secondMap =  new HashMap<>();
		for (char x : first.toCharArray()) {
			int firstFrequency = 1;
			if (firstMap.containsKey(x)) {
				firstFrequency += firstMap.get(x);
			}
			firstMap.put(x, firstFrequency);
			
		}
		for (char x : second.toCharArray()) {
			int secondFrequency = 1;
			if (secondMap.containsKey(x)) {
				secondFrequency += secondMap.get(x);
			}
			secondMap.put(x, secondFrequency);
		}
		
		String common = "";
		for (Character x : firstMap.keySet()) {
			int commonFreq = firstMap.get(x);
			if (secondMap.containsKey(x)) {
				commonFreq = commonFreq > secondMap.get(x) ? secondMap.get(x) : commonFreq;
				String temp = Character.toString(x);
				for (int i = 1; i < commonFreq; i++) {
					temp += x;
				}
				common += temp;
			}
		}
	    return common;
	}
	
	
	
//	public static void main(String[] args) {
//		int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		int splitSize = -7;
//		
//		/* expected Output 
//		[0, 1, 2]
//		[3, 4, 5]
//		[6, 7, 8]
//		[9]
//		*/
//	
//		List<int[]> list = splitArray(original, splitSize);
//		list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
//	}
//	
//	public static List<int[]> splitArray(int[] array, int splitSize) {
//		List<int[]> list = new ArrayList<>();
//		for (int i = 0; i < array.length; i += splitSize) {
//			int k = i;
//			int splitArraySize = splitSize < (array.length - k) ? splitSize : array.length - k;
//			int[] splitArray = new int[splitArraySize];
//			for (int j = 0; j < splitArraySize; j++) {
//				splitArray[j] = array[k++];
//			}
//			list.add(splitArray);
//		}
//		return list;
//	}

}
