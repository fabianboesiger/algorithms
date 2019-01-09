public class Node <T extends Comparable <T>> implements Retraceable <T> {
	
	private T value;
	protected int height;
	protected int size;
	protected Retraceable <T> parent;
	protected Node <T> left;
	protected Node <T> right;
	private AVLTree <T> avlTree;
	
	public Node(T value, Retraceable <T> parent, AVLTree <T> avlTree) {
		this.value = value;
		this.parent = parent;
		this.avlTree = avlTree;
		height = 0;
		size = 1;
	}
	
	protected void insert(T value) {
		if(value.compareTo(this.value) == -1) {
			if(left == null) {
				left = new Node <T> (value, this, avlTree);
				left.retrace();
			} else {
				left.insert(value);
			}
		} else {
			if(right == null) {
				right = new Node <T> (value, this, avlTree);
				right.retrace();
			} else {
				right.insert(value);
			}
		}
	}
	
	protected int compare(T value, int type) {
		if(value.compareTo(this.value) == type) {
			if(type == -1) {
				if(left != null) {
					left.compare(value, type);
				}
			} else {
				if(right != null) {
					return right.compare(value, type);
				}
			}
		} else {
			return size;
		}
		return 0;
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
			if(left == null && right == null) {
				parent.setChild(this, null);
				parent.retrace();
			} else
			if(left == null) {
				parent.setChild(this, right);
				parent.retrace();
			} else
			if(right == null) {
				parent.setChild(this, left);
				parent.retrace();
			} else {
				Node <T> inOrder = left.rightest();
				inOrder.remove();
				Node <T> inOrderChild = null;
				if(inOrder.left != null) {
					inOrderChild = inOrder.left;
					inOrder.left.remove();
				}
				inOrder.left = left;
				inOrder.right = right;
				if(inOrderChild != null) {
					inOrder.left.insert(inOrderChild.value);
				}
				parent.setChild(this, inOrder);
				inOrder.retrace();
			}
			return value;
		} else {
			return null;
		}
	}
	
	private void rotate(Node <T> child) {
		System.out.println("Rotating " + child.toString() + " around " + this.toString());
		
		child.parent = parent;
		parent.setChild(this, child);
		if(child == left) {
			left = child.right;
			if(child.right != null) {
				child.right.parent = this;
			}
			child.right = this;
		} else {
			right = child.left;
			if(child.left != null) {
				child.left.parent = this;
			}
			child.left = this;
		}
		parent = child;
		
		child.update();
		update();
		
		avlTree.print();
		System.out.println("End of Rotation");
	}
	
	protected Node <T> leftest() {
		if(right != null) {
			return left.leftest();
		} else {
			return this;
		}
	}
	
	protected Node <T> rightest() {
		if(right != null) {
			return right.rightest();
		} else {
			return this;
		}
	}
	
	protected void update() {
		if(left != null && right != null) {
			height = Math.max(left.height, right.height) + 1;
			size = left.size + right.size + 1;
		} else
		if(left != null) {
			height = left.height + 1;
			size = left.size + 1;
		} else 
		if(right != null) {
			height = right.height + 1;
			size = right.size + 1;
		} else {
			height = 0;
			size = 1;
		}
	}
	
	public void retrace() {
		update();
		rebalance();
		if(parent != null) {
			parent.retrace();
		}
	}
	
	public void setChild(Node <T> current, Node <T> next){
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
				System.out.println("Simple Right Rotation around " + toString());
				rotate(left);
			} else {
				System.out.println("Double Right Rotation around " + toString());
				left.rotate(left.right);
				rotate(left);
			}
		} else 
		if(balance > 1) {
			if(right.balance() >= 0) {
				System.out.println("Simple Left Rotation around " + toString());
				rotate(right);
			} else {
				System.out.println("Double Left Rotation around " + toString());
				right.rotate(right.left);
				rotate(right);
			}
		}
	}
	
	private int balance() {
		int leftHeight = (left == null) ? 0 : (left.height + 1);
		int rightHeight = (right == null) ? 0 : (right.height + 1);
		return rightHeight - leftHeight;
	}
	
	public String toString() {
		return value.toString() + " ("+ size + ")";
	}
	
}
