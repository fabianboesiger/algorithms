public class Node <T extends Comparable <T>> {
	
	private T value;
	protected int height;
	protected Node <T> parent;
	protected Node <T> left;
	protected Node <T> right;
	
	public Node(T value, Node <T> parent) {
		this.value = value;
		this.parent = parent;
		height = 0;
	}
	
	protected void insert(T value) {
		if(value.compareTo(this.value) == -1) {
			if(left == null) {
				left = new Node <T> (value, this);
				left.retrace();
			} else {
				left.insert(value);
			}
		} else {
			if(right == null) {
				right = new Node <T> (value, this);
				right.retrace();
			} else {
				right.insert(value);
			}
		}
	}
	
	protected Node <T> find(T value) {
		if(value.equals(this.value)) {
			return this;
		}
		if(value.compareTo(this.value) == -1) {
			if(left != null) {
				return left.find(value);
			}
		} else {
			if(right != null) {
				return right.find(value);
			}
		}
		return null;
	}
	
	protected T remove() {
		if(parent != null) {
			parent.setChild(this, null);
			parent.retrace();
			return value;
		} else {
			return null;
		}
	}
	
	protected void update() {
		System.out.println("Update " + toString());
		if(left != null && right != null) {
			height = Math.max(left.height, right.height) + 1;
		} else
		if(left != null) {
			height = left.height + 1;
		} else 
		if(right != null) {
			height = right.height + 1;
		} else {
			height = 0;
		}
	}
	
	protected void retrace() {
		System.out.println("Retrace " + toString());
		update();
		rebalance();
		if(parent != null) {
			parent.retrace();
		}
	}
	
	protected void setChild(Node <T> current, Node <T> next){
		if(current == left) {
			left = next;
		} else
		if(current == right) {
			right = next;
		}
	}
	
	private void rebalance() {
		int balance = balance();
		if(balance < -1) {
			if(left.balance() <= 0) {
				System.out.println("Simple Right Rotation " + toString());
				/*
				Node <T> thisChild = this;
				Node <T> leftChild = left;
				Node <T> rightTree = right;
				Node <T> innerTree = left.right;
				Node <T> leftTree = left.left;
				
				if(parent != null) {
					parent.setChild(this, leftChild);
				}
				
				if(leftChild != null) {
					leftChild.right = thisChild;
					leftChild.left = leftTree;
				}
				thisChild.right = rightTree;
				thisChild.left = innerTree;
				
				if(rightTree != null) {
					rightTree.parent = thisChild;
				}
				if(innerTree != null) {
					innerTree.parent = thisChild;
				}
				if(leftTree != null) {
					leftTree.parent = leftChild;
				}
				
				if(leftChild != null) {
					leftChild.parent = parent;
				}
				thisChild.parent = leftChild;*/
			} else {
				System.out.println("Double Right Rotation " + toString());
				/*
				Node <T> thisChild = this;
				Node <T> leftChild = left;
				Node <T> innerChild = left.right;
				Node <T> rightTree = right;
				Node <T> innerRightTree = left.right.right;
				Node <T> innerLeftTree = left.right.left;
				Node <T> leftTree = left.left;
				
				if(parent != null) {
					parent.setChild(this, innerChild);
				}
				
				if(innerChild != null) {
					innerChild.right = thisChild;
					innerChild.left = leftChild;
				}
				thisChild.right = rightTree;
				thisChild.left = innerRightTree;
				if(leftChild != null) {
					leftChild.right = innerLeftTree;
					leftChild.left = leftTree;
				}
				
				if(rightTree != null) {
					rightTree.parent = thisChild;
				}
				if(innerRightTree != null) {
					innerRightTree.parent = thisChild;
				}
				if(innerLeftTree != null) {
					innerLeftTree.parent = leftChild;
				}
				if(leftTree != null) {
					leftTree.parent = leftChild;
				}
				
				if(innerChild != null) {
					innerChild.parent = parent;
				}
				thisChild.parent = innerChild;
				if(leftChild != null) {
					leftChild.parent = innerChild;
				}*/
			}
		} else 
		if(balance > 1) {
			if(right.balance() >= 0) {
				System.out.println("Simple Left Rotation " + toString());
				/*
				Node <T> thisChild = this;
				Node <T> rightChild = right;
				Node <T> leftTree = left;
				Node <T> innerTree = right.left;
				Node <T> rightTree = right.right;
				
				if(parent != null) {
					parent.setChild(this, rightChild);
				}
				
				if(rightChild != null) {
					rightChild.left = thisChild;
					rightChild.right = rightTree;
				}
				thisChild.left = leftTree;
				thisChild.right = innerTree;
				
				if(leftTree != null) {
					leftTree.parent = thisChild;
				}
				if(innerTree != null) {
					innerTree.parent = thisChild;
				}
				if(rightTree != null) {
					rightTree.parent = rightChild;
				}
				
				if(rightChild != null) {
					rightChild.parent = parent;
				}
				thisChild.parent = rightChild;*/
			} else {
				System.out.println("Double Left Rotation " + toString());
				/*
				Node <T> thisChild = this;
				Node <T> rightChild = right;
				Node <T> innerChild = right.left;
				Node <T> leftTree = left;
				Node <T> innerLeftTree = right.left.left;
				Node <T> innerRightTree = right.left.right;
				Node <T> rightTree = right.right;
				
				if(parent != null) {
					parent.setChild(this, innerChild);
				}
				
				if(innerChild != null) {
					innerChild.left = thisChild;
					innerChild.right = rightChild;
				}
				thisChild.left = leftTree;
				thisChild.right = innerLeftTree;
				if(rightChild != null) {
					rightChild.left = innerRightTree;
					rightChild.right = rightTree;
				}
				
				if(leftTree != null) {
				leftTree.parent = thisChild;
				}
				if(innerLeftTree != null) {
					innerLeftTree.parent = thisChild;
				}
				if(innerRightTree != null) {
					innerRightTree.parent = rightChild;
				}
				if(rightTree != null) {
					rightTree.parent = rightChild;
				}
				
				if(innerChild != null) {
					innerChild.parent = parent;
				}
				thisChild.parent = innerChild;
				if(rightChild != null) {
					rightChild.parent = innerChild;
				}*/
			}
		}
	}
	
	private int balance() {
		int leftHeight = (left == null) ? 0 : left.height;
		int rightHeight = (right == null) ? 0 : right.height;
		return rightHeight - leftHeight;
	}
	
	public String toString() {
		return value.toString();
	}
	
}
