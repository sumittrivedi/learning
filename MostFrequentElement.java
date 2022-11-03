package com.epam.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentElement {
	
	//input [1,2,3,4,5,6,7,1,3,4,5,6,2,4,5,2,1]
	//output the most frequent integer (element) in the input array

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,1,3,4,5,6,2,4,5,2,1};
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], 1 + map.get(array[i]));
			}
			else {
				map.put(array[i], map.get(array[i]));
			}
		}
		int frequency = 1;
		int element = array[0];
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > frequency) {
				frequency = entry.getValue();
				element = entry.getKey();
			}
		}
		
		System.out.println("Most Frequent Element : " + element);

	}
	
	
	
	

}
