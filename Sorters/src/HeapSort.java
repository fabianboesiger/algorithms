import java.util.Arrays;

public class HeapSort <T extends Comparable <T>> extends Sorter <T> {

	public HeapSort() {
		super("HeapSort");
	}

	@Override
	public void sort(T[] array) {
		heapify(array);
		for(int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			restore(array, 0, i);
		}
	}
	
	private void heapify(T[] array) {
		for(int i = array.length/2; i >= 0; i--) {
			restore(array, i, array.length);
		}
	}
	
	private void restore(T[] array, int index, int range) {
		int left = index * 2 + 1;
		if(left < range && array[index].compareTo(array[left]) == -1) {
			swap(array, index, left);
			restore(array, left, range);
		}
		int right = index * 2 + 2;
		if(right < range && array[index].compareTo(array[right]) == -1) {
			swap(array, index, right);
			restore(array, right, range);
		}
	}

}
