package com.epam.learning;

public class Runner {

	public static void main(String[] args) {
		ThreadImplOdd threadImplOdd = new ThreadImplOdd();
		int odd[] = threadImplOdd.getOddNumber();
		
		ThreadImplEven threadImplEven = new ThreadImplEven();
		int even[] = threadImplEven.getEvenNumber();
		
		for (int i = 0; i < even.length; i++) {
			System.out.println(odd[i]);
			System.out.println(even[i]);
		}

	}

}
