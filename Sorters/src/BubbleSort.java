public class BubbleSort <T extends Comparable <T>> extends Sorter <T> {

	public BubbleSort() {
		super("BubbleSort");
	}

	@Override
	public void sort(T[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j].compareTo(array[j + 1]) == 1) {
					swap(array, j, j + 1);
				}
			}
		}
	}

}
