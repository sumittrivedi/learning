package com.epam.learning;

public class ValueLabs {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread obj = new Thread(t1, "Thread 1");
		Thread2 t2 = new Thread2();
		Thread obj2 = new Thread(t2, "Thread 2");

		for (int i = 0; i < 4; i++) {
			obj.start();
			obj.interrupt();
			obj2.start();
			obj2.interrupt();
		}
	}

}
