import java.util.ArrayList;

public class AVLTree <T extends Comparable <T>> implements Retraceable <T> {
	
	private Node <T> root;
	private int size;
	
	public AVLTree() {
	}
	
	public int size() {
		return size;
	}
	
	public int height() {
		return (int) (Math.log(size)/Math.log(2)) + 1;
	}
	
	public int compare(T value, int type) {
		if(root != null) {
			return root.compare(value, type);
		}
		return 0;
	}
	
	public void insert(T value) {
		System.out.println("Inserting " + value.toString());
		if(root == null) {
			root = new Node <T> (value, this, this);
		} else {
			root.insert(value);
		}
		size++;
		print();
		System.out.println("End of Insertion");
		System.out.println();
	}
	
	public T remove(T value) {
		System.out.println("Removing " + value.toString());
		size--;
		Node <T> node = find(value);
		T removed = null;
		if(node != null) {
			removed = node.remove();
		}
		print();
		System.out.println("End of Removal");
		System.out.println();
		return removed;
	}
	
	public void setChild(Node <T> current, Node <T> next) {
		if(current == root) {
			root = next;
		}
	}
	
	public void retrace() {
		
	}
	
	public Node <T> find(T value) {
		return root.find(value);
	}
	
	public void print() {
		ArrayList <Node <T>> nodes = new ArrayList <Node <T>> ();
		nodes.add(root);
		
		ArrayList <Node <T>> next = new ArrayList <Node <T>> ();
		
		int height = height();
		int previousSpacing = 0;
		for(int i = 0; i <= height; i++) {
			int elements = (int) Math.pow(2, i);
			int spacing = ((int) Math.pow(2, height))/elements;
			
			if(i > 0) {
				for(int j = 0; j < spacing - 1; j++) {
					System.out.print("\t");
				}
				for(int j = 0; j < nodes.size(); j++) {
					if(j%2 == 0) {
						System.out.print(" /");
					} else {
						System.out.print("\\");
					}
					for(int k = 0; k < previousSpacing; k++) {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			
			for(int j = 0; j < spacing - 1; j++) {
				System.out.print("\t");
			}
			for(Node <T> node : nodes) {
				if(node != null) {
					System.out.print(node.toString());
				} else {
					System.out.print(".");
				}
				for(int j = 0; j < previousSpacing; j++) {
					System.out.print("\t");
				}
			}
			System.out.println();
			
			if(i < height) {
				for(int j = 0; j < spacing - 1 - spacing/2; j++) {
					System.out.print("\t");
				}
				for(int j = 0; j < nodes.size(); j++) {
					System.out.print("  ______");
					for(int k = 0; k < spacing / 2 - 1; k++) {
						System.out.print("________");
					}
					System.out.print("/\\");
					for(int k = 0; k < spacing / 2 - 1; k++) {
						System.out.print("________");
					}
					System.out.print("______  ");
					for(int k = 0; k < previousSpacing - spacing; k++) {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			
			previousSpacing = spacing;
						
			for(Node <T> node : nodes) {
				if(node != null) {
					next.add(node.left);
					next.add(node.right);
				} else {
					next.add(null);
					next.add(null);
				}
			}

			nodes.clear();
			nodes.addAll(next);
			next.clear();
		}
		
	}
	
}
