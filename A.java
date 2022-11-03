package com.epam.learning;
@FunctionalInterface
public interface A {

	default int getIndex() {
		return 1;
	}
	static int staticIndex() {
		return 11;
	}
	
	int getName();
}
