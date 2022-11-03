package com.epam.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WissenTech {
	
	
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,3,2,4,5,7));
		AtomicInteger xy = new AtomicInteger();
		int result = list.stream().filter(x -> x%2 != 0).map(y -> y*y).reduce(0, (a,b) -> {
			xy.incrementAndGet();
			return a+b;
		});
		
		System.out.println(xy.get() + "===>" + result );
	}
	

//	public static void main(String args[]) {
//		Map<Employee, Integer> map = new HashMap<>();
//		Employee employee1 = new Employee("Sumit", "Trivedi");
//		Employee employee2 = new Employee("Aman", "Kashyap");
//		Employee employee3 = new Employee("Joydip", "Kumar");
//		Employee employee4 = new Employee("Chandan", "Kumar");
//		
//		map.put(employee1, 1);
//		map.put(employee2, 2);
//		map.put(employee3, 3);
//		map.put(employee4, 4);
//		
//		List<Employee> emploList = new ArrayList<>();
//		emploList.add(employee1);
//		emploList.add(employee2);
//		emploList.add(employee3);
//		emploList.add(employee4);
//		
//		Collections.sort(emploList);
//		
//		emploList.stream().forEach(x -> System.out.println(x.lastName));
//	}
}

