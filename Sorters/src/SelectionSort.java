public class SelectionSort <T extends Comparable <T>> extends Sorter <T> {

	public SelectionSort() {
		super("SelectionSort");
	}

	@Override
	public void sort(T[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int maxIndex = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j].compareTo(array[maxIndex]) == -1) {
					maxIndex = j;
				}
			}
			if(maxIndex != i) {
				swap(array, i, maxIndex);
			}
		}
	}

}
