public class MaxHeap <T extends Comparable <T>> extends Heap <T> {

	public MaxHeap(int size) {
		super(size);
	}
	
	public MaxHeap(T[] values) {
		super(values);
	}

	@Override
	public boolean covers(T value1, T value2) {
		return value1.compareTo(value2) == 1;
	}

}
