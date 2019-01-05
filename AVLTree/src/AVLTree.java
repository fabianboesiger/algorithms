import java.util.ArrayList;

public class AVLTree <T extends Comparable <T>> {
	
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
	
	public void insert(T value) {
		if(root == null) {
			root = new Node <T> (value, null);
		} else {
			root.insert(value);
		}
		size++;
		print();
	}
	
	public T remove(T value) {
		size--;
		Node <T> node = find(value);
		if(node != null) {
			T removed =  node.remove();
			print();
			return removed;
		}
		print();
		return null;
	}
	
	protected Node <T> find(T value) {
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
