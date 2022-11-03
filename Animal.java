package com.epam.learning;
class Animal {
	String name;
	RuntimeException

	public Animal() {
		this.name = "Default	Name";
	}

	// This is called a one argument constructor.
	public Animal(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.name);
	}
}