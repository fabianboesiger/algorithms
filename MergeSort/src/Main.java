import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void merge(int[] A, int l, int m, int r) {
		int i = l;
		int j = m+1;
		int k = 0;
		int[] B = new int[(r-l)+1];
		
		while(i <= m && j <= r) {
			if(A[i] < A[j]) {
				System.out.println(A[i]+" is smaller than "+A[j]+", adding "+A[i]+" to new Array at Position "+k);
				B[k] = A[i];
				i++;
				k++;
			}else {
				System.out.println(A[i]+" is larger or equal than "+A[j]+", adding "+A[j]+" to new Array at Position "+k);
				B[k] = A[j];
				j++;
				k++;
			}
		}
		
		while(i <= m) {
			B[k] = A[i];
			i++;
			k++;
		}
		
		while(j <= r) {
			B[k] = A[j];
			j++;
			k++;
		}
		
		for(int n = l; n <= r; n++) {
			A[n] = B[n-l];
		}
	}
	
	public static void mergeSort(int[] A, int l, int r) {
		int m = (l+r)/2;
		
		System.out.println("Mergesort from "+l+" to "+r+", center is "+m);
		
		if(r-l >= 2) {
			mergeSort(A, l, m);
			mergeSort(A, m+1, r);
		}
		merge(A, l, m, r);

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
		mergeSort(input, 0, input.length-1);
		System.out.println("Output is "+Arrays.toString(input));
		
	}

}
