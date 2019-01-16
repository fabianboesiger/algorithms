import java.util.Random;

public class RandomArray {
	
	Random random;
	Integer[] array;
	
	public RandomArray(int size) {		
		random = new Random();
		array = new Integer[size];
	}
	
	public Integer[] next() {
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}
		return array;
	}
	
}
