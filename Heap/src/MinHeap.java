public class MinHeap <T extends Comparable <T>> extends Heap <T> {

	public MinHeap(int size) {
		super(size);
	}
	
	public MinHeap(T[] values) {
		super(values);
	}

	@Override
	public boolean covers(T value1, T value2) {
		return value1.compareTo(value2) == -1;
	}

}
