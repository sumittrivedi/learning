import java.util.*;

public class DoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			if (head != null && node != null)
				insertBefore(head, node);
			else {
				head = node;
				tail = node;
			}
		}

		public void setTail(Node node) {
			if (tail == null)
				setHead(node);
			else
				insertAfter(tail, node);
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail)
				return;
			remove(nodeToInsert);
			nodeToInsert.next = node;
			if (node.prev != null)
				node.prev.next = nodeToInsert;
			else
				head = nodeToInsert;
			nodeToInsert.prev = node.prev;
			node.prev = nodeToInsert;
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail)
				return;
			remove(nodeToInsert);
			nodeToInsert.next = node.next;
			node.next = nodeToInsert;
			if (nodeToInsert.next != null)
				nodeToInsert.next.prev = nodeToInsert;
			else
				tail = nodeToInsert;
			nodeToInsert.prev = node;
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			if (position == 1) {
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int counter = 1;
			while (counter != position) {
				counter++;
				node = node.next;
			}
			if (node == null) {
				setTail(nodeToInsert);
				return;
			}
			insertBefore(node, nodeToInsert);

		}

		public void removeNodesWithValue(int value) {
			Node temp = head;
			while (temp != null) {
				if (temp.value == value)
					remove(temp);
				temp = temp.next;
			}
		}

		public void remove(Node node) {
			Node temp = head;
			while (temp != null && temp != node) {
				temp = temp.next;
			}
			if (temp == null)
				return;
			Node prevOfdelectedNode = temp.prev;
			Node nextOfdelectedNode = temp.next;
			if (prevOfdelectedNode != null)
				prevOfdelectedNode.next = nextOfdelectedNode;
			else
				head = nextOfdelectedNode;

			if (nextOfdelectedNode != null)
				nextOfdelectedNode.prev = prevOfdelectedNode;
			else
				tail = prevOfdelectedNode;

		}

		public boolean containsNodeWithValue(int value) {
			// Write your code here.
			Node temp = head;
			while (temp != null) {
				if (temp.value == value)
					return true;
				temp = temp.next;
			}
			return false;
		}
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

}
