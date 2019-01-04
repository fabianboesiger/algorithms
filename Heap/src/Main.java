public class Main {

	public static void main(String[] args) {	
		Double[] values = {-1000.0, 12.54, -5.41, 9.04, -51.7432, 24.46, 102.0, 0.4376};
		
		MinHeap <Double> minHeap = new MinHeap <Double> (values);
		minHeap.print();
		minHeap.sort();
		minHeap.print();
		
		MaxHeap <Double> maxHeap = new MaxHeap <Double> (values);
		maxHeap.print();
		maxHeap.sort();
		maxHeap.print();
	}

}
