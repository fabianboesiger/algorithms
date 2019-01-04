public class Node {
	
	private int height;
	private Node left;
	private Node right;
	
	public Node() {
		height = 1;
	}
	
	public int height() {
		return height;
	}
	
	private int balance() {
		int rightHeight = (right != null) ? right.height() : 0;
		int leftHeight = (left != null) ? left.height() : 0;
		return rightHeight - leftHeight;
	}
	
}
