package com.epam.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) throws Throwable {
		List<Laptop> laps = new ArrayList<>();
		Laptop y = new Laptop(1872300, ".xxxx.", null);
		laps.add(new Laptop(12300, null, null));
		laps.add(new Laptop(123200, null, null));
		laps.add(new Laptop(134300, null, null));
		laps.add(new Laptop(1872300, "INTEL", null));
		laps.add(new Laptop(1872300, "AMD", null));
		laps.add(y);
		laps.add(y);
		laps.add(new Laptop(1872300, "AMD", null));
		
//		Collections.sort(laps, (Laptop a, Laptop b) -> {
//			return a.getPrice() > b.getPrice() ? 1 : -1;
//		});
//		laps.forEach(x -> System.out.println(x.getPrice()));
//		laps.stream().filter( x -> x.getPrice() > 500).collect(Collectors.toList());
		
		Test1.getHighestMarkStudents(laps).forEach(x -> System.out.println(x.cpu + " " + x.price));;
	
		
		
	}
	
	
	public static List<Laptop> getHighestMarkStudents(List<Laptop> laptops) {
		List<Laptop> result = new ArrayList<>();
//		 laptops.stream().max((x,y) -> {
//			if (x.price == y.price)
//				return 0;
//			return x.price > y.price ? 1 : -1;
//			
//		}).ifPresent(x -> result.add(x));
		 
		return laptops.stream().distinct().collect(Collectors.toList());
		 
//		 return result;
	}


}
