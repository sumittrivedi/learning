import java.util.*;

class Program {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	private TreeInfo targetNodeInfo = null;
	int pivotNodeValue = 0;
	boolean isTargetNodeOnLeft = false;

	public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
		setTargetNode(tree, null, target);
		pivotNodeValue = target;
		isTargetNodeOnLeft = isTargetOnLeft(tree.left);
		return getNodesWithDistanceK(targetNodeInfo, k);
	}
	
	private boolean isTargetOnLeft(BinaryTree tree) {
		if (tree != null) {
			if (tree.value == pivotNodeValue)
				return true;
			return isTargetOnLeft(tree.left) || isTargetOnLeft(tree.right);
		}
			
		return false;
	}
	
	private void setTargetNode(BinaryTree tree, TreeInfo parent, int target) {
		if (tree == null)
			return;
		if (tree.value == target) {
			targetNodeInfo = new TreeInfo(tree, null);
			targetNodeInfo.parent = parent;
			return;
		}
		TreeInfo newTreeInfo = new TreeInfo(tree, null);
		newTreeInfo.parent = parent;
		setTargetNode(tree.left, newTreeInfo, target);
		setTargetNode(tree.right, newTreeInfo, target);
	}

	private ArrayList<Integer> getNodesWithDistanceK(TreeInfo pivotNode, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		addChildNodesWithDistanceK(list, pivotNode.node, k);
		if (pivotNode.parent != null)
			addParentNodesWithDistanceK(list, pivotNode, k);
		return list;
	}

	private void addChildNodesWithDistanceK(ArrayList<Integer> list, BinaryTree node, int k) {
		if (node == null)
			return;
		else {
			if (k == 0)
				list.add(node.value);
			else {
				addChildNodesWithDistanceK(list, node.left, k - 1);
				addChildNodesWithDistanceK(list, node.right, k - 1);
			}
		}
	}

	private void addParentNodesWithDistanceK(ArrayList<Integer> list, TreeInfo treeInfo, int k) {
		if (k == 0) {
			list.add(treeInfo.node.value);
			return;
		}
		if (treeInfo.parent == null) {
			if (isTargetNodeOnLeft)
				addChildNodesWithDistanceK(list, treeInfo.node.right, k - 1);
			else {
				addChildNodesWithDistanceK(list, treeInfo.node.left, k - 1);
			}
		} else {
			addParentNodesWithDistanceK(list, treeInfo.parent, k - 1);
			if (treeInfo.node == treeInfo.parent.node.left)
				addChildNodesWithDistanceK(list, treeInfo.node.right, k - 1);
			else {
				addChildNodesWithDistanceK(list, treeInfo.node.left, k - 1);
			}
		}

	}

	static class TreeInfo {
		public BinaryTree node = null;
		public TreeInfo parent = null;

		public TreeInfo(BinaryTree node, TreeInfo parent) {
			this.node = node;
			this.parent = parent;
		}
	}
}
