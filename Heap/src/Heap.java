import java.util.Arrays;

public abstract class Heap <T extends Comparable <T>> implements Coverable <T> {
	
	private static final int ROOT = 0;

	private Object[] values;
	private int size;
	
	public Heap(int size) {
		values = new Object[size + ROOT];
		this.size = 0;
	}
	
	public Heap(T[] values) {
		this(values.length);
		for(int i = 0; i < values.length; i++) {
			this.values[ROOT + i] = values[i];
		}
		size = values.length;
		heapify();
	}
	
	public void push(T value) {
		int index = ROOT + size;
		set(index, value);
		size++;
		restore(ROOT);
		heapify();
	}
	
	public T pop() {
		T output = (T) get(ROOT);
		set(ROOT, get(ROOT + size - 1));
		size--;
		restore(ROOT);
		return output;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		System.out.println(Arrays.toString(values));
	}
	
	public void sort() {
		for(int i = ROOT + size - 1; i > ROOT; i--) {
			swap(ROOT, i);
			restore(ROOT, i);
		}
	}
	
	private void heapify() {
		for(int i = size/2; i >= ROOT; i--) {
			restore(i);
		}
	}
	
	private void restore(int index) {
		restore(index, ROOT + size);
	}
	
	private void restore(int index, int range) {
		int left = left(index);
		if(left < range) {
			if(covers(get(left), get(index))){
				swap(index, left);
				restore(left, range);
			}
		}
		int right = right(index);
		if(right < range) {
			if(covers(get(right), get(index))) {
				swap(index, right);
				restore(right, range);
			}
		}
	}
	
	private void swap(int index1, int index2) {
		Object value1 = values[index1];
		values[index1] = values[index2];
		values[index2] = value1;
	}
		
	private int left(int index) {
		return index * 2 + 1;
	}
	
	private int right(int index) {
		return index * 2 + 2;
	}
	
	@SuppressWarnings("unchecked")
	private T get(int index) {
		return (T) values[index];
	}
	
	private void set(int index, T value) {
		values[index] = value;
	}
	
}
