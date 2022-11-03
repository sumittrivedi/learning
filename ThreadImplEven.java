package com.epam.learning;

public class ThreadImplEven implements Runnable{

	@Override
	public void run() {
//		System.out.println("2, 4, 6, 8");
	}
	
	public int[] getEvenNumber() {
		run();
		return new int[] {2, 4, 6, 8};
	}
	

}
