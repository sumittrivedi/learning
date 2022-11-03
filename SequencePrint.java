package com.epam.learning;

public class SequencePrint implements Runnable{
	int i = 1;
	static int remainder;
	public SequencePrint(int remainder) {
		this.remainder = remainder;
	}
	Object lock = new Object();
	@Override
	public void run() {
		synchronized (lock) {
			
		}
	}

}
