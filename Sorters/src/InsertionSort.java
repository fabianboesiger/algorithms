public class InsertionSort <T extends Comparable <T>> extends Sorter <T> {

	public InsertionSort() {
		super("InsertionSort");
	}

	@Override
	public void sort(T[] array) {
		for(int i = 1; i < array.length; i++) {
			for(int j = 0; j < i; j++) {
				if(array[j].compareTo(array[i]) == 1) {
					swap(array, i, j);
				}
			}
		}
	}

}
