package com.epam.learning;
@FunctionalInterface
public interface B {
	default int getIndex() {
		return 2;
	}
	static int staticIndex() {
		return 22;
	}
	int getName();
}
