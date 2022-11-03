package com.epam.learning;

//1-2-3
//4-5-6
//
//321
//654
//
//9-7-5

public class LinkedListSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList1 = new LinkedList(1);
		LinkedList linkedList12 = new LinkedList(2);
		LinkedList linkedList13 = new LinkedList(3);
		linkedList1.next = linkedList12;
		linkedList12.next = linkedList13;
		
		
		LinkedList linkedList2 = new LinkedList(4);
		LinkedList linkedList22 = new LinkedList(5);
		LinkedList linkedList23 = new LinkedList(6);
		linkedList2.next = linkedList22;
		linkedList22.next = linkedList23;
		
		
		LinkedList sum = LinkedListSum.getLinkedList(linkedList1, linkedList2);
		while (sum != null) {
			System.out.println(sum.value);
			sum = sum.next;
		}
	}
	
	private static LinkedList getLinkedList(LinkedList linkedList1, LinkedList linkedList2) {
		LinkedList newList = new LinkedList(0);
		LinkedList temp = newList;
		int remainder = 0;
		while (linkedList1 != null && linkedList2 != null ) {
			int newValue = linkedList1.value + linkedList2.value + remainder;
			remainder = newValue > 9 ? newValue/10 : 0;
			newValue = newValue > 9 ? newValue%10 : newValue;
			LinkedList newNode = new LinkedList(newValue);
			temp.next = newNode;
			temp = newNode;
			linkedList1 = linkedList1.next;
			linkedList2 = linkedList2.next;
		}
		while (linkedList1 != null) {
			int newValue = linkedList1.value + remainder;
			remainder = newValue > 9 ? newValue/10 : 0;
			newValue = newValue > 9 ? newValue%10 : newValue;
			LinkedList newNode = new LinkedList(newValue);
			temp.next = newNode;
			temp = newNode;
			linkedList1 = linkedList1.next;
		}
		
		while (linkedList2 != null) {
			int newValue = linkedList2.value + remainder;
			remainder = newValue > 9 ? newValue/10 : 0;
			newValue = newValue > 9 ? newValue%10 : newValue;
			LinkedList newNode = new LinkedList(newValue);
			temp.next = newNode;
			temp = newNode;
			linkedList2 = linkedList2.next;
			
		}
		if (remainder > 0) {
			temp.next = new LinkedList(remainder);
		}
		return reverseList(newList.next);
	}
	
	private static LinkedList reverseList(LinkedList head) {
		LinkedList originalList = head.next;
		LinkedList newList = head;
		newList.next = null;
		while (originalList != null) {
			LinkedList temp = originalList.next;
			originalList.next = newList;
			newList = originalList;
			originalList = temp;
		}
		return newList;
	}
	

}

class LinkedList {
	public int value;
	public LinkedList next;
	public LinkedList(int value) {
		this.value = value;
		this.next = null;
	}
}
