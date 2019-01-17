import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	private static final int ROUNDS = 10;
	private static final int ARRAY_SIZE = 10000;

	public static void main(String[] args) {
		
		ArrayList <Sorter <Integer>> sorters = new ArrayList <Sorter <Integer>> ();
		sorters.add(new NoSort <Integer> ());
		sorters.add(new BubbleSort <Integer> ());
		sorters.add(new SelectionSort <Integer> ());
		sorters.add(new InsertionSort <Integer> ());
		sorters.add(new QuickSort <Integer> ());
		sorters.add(new MergeSort <Integer> ());
		sorters.add(new HeapSort <Integer> ());

		/*
		Integer[] array = {1, 7, 4, 9, -1, 6};
		sorters.get(sorters.size() - 1).sort(array);
		System.out.println(Arrays.toString(array));
		*/
		
		run(sorters);
		
	}
	
	private static void run(ArrayList <Sorter <Integer>> sorters) {
		RandomArray randomArray = new RandomArray(ARRAY_SIZE);
		
		long[] times = new long[sorters.size()];
		boolean[] sorted = new boolean[sorters.size()];
		for(int i = 0; i < sorters.size(); i++) {
			times[i] = 0;
			sorted[i] = true;
		}
		for(int i = 0; i < ROUNDS; i++) {
			Integer[] array = randomArray.next();
			for(int j = 0; j < sorters.size(); j++) {
				Integer[] clone = array.clone();
				times[j] += sorters.get(j).run(clone);
				if(!sorters.get(j).sorted(clone)) {
					sorted[j] = false;
				}
			}
			long added = 0;
			for(int j = 0; j < sorters.size(); j++) {
				added += times[j];
			}
			System.out.println(Math.round((ROUNDS - i) * added / (i + 1) / 1000.0) + "s remaining");
		}
		System.out.println();
		for(int i = 0; i < sorters.size(); i++) {
			System.out.println(sorters.get(i).name+": " + (double) times[i] / ROUNDS + "ms, " + (sorted[i] ? "sorted": "unsorted"));
		}
	}
	
}
