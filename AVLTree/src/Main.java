
public class Main {

	public static void main(String[] args) {
		
		Integer[] values = {1, 6, 3, 2, 9, 0, -4, 7, -9, -8, -7};
		
		AVLTree <Integer> avlTree = new AVLTree <Integer> ();
		for(Integer value : values) {
			avlTree.insert(value);
		}
		
		avlTree.print();
		avlTree.remove(2);
		avlTree.print();
		avlTree.remove(-4);
		avlTree.print();
	}

}
