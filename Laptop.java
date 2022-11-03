package com.epam.learning;

public class Laptop /* implements Comparable<Laptop> */{
	
	int price;
	String cpu;
	String ram;

	public Laptop(int price, String cpu, String ram) {
		super();
		this.price = price;
		this.cpu = cpu;
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
//	@Override
//	public int compareTo(Laptop o) {
//		if (this.price > o.price) {
//			return 1;
//		}
//		else {
//			return -1;
//		}
////		return 0;
//	}

}
