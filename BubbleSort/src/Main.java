import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void swap(int[] A, int x, int y) {
		System.out.println("Swap "+A[x]+" with "+A[y]);
		
		int z = A[x];
		A[x] = A[y];
		A[y] = z;
	}
	
	public static void bubbleSort(int[] A) {
		int n = A.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(A[j] > A[j+1]) {
					swap(A, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		String[] inputString = scanner.nextLine().split(" ");
		int[] input = new int[inputString.length];
		for(int i = 0; i < inputString.length; i++) {
			input[i] = Integer.parseInt(inputString[i]);
		}
		scanner.close();
		
		System.out.println("Input is "+Arrays.toString(input));
		bubbleSort(input);
		System.out.println("Output is "+Arrays.toString(input));
		
	}

}
