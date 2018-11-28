//=======================================================================================================
// Exercise     : AD18H9P1.RealCoins
// Template URL : https://www.cadmo.ethz.ch/education/lectures/HS18/DA/uebungen/AD18H9P1.RealCoins.zip
// Author       :  
//=======================================================================================================

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
		
	public static void read_and_solve(InputStream in, PrintStream out) {

		Scanner scanner = new Scanner(in);
		//
		// Get N & K
		//
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int sum = 0;
		int[] coins = new int[N];
		BigInteger[] counters = new BigInteger[K];
		
		for(int i = 0; i < K; i++) {
			counters[i] = BigInteger.valueOf(2);
		}
		
		for(int i = 0; i < N; i++) {
			coins[i] = scanner.nextInt();
			sum += coins[i];
		}
		
		for(int i = 0; i < N; i++) {
			int n = scanner.nextInt();
			sum += n;
			for(int j = 0; j < K; j++) {
				
			}
			counters[i] = BigInteger.valueOf(n);
		}
		
		//
		// Provide your solution here ...
		//
		// out.println(result.toString());		
		
		out.println();
				
		scanner.close();
	}

	//
	// Do not modify the main method, and keep the method read_and_solve
	// 
	public static void main(String[] args) {	
		read_and_solve(System.in, System.out);		
	}
}