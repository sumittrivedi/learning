import java.util.*;

public class RightSmallerThan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class GFG {

// An AVL tree node
	static class node {
		int key;
		node left;
		node right;
		int height;

		// size of the tree rooted
		// with this node
		int size;
	};

	static int[] countSmaller;
	static int count;

// A utility function to get
// height of the tree rooted with N
	static int height(node N) {
		if (N == null)
			return 0;

		return N.height;
	}

// A utility function to size
// of the tree of rooted with N
	static int size(node N) {
		if (N == null)
			return 0;

		return N.size;
	}

// A utility function to
// get maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

// Helper function that allocates a
// new node with the given key and
// null left and right pointers.
	static node newNode(int key) {
		node node = new node();
		node.key = key;
		node.left = null;
		node.right = null;

		// New node is initially added at leaf
		node.height = 1;
		node.size = 1;
		return (node);
	}

// A utility function to right rotate
// subtree rooted with y
	static node rightRotate(node y) {
		node x = y.left;
		node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Update sizes
		y.size = size(y.left) + size(y.right) + 1;
		x.size = size(x.left) + size(x.right) + 1;

		// Return new root
		return x;
	}

// A utility function to left rotate
// subtree rooted with x
	static node leftRotate(node x) {
		node y = x.right;
		node T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Update sizes
		x.size = size(x.left) + size(x.right) + 1;
		y.size = size(y.left) + size(y.right) + 1;

		// Return new root
		return y;
	}

// Get Balance factor of node N
	static int getBalance(node N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

// Inserts a new key to the tree rotted with
// node. Also, updates *count to contain count
// of smaller elements for the new key
	static node insert(node node, int key, int count) {
		// 1. Perform the normal BST rotation
		if (node == null)
			return (newNode(key));

		if (key < node.key)
			node.left = insert(node.left, key, count);
		else {
			node.right = insert(node.right, key, count);

			// UPDATE COUNT OF SMALLER ELEMENTS FOR KEY
			countSmaller[count] = countSmaller[count] + size(node.left) + 1;
		}

		// 2.Update height and size of this ancestor node
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		node.size = size(node.left) + size(node.right) + 1;

		// 3. Get the balance factor of this
		// ancestor node to check whether this
		// node became unbalanced
		int balance = getBalance(node);

		// If this node becomes unbalanced,
		// then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		// Return the (unchanged) node pointer
		return node;
	}

// The following function updates the
// countSmaller array to contain count of
// smaller elements on right side.
	static void constructLowerArray(int arr[], int n) {
		int i, j;
		node root = null;

		// Initialize all the counts in
		// countSmaller array as 0
		for (i = 0; i < n; i++)
			countSmaller[i] = 0;

		// Starting from rightmost element,
		// insert all elements one by one in
		// an AVL tree and get the count of
		// smaller elements
		for (i = n - 1; i >= 0; i--) {
			root = insert(root, arr[i], i);
		}
	}

// Utility function that prints out an
// array on a line
	static void printArray(int arr[], int size) {
		int i;
		System.out.print("\n");

		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

// Driver code
	public static void main(String[] args) {
		int arr[] = { 10, 6, 15, 20, 30, 5, 7 };
		int n = arr.length;

		countSmaller = new int[n];

		constructLowerArray(arr, n);

		System.out.print("Following is the constructed smaller count array");
		printArray(countSmaller, n);

	}
}

// This code is contributed by Rajput-Ji
