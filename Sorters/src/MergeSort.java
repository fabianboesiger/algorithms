public class MergeSort <T extends Comparable <T>> extends Sorter <T> {

	public MergeSort() {
		super("MergeSort");
	}

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}
	
	public void sort(T[] array, int l, int r) {
		if(l < r - 1) {
			int m = (r + l) / 2;
			sort(array, l, m);
			sort(array, m, r);
			//merge(array, l, r)
		}
	}
	
	public void merge(T[] array) {
		//T[] 
	}
	
}
