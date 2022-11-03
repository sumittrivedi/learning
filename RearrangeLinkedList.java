import java.util.*;

public class RearrangeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList head = new LinkedList(6);
		LinkedList temp = head;
		temp.next = new LinkedList(5);
		temp = temp.next;
		temp.next = new LinkedList(3);
		temp = temp.next;
		temp.next = new LinkedList(2);
		temp = temp.next;
		temp.next = new LinkedList(3);
		temp = temp.next;
		temp.next = new LinkedList(1);
		temp = temp.next;
		temp.next = new LinkedList(4);
		temp = temp.next;
		temp.next = new LinkedList(8);
		temp = temp.next;
		temp.next = new LinkedList(9);
//		RearrangeLinkedList.print(head);
		RearrangeLinkedList.print(RearrangeLinkedList.rearrangeLinkedList(head, 3));

	}

	public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		LinkedList pivotNode = head;
		while (pivotNode != null) {
			if (pivotNode.value == k)
				break;
			pivotNode = pivotNode.next;
		}

		boolean isPivotFound = true;
		int originalValueOfPivot = 0;
		LinkedList temp = head;

		if (pivotNode == null) {
			isPivotFound = false;

			while (temp != null) {
				if (temp.value > k) {
					pivotNode = temp;
					originalValueOfPivot = temp.value;
					pivotNode.value = k;
					break;
				}
				temp = temp.next;
			}
			if (temp == null)
				return head;
		}

		temp = head;
		LinkedList previousNode = null;
		LinkedList nextPosition = pivotNode;

		while (temp != pivotNode) {
			LinkedList nextNode = temp.next;
			if (temp.value > pivotNode.value) {
				if (previousNode == null)
					head = nextNode;
				nextPosition = moveNode(previousNode, temp, nextPosition, head);
			} else
				previousNode = temp;
			temp = nextNode;
		}

		LinkedList newNextNode = previousNode;
		previousNode = nextPosition;
		temp = nextPosition.next;
		nextPosition = newNextNode;

		while (temp != null) {
			LinkedList nextTemp = temp.next;
			if (temp.value > pivotNode.value)
				previousNode = temp;
			else {
				LinkedList newNextPosition = moveNode(previousNode, temp, nextPosition, head);
				if (nextPosition == null)
					head = newNextPosition;
				if (temp.value < pivotNode.value)
					nextPosition = newNextPosition;
			}
			temp = nextTemp;
		}

		if (!isPivotFound)
			pivotNode.value = originalValueOfPivot;

		return head;
	}

	private static LinkedList moveNode(LinkedList previousNode, LinkedList nodeToBeMoved, LinkedList nextPosition,
			LinkedList head) {
		if (previousNode != null)
			previousNode.next = nodeToBeMoved.next;
		if (nextPosition != null) {
			LinkedList temp = nextPosition.next;
			nextPosition.next = nodeToBeMoved;
			nodeToBeMoved.next = temp;
		} else {
			nodeToBeMoved.next = head;
		}
		return nodeToBeMoved;
	}

	private static void print(LinkedList temp) {
		LinkedList node = temp;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}

}
