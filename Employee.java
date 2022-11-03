package com.epam.learning;

public final class Employee implements Comparable<Employee>{
	
	private String firstName;
	private String lastName;
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	@Override
	public int compareTo(Employee o) {
		if (this.lastName.compareTo(o.lastName) > 1)
			return 1;
		else if (this.lastName.compareTo(o.lastName) < 1)
			return -1;
		return 0;
	}

}
