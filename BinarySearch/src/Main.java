import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int binarySearch(int[] A, int b) {
		int n = A.length;
		if(n == 0) {
			return -1;
		}
		int m = n/2;
		if(A[m] == b) {
			return m;
		}
		if(b < A[m]) {
			return binarySearch(Arrays.copyOfRange(A, 0, m), b);
		}else {
			return binarySearch(Arrays.copyOfRange(A, m+1, n), b)+m+1;
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] inputString = scanner.nextLine().split(" ");
		int key = scanner.nextInt();
		int[] input = new int[inputString.length];
		for(int i = 0; i < inputString.length; i++) {
			input[i] = Integer.parseInt(inputString[i]);
		}
		scanner.close();
		
		System.out.println("Input is "+Arrays.toString(input)+", searching for "+key);
		int result = binarySearch(input, key);
		if(result < 0) {
			System.out.println("Not Found");
		}else {
			System.out.println("Found at index "+result);
		}
	}

}
