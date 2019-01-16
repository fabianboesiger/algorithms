public abstract class Sorter <T extends Comparable <T>> implements Sortable <T> {
	
	protected String name;
	
	public Sorter(String name) {
		this.name = name;
	}
	
	protected void swap(T[] array, int i, int j) {
		T x = array[i];
		array[i] = array[j];
		array[j] = x;
	}
	
	public long run(T[] array) {
		long start = System.currentTimeMillis();
		sort(array);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public boolean sorted(T[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i].compareTo(array[i + 1]) != -1) {
				return false;
			}
		}
		return true;
	}
	
}
