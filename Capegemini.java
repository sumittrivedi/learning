package com.epam.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTML.Tag;

public class Capegemini {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Sumit");
		list.add("Kumar");
		list.add("Sumit");
		list.add("Trivedi");
		list.add("Hello");
		list.add("World");
		list.add("World");
		
		Capegemini.getString(list, "Kumar");
	}
	
	private static void getString(List<String> list, String target) {
		Map<String, Integer> map = new HashMap<>();
		for (String x : list) {
			int frequency = 1;
			if (map.containsKey(x)) {
				frequency += map.get(x);
			}
			map.put(x, frequency);
		}
		for (String x : map.keySet()) {
			if (map.get(x) > 1) {
				System.out.println("This is duplicate String : " + x);
			}
			if (x.equals(target)) {
				System.out.println("Target String is there : " + target);
			}
		}
	}

}
