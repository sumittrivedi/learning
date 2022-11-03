package com.epam.learning;

public class ThreadImplOdd implements Runnable{

	@Override
	public void run() {
//		System.out.println("1 ,3, 5, 7, 9");
		
	}
	
	public int[] getOddNumber() {
		run();
		return new int[] {1 ,3, 5, 7};
	}
	

}
