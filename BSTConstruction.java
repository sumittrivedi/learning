import java.util.*;

class BSTConstruction {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
			this.value = value;
    }

    public BST insert(int value) {
			BST parent = this;
			BST temp = parent.value > value ? parent.left : parent.right;
			while (temp != null) {
				if (temp.value <= value) {
					parent = temp;
					temp = temp.right;
				}
				else {
					parent = temp;
						temp = temp.left;
				}
			}
			if (parent.value > value)
				parent.left = new BST(value);
			else
				parent.right = new BST(value);
      return this;
    }

    public boolean contains(int value) {
      if (this != null) {
				BST temp = this;
				while (temp != null) {
					if (temp.value == value)
						return true;
					else {
						if (temp.value < value) 
							temp = temp.right;
						else
							temp = temp.left;
					}
				}
			}
      return false;
    }
		
// 		public BST remove(int value) {
// 				if (this == null) 
// 					return this;
// 				if (value < this.value)
// 					this.left = this.left.remove(value);
// 				else {
// 					if (value > this.value)
// 						this.right = this.right.remove(value);
// 					else {
// 						if (this.left == null)
// 							return this.right;
// 						if (this.right == null)
// 							return this.left;
// 						this.value = minValue(this.right);
// 						this.right = this.right.remove(this.value);
// 					}
// 				}
// 			return this;
// 		}
	 
// 	    int minValue(BST root)
// 	    {
// 	        int minv = root.value;
// 	        while (root.left != null)
// 	        {
// 	            minv = root.left.value;
// 	            root = root.left;
// 	        }
// 	        return minv;
// 	    }
    
//		private BST removeFirstNode(int value, BST parent) {
//  if (value < this.value) {
//			this.left = this.left.removeFirstNode(value, this);
//		}
//		else {
//			if (value == this.value) {
//				if (this.left == null || this.right == null) {
//					if (this.left == null && this.right == null) {
//						parent.left = null;
//						parent.right = null;
//					}
//					else {
//						BST newNode = this.left == null ? this.right : this.left;
//						if (parent != null && parent.left.value == value)
//							parent.left = newNode;
//						else
//							parent.right = newNode;
//					}
//				}
//				else {
//					int minValue = this.right.getMinValue();
//					this.right = this.right.remove(minValue);
//					BST newNode = new BST(minValue);
//					newNode.left = this.left;
//					newNode.right = this.right;
//					if (parent != null && parent.left.value == value)
//							parent.left = newNode;
//					else
//							parent.right = newNode;
//				}
//			}
//			else {
//				this.right = this.right.removeFirstNode(value, this);
//			}
//		}
//  return this;
//}
	
//	private int getMinValue() {
//		if (this.left != null) 
//			return this.left.getMinValue();
//		return this.value;
//	}

    public BST remove(int value) {
      if (!(this.left == null && this.right == null)) {
				BST parent = this;
				BST temp = parent.value > value ? parent.left : parent.right;
				while (temp != null && temp.value != value) {
					if (temp.value <= value) {
						parent = temp;
						temp = temp.right;
					}
					else {
						parent = temp;
							temp = temp.left;
					}
				}
				if (temp == null)
					return this;
				if (temp.left == null || temp.right == null) {
					if (temp.right != null) {
						if (parent.value > value)
							parent.left = temp.left;
						else
							parent.right = temp.left;
					}
						
					if (temp.left != null) {
						if (parent.value > value)
							parent.left = temp.right;
						else
							parent.right = temp.right;
					}
						
					if (temp.left == null && temp.right == null) {
						if (parent.value > value)
							parent.left = null;
						else
							parent.right = null;
					}
				}
				else {
						int smallestRightValue = getSmallestValue(temp.right);
						this.remove(smallestRightValue);
						BST newNode = new BST(smallestRightValue);
					newNode.left = temp.left;
					newNode.right = temp.right;
						if (parent.value > value)
							parent.left = newNode;
						else
							parent.right = newNode;
				}
			}
      return this;
    }
		
		private int getSmallestValue(BST node) {
			if (node.left == null && node.right == null)
				return node.value;
			if (node.left != null)
				return getSmallestValue(node.left);
			// if (node.right != null)
				return getSmallestValue(node.right);
			
		}
		
  }
}





private BST deleteNode(BST root, int value) {
    if(root == null) return root;
    if(value > root.val){ 
        root.right = deleteNode(root.right, value);
    }else if(value < root.val){ 
        root.left = deleteNode(root.left, value);
    }else{ 
        if(root.left == null && root.right == null){ 
            root = null;
        }else if(root.right != null){ 
            root.val = minValue(root.right); 
            root.right = deleteNode(root.right, root.val);
        }else{ 
            root.val = minValue(root.right);
            root.left = deleteNode(root.left, root.val);
        }
    }
    return root;
}
