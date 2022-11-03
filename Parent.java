package com.epam.learning;

//We have a Parent class with 2 methods walk and run. We have a child class which overrides both the methods. Both child class methods just call their respective Super implementation.
//Parent class run method calls walk().
//class Parent
//Parent p = new Child();
//p.run();
//Tell the order in which each method is called



public class Parent {
	
	private void walk() {
		System.out.println("Walk");
	}
	private void run() {
		this.walk();
	}

}

