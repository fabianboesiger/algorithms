import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void swap(int[] A, int x, int y) {
		System.out.println("Swap "+A[x]+" with "+A[y]);
		
		int z = A[x];
		A[x] = A[y];
		A[y] = z;
	}
	
	public static int min(int[] A, int l, int r) {
		int m = Integer.MAX_VALUE;
		int j = -1;
		for(int i = l; i < r; i++) {
			if(A[i] < m) {
				m = A[i];
				j = i;
			}
		}
		return j;
	}
	
	public static void selectionSort(int[] A) {		
		int n = A.length;
		for(int i = 0; i < n-1; i++) {
			int j = min(A, i, n);
			swap(A, i, j);
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
		selectionSort(input);
		System.out.println("Output is "+Arrays.toString(input));
		
	}

}
