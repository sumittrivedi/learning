package com.epam.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(1);
		list.add(6);
		
		/*
		 * Given a list of string names e.g. Ronak Jain, Mike Ross, John Fowler, Xavier
		 * Prince Extract the first names into a list in alphabetically descending order
		 */
		
		List<String> list16 = List.of("Ronak Jain", "Mike Ross", "John Fowler", "Xavier Prince");
		List<String> sortedList = 
		list16.stream().map(x -> x.split(" ")[0]).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedList);
		
		List<Laptop> list2 = Arrays.asList(new Laptop(12000,"INTEL", "4"),new Laptop(14000,"AMD", "8"),
				new Laptop(18000,"INTEL", "8"),new Laptop(13000,"AMD", "16"),new Laptop(19000,"SAMSUNG", "4"),
				new Laptop(17000,"INTEL", "4"),new Laptop(11000,"AMD", "16"),new Laptop(22000,"INTEL", "8"),new Laptop(17000,"INTEL", "16") );
		
		list2.stream().collect(Collectors.groupingBy(x -> x.cpu)).entrySet().stream()
				.forEach(x -> x.getValue().stream().sorted((a, b) -> {
					if (a.price == b.price) return 0;
					return a.price > b.price ? -1 : 1;
				}).forEach(y -> System.out.println(y.getCpu() + " " + y.getPrice() + " " + y.getRam())));

		Map<String, List<Laptop>> map = 
				list2.stream().collect(Collectors.groupingBy(x -> x.cpu) );
				
		map.entrySet().stream()
				.forEach(y -> y.getValue().stream().sorted((a,b) -> {
					if(a.getPrice() == b.getPrice() ) return 0;
					return a.getPrice() > b.getPrice() ? 1 : -1; 
				}).forEach(z -> System.out.println(z.getCpu() + " " + z.getPrice() + " " + z.getRam())));
		
		
		map.entrySet().forEach(x -> x.getValue().stream().forEach(y-> System.out.println(y.cpu + " "+ y.price + " "+ y.ram)));;
		map.entrySet().forEach(x -> System.out.println(x.getKey().toString()));

		
	
	}

}
