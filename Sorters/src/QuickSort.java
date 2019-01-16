import java.util.Arrays;

public class QuickSort <T extends Comparable <T>> extends Sorter <T> {

	public QuickSort() {
		super("QuickSort");
	}

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}
	
	public void sort(T[] array, int l, int r) {
		if(l < r - 1) {
			int p = r - 1;
			int i = l;
			int j = r - 2;
			
			while(i < j) {
				while(array[i].compareTo(array[p]) < 1 && i < j) {
					i++;
				}
				while(array[j].compareTo(array[p]) > 0 && i < j) {
					j--;
				}
				swap(array, i, j);
			}
			
			if(array[i].compareTo(array[p]) == 1) {
				swap(array, i, p);
				p = i;
			}
						
			sort(array, l, p);
			sort(array, p + 1, r);
		}
	}
	
}
