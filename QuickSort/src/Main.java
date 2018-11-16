import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void swap(int[] A, int x, int y) {
		System.out.println("Swap "+A[x]+" with "+A[y]);
		
		int z = A[x];
		A[x] = A[y];
		A[y] = z;
	}
	
	public static int split(int[] A, int l, int r) {
		int i = l;
		int j = r-1;
		int p = A[r];
		
		System.out.println("Pivot is "+p);
		
		do {
			while(i < r && A[i] < p) {
				i++;
			}
			while(j > l && A[j] > p) {
				j--;
			}
			if(i < j) {
				swap(A, i, j);
			}
			
		}while(i < j);
		swap(A, i, r);
		return i;
	}
	
	public static void quickSort(int[] A, int l, int r) {		
		if(l < r) {
			System.out.println("Do Quicksort on Array "+Arrays.toString(Arrays.copyOfRange(A, l, r+1)));
			
			int k = split(A, l, r);
			quickSort(A, l, k-1);
			quickSort(A, k+1, r);
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
		quickSort(input, 0, input.length-1);
		System.out.println("Output is "+Arrays.toString(input));
		
	}

}
