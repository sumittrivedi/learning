package com.epam.learning;

import java.util.PriorityQueue;
import java.util.Queue;

public class C implements A, B {

	public static void main(String[] args) {
		A obj = new C();
		
		System.out.println(new C().getIndex());
		System.out.println(new C().getName());
		System.out.println(A.staticIndex());
		System.out.println(B.staticIndex());
		System.out.println(C.staticIndex());
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(12);
		queue.add(78);
		queue.add(11);
		queue.add(4);
		queue.add(7);
		queue.add(9);
		queue.remove();
		System.out.println(queue);
	}

	@Override
	public int getName() {
		return 5;
	}
	
	@Override
	public int getIndex() {
		return 3;
	}
//	@Override
	static int staticIndex() {
		return 33;
	}
}
