public class MergeSort <T extends Comparable <T>> extends Sorter <T> {

	public MergeSort() {
		super("MergeSort");
	}

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}
	
	private void sort(T[] array, int l, int r) {
		if(l < r - 1) {
			int m = (r + l) / 2;
			sort(array, l, m);
			sort(array, m, r);
			merge(array, l, m, r);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void merge(T[] array, int l, int m, int r) {
		Object[] temporary = new Object[r - l];
		int i = l;
		int j = m;
		for(int k = 0; k < temporary.length; k++) {
			if(i >= m || (j < r && array[i].compareTo(array[j]) == 1)) {
				temporary[k] = array[j];
				j++;
			} else {
				temporary[k] = array[i];
				i++;
			}
		}
		for(int k = 0; k < temporary.length; k++) {
			array[l + k] = (T) temporary[k];
		}
	}
	
}
